package dev.hangarmc.hangar.version.factory.plugindata;

import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import dev.hangarmc.hangar.version.factory.plugindata.BukkitFileTypeHandler.BukkitFileData;
import org.jspecify.annotations.Nullable;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;


@Component
class BukkitFileTypeHandler extends FileTypeHandler<BukkitFileData> {

    protected BukkitFileTypeHandler() {
        super("plugin.yml", Platform.PAPER);
    }

    @Override
    public BukkitFileData getData(final BufferedReader reader) throws ConfigurateException {
        return YamlConfigurationLoader.builder().buildAndLoadString(reader.lines().collect(Collectors.joining("\n"))).get(BukkitFileData.class);
    }

    @ConfigSerializable
    static class BukkitFileData extends FileTypeHandler.FileData {

        @Nullable
        @Setting("depend")
        private List<String> hardDepends;
        @Nullable
        @Setting("softdepend")
        private List<String> softDepends;
        @Nullable
        @Setting("api-version")
        private String apiVersion;

        @Override
        public SortedSet<String> getPlatformDependencies() {
            final SortedSet<String> platformVersions = new TreeSet<>();
            if (this.apiVersion != null) {
                platformVersions.add(this.apiVersion);
            }
            return platformVersions;
        }

        @Override
        protected Set<PluginDependency> createPluginDependencies() {
            final Set<PluginDependency> dependencies = new HashSet<>();
            if (this.hardDepends != null) {
                for (final String hardDepend : this.hardDepends) {
                    dependencies.add(new PluginDependency(hardDepend, true, Platform.PAPER));
                }
            }
            if (this.softDepends != null) {
                for (final String softDepend : this.softDepends) {
                    dependencies.add(new PluginDependency(softDepend, false, Platform.PAPER));
                }
            }
            return dependencies;
        }
    }
}
