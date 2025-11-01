CREATE TABLE platform_versions
(
    id         bigserial
        PRIMARY KEY,
    created_at timestamp with time zone NOT NULL,
    platform   bigint                   NOT NULL,
    version    varchar(255)             NOT NULL,
    CONSTRAINT platform_version_unique
        UNIQUE (platform, version)
);
