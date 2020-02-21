package com.koldakov.springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBasicApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basic.xml");

        BasicBean basicBean = context.getBean(BasicBean.class);
        System.out.println("Existing property = " + basicBean.getExistingProperty());
        System.out.println("Non-existing property = " + basicBean.getNotExistingProperty());
    }
}
