package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableBatchProcessing // 배치기능 활성화
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {

		Hello hello = new Hello();

		hello.setName("hi");
		System.out.println("hello.getName() = " + hello.getName());

		SpringApplication.run(DemoApplication.class, args);
	}

}
