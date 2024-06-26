package com.platform.tutorgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TutorGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorGoApplication.class, args);
    }

}
