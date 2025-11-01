package dev.hangarmc.hangar.version.factory.plugindata;

import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import dev.hangarmc.hangar.version.factory.plugindata.PaperFileTypeHandler.PaperFileData;
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
class PaperFileTypeHandler extends FileTypeHandler<PaperFileData> {

    protected PaperFileTypeHandler() {
        super("paper-plugin.yml", Platform.PAPER);
    }

    @Override
    public PaperFileData getData(final BufferedReader reader) throws ConfigurateException {
        return YamlConfigurationLoader.builder().buildAndLoadString(reader.lines().collect(Collectors.joining("\n"))).get(PaperFileData.class);
    }

    @ConfigSerializable
    static class PaperFileData extends FileData {

        @Setting("dependencies")
        @Nullable
        private Map<String, Map<String, Dependency>> dependencies;
        @Setting("api-version")
        @Nullable
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
            if (this.dependencies != null) {
                for (final Map.Entry<String, Map<String, Dependency>> entry : this.dependencies.entrySet()) {
                    for (final Map.Entry<String, Dependency> dependencyEntry : entry.getValue().entrySet()) {
                        final String dependencyName = dependencyEntry.getKey();
                        final boolean required = dependencyEntry.getValue().required;
                        dependencies.add(new PluginDependency(dependencyName, required, Platform.PAPER));
                    }
                }
            }
            return dependencies;
        }

        @ConfigSerializable
        record Dependency(boolean required) {}
    }
}
