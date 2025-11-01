package dev.hangarmc.hangar.version.dependency;

import dev.hangarmc.hangar.platform.Platform;
import org.jspecify.annotations.Nullable;

public record PluginDependency(String name, @Nullable Long projectId, boolean required, @Nullable String externalUrl, Platform platform) {

    public PluginDependency(final String name, final boolean required, final Platform platform) {
        this(name, null, required, null, platform);
    }

    PluginDependency(final String name, final long projectId, final boolean required, final Platform platform) {
        this(name, projectId, required, null, platform);
    }
}
