package com.koldakov.springcron;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.Date;
import java.util.TimeZone;

/**
 * Spring Scheduled tasks are not in the same format as cron expressions.
 * They don't follow the same format as UNIX cron expressions.
 *
 * Must be of CronSequenceGenerator format
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
 * (second, minute, hour, day, month, weekday)
 *
 */
public class SpringCronApplication {

    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());

        SimpleTriggerContext cronTriggerContext = new SimpleTriggerContext(date, date, date);
        CronTrigger cronTrigger = new CronTrigger("0 0 16 26 8 *", TimeZone.getTimeZone("UTC"));
        System.out.println(cronTrigger.nextExecutionTime(cronTriggerContext));
    }
}
