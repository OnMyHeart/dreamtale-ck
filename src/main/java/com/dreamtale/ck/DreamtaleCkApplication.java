package com.dreamtale.ck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.dreamtale"})
@ServletComponentScan(value = {"com.dreamtale"})
@MapperScan(value = {"com.dreamtale.ck.mapper"})
public class DreamtaleCkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamtaleCkApplication.class, args);
	}
}
