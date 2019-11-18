package com.koldakov.springscheduler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSchedulerApplication {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-scheduler.xml")) {
            context.registerShutdownHook();
        }
    }
}
