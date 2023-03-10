package com.adienerlopez.CorsoAmigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CorsoAmigosApplication {

    public static void main( String[] args ) {

        SpringApplication.run( CorsoAmigosApplication.class, args );
    }
    
    @GetMapping("")
    public String hello() {
        return "HELLOOOOOOO";
    }

}
