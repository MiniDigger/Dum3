package dev.hangarmc.hangar.version.factory;

import dev.hangarmc.hangar.HangarApiException;
import dev.hangarmc.hangar.platform.Platform;
import dev.hangarmc.hangar.util.CryptoUtils;
import dev.hangarmc.hangar.version.factory.PluginFile.PluginFileData;
import dev.hangarmc.hangar.version.factory.plugindata.FileTypeHandler;
import dev.hangarmc.hangar.version.factory.plugindata.FileTypeHandler.FileData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
class PluginDataService {

    private final Map<String, FileTypeHandler<? extends FileData>> pluginFileTypeHandlers = new HashMap<>();

    PluginDataService(final List<FileTypeHandler<?>> fileTypeHandlers) {
        for (final FileTypeHandler<?> fileTypeHandler : fileTypeHandlers) {
            this.pluginFileTypeHandlers.put(fileTypeHandler.getFileName(), fileTypeHandler);
        }
    }

    PluginFile loadMeta(String fileName, byte[] bytes) throws IOException {
        try (final Jar jar = this.openJar(fileName, new ByteArrayInputStream(bytes))) {
            final Map<Platform, FileData> fileDataMap = new EnumMap<>(Platform.class);

            JarEntry jarEntry;
            while ((jarEntry = jar.stream().getNextJarEntry()) != null && fileDataMap.size() < Platform.getValues().length) {
                final FileTypeHandler<?> fileTypeHandler = this.pluginFileTypeHandlers.get(jarEntry.getName());
                if (fileTypeHandler != null) {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(jar.stream(), StandardCharsets.UTF_8));
                    final FileTypeHandler.FileData fileData = fileTypeHandler.getData(reader);
                    fileDataMap.put(fileTypeHandler.getPlatform(), fileData);
                }
            }

            if (fileDataMap.isEmpty()) {
                throw new HangarApiException(HangarApiException.Message.VERSION_NEW_ERROR_META_NOT_FOUND);
            }

            PluginFileData data = new PluginFileData(fileDataMap);
            validate(data);
            return new PluginFile(jar.fileName(), bytes.length, CryptoUtils.sha256ToHex(bytes), data);
        }
    }

    void validate(PluginFileData pluginFileData) {
        if (pluginFileData.name() == null) {
            throw new HangarApiException(HttpStatus.BAD_REQUEST, HangarApiException.Message.VERSION_NEW_ERROR_INCOMPLETE, "name");
        } else if (pluginFileData.version() == null) {
            throw new HangarApiException(HttpStatus.BAD_REQUEST, HangarApiException.Message.VERSION_NEW_ERROR_INCOMPLETE, "version");
        } else if (pluginFileData.platformDependencies().isEmpty()) {
            throw new HangarApiException(HttpStatus.BAD_REQUEST, HangarApiException.Message.VERSION_NEW_ERROR_INCOMPLETE, "platform");
        }
    }

    Jar openJar(final String fileName, final InputStream file) throws IOException {
        if (fileName.endsWith(".jar")) {
            return new Jar(fileName, new JarInputStream(file));
        } else {
            final ZipInputStream stream = new ZipInputStream(file);

            ZipEntry zipEntry;
            while ((zipEntry = stream.getNextEntry()) != null) {
                final String name = zipEntry.getName();
                if (!zipEntry.isDirectory() && name.split("/").length == 1 && name.endsWith(".jar")) {
                    // todo what about multiple jars in one zip?
                    return new Jar(zipEntry.getName(), new JarInputStream(stream));
                }
            }

            throw new HangarApiException(HangarApiException.Message.VERSION_NEW_ERROR_JAR_NOT_FOUND);
        }
    }

    record Jar(String fileName, JarInputStream stream) implements AutoCloseable {
        @Override
        public void close() throws IOException {
            this.stream.close();
        }
    }
}
