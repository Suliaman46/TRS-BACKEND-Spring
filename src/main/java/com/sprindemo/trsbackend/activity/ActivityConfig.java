package com.sprindemo.trsbackend.activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActivityConfig {
    @Bean
    CommandLineRunner commandLineRunnerForActivity(ActivityRepository activityRepository){
        return args->{
          Activity first = new Activity("ARGUS-123","nowak","Argus",125,Boolean.TRUE, List.of("database", "other"));
          Activity second = new Activity("ux","me","Front",105,Boolean.TRUE, List.of());
          activityRepository.saveAll(List.of(first,second));
        };

    }
}
