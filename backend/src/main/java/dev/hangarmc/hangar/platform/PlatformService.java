package dev.hangarmc.hangar.platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
class PlatformService {

    private static final Logger log = LoggerFactory.getLogger(PlatformService.class);
    private final RestClient restClient;
    private final PlatformDao platformDao;

    PlatformService(RestClient restClient, PlatformDao platformDao) {
        this.restClient = restClient;
        this.platformDao = platformDao;
    }

    @EventListener
    public void onContextRefreshed(final ContextRefreshedEvent event) {
        try {
            this.populate();
        } catch (final Exception e) {
            log.error("Failed to populate platform versions", e);
        }
    }

    int populate() {
        var fillResponse = this.restClient.post().uri("https://fill.papermc.io/graphql").body(Map.of("query", """
            {
               projects {
                 key
                 versions(first: 100) {
                   nodes {
                     key
                   }
                 }
               }
            }
            """)).retrieve().toEntity(FillResponseData.class);
        if (!fillResponse.getStatusCode().is2xxSuccessful() || !fillResponse.hasBody()) {
            throw new RuntimeException("Failed to populate platform versions, Fill returned " + fillResponse.getStatusCode() + ": " + fillResponse.getBody());
        }

        List<PlatformVersion> platformVersions = new ArrayList<>();
        for (final var project : Objects.requireNonNull(fillResponse.getBody()).data().projects()) {
            switch (project.key) {
                case "paper" -> project.versions.nodes.forEach(v -> platformVersions.add(new PlatformVersion(Platform.PAPER, v.key)));
                case "waterfall" -> project.versions.nodes.forEach(v -> platformVersions.add(new PlatformVersion(Platform.WATERFALL, v.key)));
                case "velocity" -> project.versions.nodes.forEach(v -> platformVersions.add(new PlatformVersion(Platform.VELOCITY, v.key)));
                case "folia" -> project.versions.nodes.forEach(v -> platformVersions.add(new PlatformVersion(Platform.FOLIA, v.key)));
            }
        }

        // remove pres and snapshots
        // https://regex101.com/r/JdIutj/1
        var pattern = Pattern.compile("^\\d+.\\d+(.\\d)?$");
        platformVersions.removeIf(t -> !pattern.matcher(t.version()).matches());

        int result = this.platformDao.insertAll(platformVersions);
        if (result > 0) {
            log.info("Populated 'platform_versions' table with {} new versions", result);
        } else {
            log.info("No new versions were added to the 'platform_versions' table");
        }
        return result;
    }

    record FillResponseData(Data data) {
        record Data(List<Project> projects) {
            record Project(String key, Nodes<Version> versions) {
                record Nodes<T>(List<T> nodes) {
                }
                record Version(String key) {
                }
            }
        }
    }
}
