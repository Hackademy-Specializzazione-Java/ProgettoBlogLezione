package it.aulab.progetto_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Carica l'intero spring context
public class ProgettoBlogApplication {

	public static void main(String[] args) {
		//Comando di run dell'applicazione
		SpringApplication.run(ProgettoBlogApplication.class, args);
	}

}
