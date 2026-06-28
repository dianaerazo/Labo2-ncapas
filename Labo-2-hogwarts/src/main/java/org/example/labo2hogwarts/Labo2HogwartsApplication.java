package org.example.labo2hogwarts;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Labo2HogwartsApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        System.out.println(dotenv.get("DB_URL"));
        System.out.println(dotenv.get("DB_USERNAME"));
        System.out.println(dotenv.get("DB_PASSWORD"));

        SpringApplication.run(Labo2HogwartsApplication.class, args);
    }

}
