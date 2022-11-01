package com.ssafy.rest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration // spring bean configuration 파일, (root=context.xml) 파일을 대신하는 자바, 스프링 객체 저장소
@MapperScan(basePackages = "com.ssafy.rest.model.dao")
public class DatabaseConfig {
	
}
