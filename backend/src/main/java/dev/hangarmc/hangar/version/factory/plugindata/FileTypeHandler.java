package dev.hangarmc.hangar.version.factory.plugindata;

import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.version.dependency.PluginDependency;
import org.jdbi.v3.core.internal.MemoizingSupplier;
import org.jspecify.annotations.Nullable;
import org.spongepowered.configurate.ConfigurateException;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;

public abstract class FileTypeHandler<D extends FileTypeHandler.FileData> {

    private final String fileName;
    private final Platform platform;

    FileTypeHandler(final String fileName, final Platform platform) {
        this.fileName = fileName;
        this.platform = platform;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Platform getPlatform() {
        return this.platform;
    }

    public abstract D getData(BufferedReader reader) throws ConfigurateException;

    public abstract static class FileData {

        private @Nullable String version;
        private @Nullable String name;
        private @Nullable String description;
        private @Nullable String author;
        private @Nullable Set<String> authors;

        @SuppressWarnings("java:S2065")
        private final transient MemoizingSupplier<Set<PluginDependency>> pluginDependencies = MemoizingSupplier.of(this::createPluginDependencies);

        public final @Nullable String getVersion() {
            return this.version;
        }

        public final @Nullable String getName() {
            return this.name;
        }

        public final @Nullable String getDescription() {
            return this.description;
        }

        protected abstract Set<PluginDependency> createPluginDependencies();

        public final Set<PluginDependency> getPluginDependencies() {
            return this.pluginDependencies.get();
        }

        public SortedSet<String> getPlatformDependencies() {
            return Collections.emptySortedSet();
        }

        public final Set<String> getAuthors() {
            if (this.author != null) {
                return Set.of(this.author);
            }
            return this.authors == null ? Collections.emptySet() : this.authors;
        }

        @Override
        public final String toString() {
            return "FileData{" +
                "version='" + this.version + '\'' +
                ", name='" + this.name + '\'' +
                ", pluginDependencies='" + this.getPluginDependencies() + '\'' +
                '}';
        }
    }
}
