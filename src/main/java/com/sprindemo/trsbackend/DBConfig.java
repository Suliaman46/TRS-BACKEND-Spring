package com.sprindemo.trsbackend;

import com.sprindemo.trsbackend.entry.EntryRepository;
import com.sprindemo.trsbackend.user.User;
import com.sprindemo.trsbackend.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
//public class DBConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepo, EntryRepository entryRepo){
//        return args -> {
//            User kowalski = new User("kowalski");
//            User sul = new User("sul");
//            repository.saveAll(List.of( kowalski,sul));
//        };
//    }
//
//}
