package com.dreamtale.ck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.dreamtale"})
@ServletComponentScan(value = {"com.dreamtale"})
@MapperScan(value = {"com.dreamtale.ck.mapper"})
@EnableAutoConfiguration
public class DreamCkApp {

	public static void main(String[] args) {
		SpringApplication.run(DreamCkApp.class, args);
	}
}
