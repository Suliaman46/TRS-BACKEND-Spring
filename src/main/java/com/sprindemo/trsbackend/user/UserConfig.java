package com.sprindemo.trsbackend.user;

import com.sprindemo.trsbackend.entry.Entry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User kowalski = new User("kowalski");
            User sul = new User("sul");
            kowalski.addEntry(new Entry("Argus-123",10, LocalDate.of(2022, 01, 01),"test1"));
            kowalski.addEntry(new Entry("Argus-123",12, LocalDate.of(2022, 01, 02),"test2"));
            kowalski.addEntry(new Entry("Argus-123",12, LocalDate.of(2022, 02, 02),"test2"));
            sul.addEntry(new Entry("Argus-123",12, LocalDate.of(2022, 01, 01),"test2"));
            repository.saveAll(List.of( kowalski,sul));
        };
    }
}
