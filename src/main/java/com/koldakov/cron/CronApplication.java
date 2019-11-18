package com.koldakov.cron;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.Date;
import java.util.TimeZone;

public class CronApplication {

    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());

        SimpleTriggerContext cronTriggerContext = new SimpleTriggerContext(date, date, date);
        CronTrigger cronTrigger = new CronTrigger("0 0 16 26 8 *", TimeZone.getTimeZone("UTC"));
        System.out.println(cronTrigger.nextExecutionTime(cronTriggerContext));


    }
}
