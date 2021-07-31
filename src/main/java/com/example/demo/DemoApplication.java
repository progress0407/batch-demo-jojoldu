package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableBatchProcessing // 배치기능 활성화
@SpringBootApplication // (exclude = {DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) // jar 생성시 문제 DB설정 자동화..
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
