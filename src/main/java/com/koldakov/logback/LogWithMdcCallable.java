package com.koldakov.logback;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.*;
import java.util.concurrent.*;

public class LogWithMdcCallable {
    private static final Logger log;

    static {
        System.setProperty("logback.configurationFile", "logback-mdc-callable.xml");
        log = LoggerFactory.getLogger(LogWithMdcCallable.class);
    }

    public static void main(String[] args) {
        MDC.put("logFileName", "mdc-callable-specific");

        // sequential call - WORKS FINE
        // parallel call - NOT WORKING
        runSimple();

        // sequential call - WORKS FINE
        // parallel call - WORKS FINE
        runWithMdc();

        MDC.remove("logFileName");
        log.info("DEFAULT log -> after all runs");
    }

    private static void runSimple() {
        //sequential call - WORKS FINE
        executeSequentially(getTasks("sequential", false));

        // parallel call - NOT WORKING
        executeInParallel(getTasks("parallel", false));
    }

    private static void runWithMdc() {
        // sequential call - WORKS FINE
        executeSequentially(getTasks("sequential", true));

        // parallel call - WORKS FINE
        executeInParallel(getTasks("parallel", true));
    }


    private static List<Callable<Void>> getTasks(String mode, boolean withMdc) {
        List<Callable<Void>> tasks = new ArrayList<>();
        Map<String, String> mdc = MDC.getCopyOfContextMap();
        Arrays.asList(1, 2)
                .forEach(taskNum ->
                        tasks.add(() -> {
                            if (withMdc) {
                                MDC.setContextMap(mdc);
                            }
                            log.info("SPECIFIC log -> {} with mdc task{}", mode, taskNum);
                            return null;
                        })
                );
        return tasks;
    }

    private static void executeSequentially(List<Callable<Void>> tasks) {
        try {
            for (Callable<Void> task : tasks) {
                task.call();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static void executeInParallel(List<Callable<Void>> tasks) {
        try {
            String threadName = Thread.currentThread().getName();
            final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat(threadName + "-taskName-%d").build();
            ExecutorService taskExecutor = Executors.newFixedThreadPool(2, threadFactory);
            taskExecutor.invokeAll(tasks);
            taskExecutor.shutdownNow();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
