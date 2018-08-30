package com.drebate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(basePackages = {"com.drebate.dao"})
@ComponentScan(value = {"com.drebate"})
@EnableTransactionManagement
@EnableSwagger2
@SpringBootApplication
public class DRebateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DRebateApplication.class, args);
	}
}
