package org.example.labo2hogwarts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Labo2HogwartsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Labo2HogwartsApplication.class);
        app.addInitializers(new org.example.labo2hogwarts.config.DotenvInitializer());
        app.run(args);
    }

}
