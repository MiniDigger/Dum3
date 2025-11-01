package dev.hangarmc.hangar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.ConnectionFactory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.RowMapperFactory;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.jackson2.Jackson2Config;
import org.jdbi.v3.jackson2.Jackson2Plugin;
import org.jdbi.v3.opentelemetry.JdbiOpenTelemetryPlugin;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.spring.EnableJdbiRepositories;
import org.jdbi.v3.spring.SpringConnectionFactory;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableJdbiRepositories
class JdbiConfig {

    @Bean
    JdbiPlugin postgresPlugin() {
        return new PostgresPlugin();
    }

    @Bean
    JdbiPlugin jdbiOpenTelemetryPlugin() {
        return new JdbiOpenTelemetryPlugin();
    }

    @Bean
    JdbiPlugin sqlObjectPlugin() {
        return new SqlObjectPlugin();
    }

    @Bean
    JdbiPlugin jacksonPlugin() {
        return new Jackson2Plugin();
    }

    @Bean
    Jdbi jdbi(final DataSource ds, final List<JdbiPlugin> jdbiPlugins, final List<RowMapper<?>> rowMappers, final List<RowMapperFactory> rowMapperFactories, final List<ColumnMapper<?>> columnMappers, final ObjectMapper objectMapper) {
        final HikariConfig hc = new HikariConfig();
        hc.setDataSource(ds);
        hc.setMaximumPoolSize(6);

        final ConnectionFactory cf = new SpringConnectionFactory(new HikariDataSource(hc));
        final Jdbi jdbi = Jdbi.create(cf);

        jdbi.getConfig(Jackson2Config.class).setMapper(objectMapper);

        jdbiPlugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);
        rowMapperFactories.forEach(jdbi::registerRowMapper);
        columnMappers.forEach(jdbi::registerColumnMapper);

        return jdbi;
    }
}
