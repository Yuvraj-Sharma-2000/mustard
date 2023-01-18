package com.example.mustard.config;

import com.example.mustard.entity.Student;
import com.example.mustard.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
//    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args -> {
            Student kartik = new Student("Kartik Kumar","ETC", LocalDate.of(2007, JANUARY,3));
            Student yuvraj = new Student("Yuvraj Sharma","CSE", LocalDate.of(2012, MARCH,30));
            Student anoop = new Student("Anoop kumar","TCS", LocalDate.of(2022, DECEMBER,7));

            repo.saveAll(List.of(kartik,yuvraj,anoop));
        };
    }
}
