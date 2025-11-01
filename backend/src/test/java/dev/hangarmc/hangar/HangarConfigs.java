package dev.hangarmc.hangar;

import dev.hangarmc.hangar.auth.SecurityConfig;
import dev.hangarmc.hangar.config.JacksonConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({JacksonConfig.class, SecurityConfig.class})
public @interface HangarConfigs {
}
