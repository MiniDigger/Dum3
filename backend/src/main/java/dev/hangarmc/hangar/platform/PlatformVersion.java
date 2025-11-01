package dev.hangarmc.hangar.platform;

import org.jdbi.v3.core.enums.EnumByOrdinal;

import java.time.OffsetDateTime;

public record PlatformVersion(long id, OffsetDateTime createdAt, @EnumByOrdinal Platform platform, String version) {

    PlatformVersion(@EnumByOrdinal Platform platform, String version) {
        this(-1, OffsetDateTime.now(), platform, version);
    }
}
