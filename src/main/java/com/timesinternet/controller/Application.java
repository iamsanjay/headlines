package com.timesinternet.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.timesinternet")
public class Application {
	public static void main(String args[]){
		SpringApplication.run(Application.class, args);
	}
}
