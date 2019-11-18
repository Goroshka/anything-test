package com.koldakov.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWithRefresh {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("logback.configurationFile", "logback-refresh.xml");

        Logger log = LoggerFactory.getLogger(LogSample.class);

        /*
         * Change logback-refresh.xml in target (on classpath!)
         */

        while (true) {
            log.debug("Example log from {}, debug", LogSample.class.getSimpleName());
            log.info("Example log from {}, info", LogSample.class.getSimpleName());
            Thread.sleep(5000);
        }
    }
}
