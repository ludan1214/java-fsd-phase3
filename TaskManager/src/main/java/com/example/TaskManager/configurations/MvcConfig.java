package com.example.TaskManager.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		/*
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/dashboard").setViewName("dashboard");
		registry.addViewController("/login").setViewName("login");*/
	}

}
