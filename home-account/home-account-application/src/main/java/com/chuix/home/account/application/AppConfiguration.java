package com.chuix.home.account.application;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableWebMvc
@Configuration
@ComponentScan(
	basePackages = {
		"com.chuix.home.account",
		"com.chuix.home.account.domain"
	})	

@EnableJpaRepositories(basePackages = "com.chuix.home.account.infrastructure.persistence")
@EntityScan(basePackages = {
		"com.chuix.home.account.infrastructure.persistence.entity"
	})
public class AppConfiguration implements WebMvcConfigurer{

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }
}
