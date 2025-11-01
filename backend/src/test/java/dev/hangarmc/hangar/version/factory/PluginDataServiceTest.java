package dev.hangarmc.hangar.version.factory;

import dev.hangarmc.hangar.HangarApiException;
import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import dev.hangarmc.hangar.version.factory.PluginFile.PluginFileData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("resource")
@ApplicationModuleTest
class PluginDataServiceTest {

    private static final Path path = Path.of("src/test/resources/dev/hangarmc/hangar/version/factory/plugindata");

    private final PluginDataService classUnderTest;

    PluginDataServiceTest(PluginDataService classUnderTest) {
        this.classUnderTest = classUnderTest;
    }

    @Test
    void testLoadBukkitPluginMetadata() throws Exception {
        final PluginFileData data = this.classUnderTest.loadMeta("Bukkit.jar", Files.newInputStream(path.resolve("Bukkit.jar")).readAllBytes()).data();

        assertEquals("Maintenance", data.name());
        assertEquals("Enable maintenance mode with a custom maintenance motd and icon.", data.description());
        assertEquals("3.0.5", data.version());
        assertIterableEquals(List.of("KennyTV"), data.authors().get(Platform.PAPER));

        final Set<PluginDependency> deps = data.pluginDependencies().get(Platform.PAPER);
        assertThat(deps).hasSize(3);
        assertThat(deps).extracting(PluginDependency::name).containsExactlyInAnyOrder("ProtocolLib", "ServerListPlus", "ProtocolSupport");
        assertThat(deps).extracting(PluginDependency::required).containsOnly(false);

        assertIterableEquals(Set.of("1.13"), data.platformDependencies().get(Platform.PAPER));
    }

    @Test
    void testLoadPaperPluginMetadata() throws Exception {
        final PluginFileData data = this.classUnderTest.loadMeta("Paper.jar", Files.newInputStream(path.resolve("Paper.jar")).readAllBytes()).data();

        assertEquals("Maintenance", data.name());
        assertEquals("Enable maintenance mode with a custom maintenance motd and icon.", data.description());
        assertEquals("3.0.5", data.version());
        assertIterableEquals(List.of("KennyTV"), data.authors().get(Platform.PAPER));

        final Set<PluginDependency> deps = data.pluginDependencies().get(Platform.PAPER);
        assertThat(deps).hasSize(3);
        assertThat(deps).extracting(PluginDependency::name).containsExactlyInAnyOrder("ProtocolLib", "ServerListPlus", "ProtocolSupport");
        assertThat(deps).extracting(PluginDependency::required).containsExactlyInAnyOrder(true, false, false);

        assertIterableEquals(Set.of("1.13"), data.platformDependencies().get(Platform.PAPER));
    }

    @Test
    void testLoadWaterfallPluginMetadata() throws Exception {
        final PluginFileData data = this.classUnderTest.loadMeta("Waterfall.jar", Files.newInputStream(path.resolve("Waterfall.jar")).readAllBytes()).data();

        assertEquals("Maintenance", data.name());
        assertEquals("Enable maintenance mode with a custom maintenance motd and icon.", data.description());
        assertEquals("3.0.5", data.version());
        assertIterableEquals(List.of("KennyTV"), data.authors().get(Platform.WATERFALL));

        final Set<PluginDependency> deps = data.pluginDependencies().get(Platform.WATERFALL);
        assertThat(deps)
                .hasSize(2)
                .anyMatch(pd -> pd.name().equals("ServerListPlus") && !pd.required())
                .anyMatch(pd -> pd.name().equals("SomePlugin") && pd.required());
    }

    @Test
    void testLoadVelocityPluginMetadata() throws Exception {
        final PluginFileData data = this.classUnderTest.loadMeta("Velocity.jar", Files.newInputStream(path.resolve("Velocity.jar")).readAllBytes()).data();

        assertEquals("Maintenance", data.name());
        assertEquals("Enable maintenance mode with a custom maintenance motd and icon.", data.description());
        assertEquals("3.0.5", data.version());
        assertIterableEquals(List.of("KennyTV"), data.authors().get(Platform.VELOCITY));

        final Set<PluginDependency> deps = data.pluginDependencies().get(Platform.VELOCITY);
        assertThat(deps)
                .hasSize(1)
                .anyMatch(pd -> pd.name().equals("serverlistplus") && !pd.required());
    }

    @Test
    void testLoadPaperPluginZipMetadata() throws Exception {
        final PluginFileData data = this.classUnderTest.loadMeta("TestZip.zip", Files.newInputStream(path.resolve("TestZip.zip")).readAllBytes()).data();

        assertEquals("Maintenance", data.name());
        assertEquals("Enable maintenance mode with a custom maintenance motd and icon.", data.description());
        assertEquals("3.0.5", data.version());
        assertIterableEquals(List.of("KennyTV"), data.authors().get(Platform.PAPER));

        final Set<PluginDependency> deps = data.pluginDependencies().get(Platform.PAPER);
        assertThat(deps).hasSize(3);
        assertThat(deps).extracting(PluginDependency::name).containsExactlyInAnyOrder("ProtocolLib", "ServerListPlus", "ProtocolSupport");
        assertThat(deps).extracting(PluginDependency::required).containsOnly(false);

        assertIterableEquals(Set.of("1.13"), data.platformDependencies().get(Platform.PAPER));
    }

    @ParameterizedTest
    @CsvSource({
            "EmptyMeta.jar,Plugin file missing name",
            "Empty.zip,Could not open jar file"
    })
    void testLoadMetaShouldFail(final String jarName, final String expectedMsg) {
        assertThatExceptionOfType(HangarApiException.class)
                .isThrownBy(() -> this.classUnderTest.loadMeta(jarName, Files.newInputStream(path.resolve(jarName)).readAllBytes()))
                .withMessage("400 BAD_REQUEST: " + expectedMsg);
    }

    @Test
    void validate() {
        assertThatExceptionOfType(HangarApiException.class)
                .isThrownBy(() -> this.classUnderTest.validate(new PluginFileData(null, "Name", "Desc", Map.of(), Map.of(), Map.of())))
                .withMessage("400 BAD_REQUEST: Plugin file missing version");
        assertThatExceptionOfType(HangarApiException.class)
                .isThrownBy(() -> this.classUnderTest.validate(new PluginFileData("Version", null, "Desc", Map.of(), Map.of(), Map.of())))
                .withMessage("400 BAD_REQUEST: Plugin file missing name");
        assertThatExceptionOfType(HangarApiException.class)
                .isThrownBy(() -> this.classUnderTest.validate(new PluginFileData("Version", "Name", "Desc", Map.of(), Map.of(), Map.of())))
                .withMessage("400 BAD_REQUEST: Plugin file missing platform");
    }
}
