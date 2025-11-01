package dev.hangarmc.hangar.version.factory;

import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import dev.hangarmc.hangar.version.factory.plugindata.FileTypeHandler.FileData;
import org.jspecify.annotations.Nullable;

import java.util.*;

record PluginFile(String fileName, int fileSize, String sha256, PluginFileData data) {

    record PluginFileData(@Nullable String version, @Nullable String name, @Nullable String description, Map<Platform, Set<String>> authors,
                          Map<Platform, Set<PluginDependency>> pluginDependencies,
                          Map<Platform, SortedSet<String>> platformDependencies) {

        PluginFileData(final Map<Platform, FileData> fileDataMap) {
            this(fileDataMap.values().stream().map(FileData::getVersion).filter(Objects::nonNull).findAny().orElse(null),
                    fileDataMap.values().stream().map(FileData::getName).filter(Objects::nonNull).findAny().orElse(null),
                    fileDataMap.values().stream().map(FileData::getDescription).filter(Objects::nonNull).findAny().orElse(null),
                    new EnumMap<>(Platform.class),
                    new EnumMap<>(Platform.class),
                    new EnumMap<>(Platform.class));
            fileDataMap.forEach((platform, fileData) -> {
                this.authors.put(platform, fileData.getAuthors());
                this.pluginDependencies.put(platform, fileData.getPluginDependencies());
                this.platformDependencies.put(platform, fileData.getPlatformDependencies());
            });
        }
    }
}
