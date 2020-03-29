package com.janejazzy.springschedulledtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   //The @EnableScheduling annotation ensures that a background task executor is created. Without it, nothing gets scheduled.
public class OutsiderSchedullingTasksApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(OutsiderSchedullingTasksApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OutsiderSchedullingTasksApplication.class, args);

        LOGGER.info("spring-schedulling-tasks");
        LOGGER.info("---------------------------------------");
    }
}