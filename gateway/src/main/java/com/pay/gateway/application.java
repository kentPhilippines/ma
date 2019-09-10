package com.pay.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.pay.gateway.*")
@ComponentScan(basePackages = "com.pay.gateway.*")
@EnableTransactionManagement
@EnableConfigurationProperties
public class application {
	public static void main(String[] args) {
		SpringApplication.run(application.class, args);
	}
}
