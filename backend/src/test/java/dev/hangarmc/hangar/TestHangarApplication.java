package dev.hangarmc.hangar;

import org.springframework.boot.SpringApplication;

public class TestHangarApplication {

	public static void main(String[] args) {
		SpringApplication.from(HangarApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
