package com.fse.springboot.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan({ "com.fse.springboot.assignment.task" })
public class SpringTaskConfig {

}
