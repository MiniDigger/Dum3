import net.ltgt.gradle.errorprone.errorprone
import java.util.Locale

plugins {
	java
	id("org.springframework.boot") version "4.0.0-RC1"
	id("io.spring.dependency-management") version "1.1.7"
	id("net.ltgt.errorprone") version "4.3.0"
}

group = "dev.hangarmc"
version = "3.0.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springModulithVersion"] = "2.0.0-RC1"
extra["jdbiVersion"] = "3.49.6"
extra["configurateVersion"] = "4.2.0"
extra["springDocVersion"] = "3.0.0-M1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-flyway")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-opentelemetry")
	implementation("org.springframework.boot:spring-boot-starter-restclient")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-security-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.flywaydb:flyway-database-postgresql")
	implementation("org.springframework.modulith:spring-modulith-starter-core")
	implementation("org.springframework.modulith:spring-modulith-starter-jdbc")
	implementation("org.springframework.security:spring-security-webauthn")
	implementation("org.jdbi:jdbi3-spring")
	implementation("org.jdbi:jdbi3-postgres")
	implementation("org.jdbi:jdbi3-opentelemetry")
	implementation("org.jdbi:jdbi3-sqlobject")
	implementation("org.jdbi:jdbi3-jackson2")
	implementation("org.spongepowered:configurate-jackson")
	implementation("org.spongepowered:configurate-yaml")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${property("springDocVersion")}")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.springframework.modulith:spring-modulith-starter-insight")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-actuator-test")
	testImplementation("org.springframework.boot:spring-boot-starter-cache-test")
	testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
	testImplementation("org.springframework.boot:spring-boot-starter-mail-test")
	testImplementation("org.springframework.boot:spring-boot-starter-opentelemetry-test")
	testImplementation("org.springframework.boot:spring-boot-starter-restclient-test")
	testImplementation("org.springframework.boot:spring-boot-starter-security-oauth2-client-test")
	testImplementation("org.springframework.boot:spring-boot-starter-security-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.springframework.modulith:spring-modulith-starter-test")
	testImplementation("org.testcontainers:testcontainers-grafana")
	testImplementation("org.testcontainers:testcontainers-junit-jupiter")
	testImplementation("org.testcontainers:testcontainers-postgresql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	errorprone("com.uber.nullaway:nullaway:0.12.11")
	errorprone("com.google.errorprone:error_prone_core:2.43.0")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
		mavenBom("org.jdbi:jdbi3-bom:${property("jdbiVersion")}")
		mavenBom("org.spongepowered:configurate-bom:${property("configurateVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<JavaCompile> {
	options.compilerArgs.add("-parameters")
	options.errorprone {
		option("NullAway:OnlyNullMarked", "true")
		error("NullAway")
	}
	if (name.lowercase().contains("test")) {
		options.errorprone {
			disable("NullAway")
		}
	}
}
