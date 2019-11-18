package com.koldakov.springbeans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(value = "prototype")
public class AllStrategiesExampleBean implements InitializingBean {

    public AllStrategiesExampleBean() {
        log("Constructor");
    }

    @Override
    public void afterPropertiesSet() {
        log("InitializingBean");
    }

    @PostConstruct
    public void postConstruct() {
        log("PostConstruct");
    }

    public void init() {
        log("init-method");
    }

    private void log(String message) {
        System.out.println(message);
    }
}
