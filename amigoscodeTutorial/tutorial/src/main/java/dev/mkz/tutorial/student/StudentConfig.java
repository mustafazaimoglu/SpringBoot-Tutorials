package dev.mkz.tutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mustafa = new Student(
                    "mustafa",
                    "mkz@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 5),
                    21
            );

            Student murat = new Student(
                    "minho",
                    "minho@gmail.com",
                    LocalDate.of(2000, Month.MARCH, 16),
                    22
            );


            repository.saveAll(
                    List.of(mustafa, murat)
            );
        };


    }
}
