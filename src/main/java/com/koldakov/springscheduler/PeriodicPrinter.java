package com.koldakov.springscheduler;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("periodicPrinter")
public class PeriodicPrinter {

    public void printLine() {
        System.out.println("!!! I am called by spring scheduler at " + LocalDateTime.now());
    }
}
