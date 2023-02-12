package com.adienerlopez.CorsoAmigos.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository ) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "mariam.jes@gmail.com",
                    LocalDate.of( 2000, JANUARY, 5 )
            );

            Student franco = new Student(
                    "Franco",
                    "franco.jes@gmail.com",
                    LocalDate.of( 2004, JANUARY, 5 )
            );

            Student rocco = new Student(
                    "Rocco",
                    "rocchino.jes@gmail.com",
                    LocalDate.of( 2004, JANUARY, 5 )
            );

            repository.saveAll(
                    List.of(maria, franco, rocco)
            );
        };
    }
}
