package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestEntregadorApplication {

	public static void main(String[] args) {
		SpringApplication.from(EntregadorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
