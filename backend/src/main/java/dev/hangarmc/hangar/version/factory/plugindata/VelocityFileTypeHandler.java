package dev.hangarmc.hangar.version.factory.plugindata;

import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import dev.hangarmc.hangar.version.factory.plugindata.VelocityFileTypeHandler.VelocityFileData;
import org.jspecify.annotations.Nullable;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class VelocityFileTypeHandler extends FileTypeHandler<VelocityFileData> {

    VelocityFileTypeHandler() {
        super("velocity-plugin.json", Platform.VELOCITY);
    }

    @Override
    public VelocityFileData getData(final BufferedReader reader) throws ConfigurateException {
        return JacksonConfigurationLoader.builder().buildAndLoadString(reader.lines().collect(Collectors.joining("\n"))).get(VelocityFileData.class);
    }

    @ConfigSerializable
    static class VelocityFileData extends FileTypeHandler.FileData {

        @Setting("dependencies")
        @Nullable
        private Set<Dependency> dependencies;

        @Override
        protected Set<PluginDependency> createPluginDependencies() {
            if (this.dependencies == null) {
                return Set.of();
            }
            return this.dependencies.stream().map(dependency -> new PluginDependency(dependency.id, !dependency.optional, Platform.VELOCITY)).collect(Collectors.toSet());
        }

        @ConfigSerializable
        record Dependency(String id, boolean optional) {}
    }
}
