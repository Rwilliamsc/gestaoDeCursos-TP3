package br.edu.infnet.gestaodecursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GestaoDeCursosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoDeCursosApplication.class, args);
    }

}
