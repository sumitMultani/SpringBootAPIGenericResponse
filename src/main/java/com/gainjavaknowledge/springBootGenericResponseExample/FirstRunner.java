package com.gainjavaknowledge.springBootGenericResponseExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("First Runner excecuted successfully.");
    }
}
