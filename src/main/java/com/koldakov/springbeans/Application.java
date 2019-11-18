package com.koldakov.springbeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.koldakov.springbeans")) {
//            context.refresh();
//            context.scan("com.koldakov.springbeans");
            context.getBean(AllStrategiesExampleBean.class);
        }
    }
}
