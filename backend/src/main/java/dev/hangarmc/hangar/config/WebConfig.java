package dev.hangarmc.hangar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverters;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        builder.defaultHeader("User-Agent", "Hangar <hangar@papermc.io>");
        builder.configureMessageConverters(HttpMessageConverters.Builder::registerDefaults);

        return builder.build();
    }
}
