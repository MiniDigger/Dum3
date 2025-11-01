package dev.hangarmc.hangar.platform;

import org.jdbi.v3.spring.JdbiRepository;
import org.jdbi.v3.sqlobject.customizer.BindMethodsList;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Collection;

@JdbiRepository
interface PlatformDao {

    @SqlUpdate("INSERT INTO platform_versions (created_at, platform, version) VALUES <platformVersions> ON CONFLICT DO NOTHING")
    int insertAll(@BindMethodsList(methodNames = {"createdAt", "platform", "version"}) Collection<PlatformVersion> platformVersions);

}
