package com.ssafy.rest;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.rest.model.dao") // 이건 사실 별도의 config 자바로 빼는게 좋긴 함.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
