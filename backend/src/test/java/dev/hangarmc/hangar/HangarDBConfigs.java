package dev.hangarmc.hangar;

import dev.hangarmc.hangar.config.JdbiConfig;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@HangarConfigs
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({JdbiConfig.class, DataSourceAutoConfiguration.class})
public @interface HangarDBConfigs {

}
