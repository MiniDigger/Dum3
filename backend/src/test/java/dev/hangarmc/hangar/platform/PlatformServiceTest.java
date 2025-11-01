package dev.hangarmc.hangar.platform;

import dev.hangarmc.hangar.platform.PlatformService.FillResponseData;
import dev.hangarmc.hangar.platform.PlatformService.FillResponseData.Data;
import dev.hangarmc.hangar.platform.PlatformService.FillResponseData.Data.Project;
import dev.hangarmc.hangar.platform.PlatformService.FillResponseData.Data.Project.Nodes;
import dev.hangarmc.hangar.platform.PlatformService.FillResponseData.Data.Project.Version;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ApplicationModuleTest
class PlatformServiceTest {

    @Autowired
    private PlatformService platformService;

    @MockitoBean(answers = Answers.RETURNS_DEEP_STUBS)
    private RestClient restClient;

    @MockitoBean
    private PlatformDao platformDao;

    @Test
    void populateShouldThrowWhenFillReturnsNon2xx() {
        when(restClient.post().uri(anyString()).body(any(Map.class)).retrieve().toEntity(FillResponseData.class))
                .thenReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));

        assertThatThrownBy(this.platformService::populate)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void populateShouldParseFillResponseAndCallDao() {
        var projects = List.of(
                new Project("paper", new Nodes<>(List.of(new Version("1.20"), new Version("1.20-pre")))),
                new Project("velocity", new Nodes<>(List.of(new Version("1.7")))),
                new Project("folia", new Nodes<>(List.of(new Version("2.0-SNAPSHOT")))),
                new Project("some-invalid", new Nodes<>(List.of(new Version("1.0"))))
        );
        var fakeBody = new FillResponseData(new Data(projects));

        when(restClient.post().uri(anyString()).body(any(Map.class)).retrieve().toEntity(FillResponseData.class))
                .thenReturn(ResponseEntity.ok(fakeBody));

        when(platformDao.insertAll(Mockito.anyCollection())).thenReturn(2);

        int result = this.platformService.populate();

        assertThat(result).isEqualTo(2);
    }
}
