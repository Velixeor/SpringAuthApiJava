package com.example.tetst_api;

import com.example.tetst_api.Filters.AuthFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
public class TetstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TetstApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> registrationBean=new FilterRegistrationBean<>();
		AuthFilter authFilter=new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("api/categories/*");
		return registrationBean;
	}

}
