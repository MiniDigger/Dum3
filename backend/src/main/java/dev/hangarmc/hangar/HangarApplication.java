package dev.hangarmc.hangar;

import org.jdbi.v3.spring.EnableJdbiRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJdbiRepositories
@SpringBootApplication
public class HangarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HangarApplication.class, args);
	}

}
