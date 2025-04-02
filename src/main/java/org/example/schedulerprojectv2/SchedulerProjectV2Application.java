package org.example.schedulerprojectv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulerProjectV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerProjectV2Application.class, args);
    }

}
