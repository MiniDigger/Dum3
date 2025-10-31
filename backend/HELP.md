# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0-RC1/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.0-RC1/gradle-plugin/packaging-oci-image.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/testing/testcontainers.html#testing.testcontainers)
* [Testcontainers Grafana Module Reference Guide](https://java.testcontainers.org/modules/grafana/)
* [Testcontainers Postgres Module Reference Guide](https://java.testcontainers.org/modules/databases/postgres/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/using/devtools.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/4.0.0-RC1/specification/configuration-metadata/annotation-processor.html)
* [Spring Modulith](https://docs.spring.io/spring-modulith/reference/)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/web/servlet.html)
* [HTTP Client](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/io/rest-client.html#io.rest-client.restclient)
* [Spring Security](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/web/spring-security.html)
* [OAuth2 Client](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/web/spring-security.html#web.security.oauth2.client)
* [WebAuthn for Spring Security](https://docs.spring.io/spring-security/reference/servlet/authentication/passkeys.html)
* [Flyway Migration](https://docs.spring.io/spring-boot/4.0.0-RC1/how-to/data-initialization.html#howto.data-initialization.migration-tool.flyway)
* [Java Mail Sender](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/io/email.html)
* [Spring Cache Abstraction](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/io/caching.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/actuator/index.html)
* [OpenTelemetry](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/actuator/observability.html#actuator.observability.opentelemetry)
* [Testcontainers](https://java.testcontainers.org/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/4.0.0-RC1/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

* [`grafana/otel-lgtm:latest`](https://hub.docker.com/r/grafana/otel-lgtm)
* [`postgres:latest`](https://hub.docker.com/_/postgres)

Please review the tags of the used images and set them to the same as you're running in production.

