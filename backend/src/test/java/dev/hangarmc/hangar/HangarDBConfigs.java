package dev.hangarmc.hangar;

import org.jdbi.v3.core.config.JdbiConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@HangarConfigs
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({TestcontainersConfiguration.class, JdbiConfig.class})
public @interface HangarDBConfigs {
}
