package com.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"com.bigdata"})
@SpringBootApplication
public class SpringBigDataApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBigDataApplication.class, args);
    }

   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }
}
