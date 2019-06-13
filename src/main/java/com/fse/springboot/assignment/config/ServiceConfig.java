package com.fse.springboot.assignment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.fse.springboot.assignment.service" })
public class ServiceConfig {
}
