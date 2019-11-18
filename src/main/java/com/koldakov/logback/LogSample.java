package com.koldakov.logback;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSample {

    public static void main(String[] args) {
        System.setProperty("logback.configurationFile", "logback-sample.xml");

        Logger log = LoggerFactory.getLogger(LogSample.class);
        log.info("Example log from {}", LogSample.class.getSimpleName());

        ch.qos.logback.classic.Logger parentLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.koldakov.logback");
        parentLogger.setLevel(Level.INFO);

        ch.qos.logback.classic.Logger childLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.koldakov.logback.test");

        parentLogger.warn("This message is logged because WARN > INFO.");
        parentLogger.debug("This message is not logged because DEBUG < INFO.");
        childLogger.info("INFO == INFO");
        childLogger.debug("DEBUG < INFO");
    }
}
