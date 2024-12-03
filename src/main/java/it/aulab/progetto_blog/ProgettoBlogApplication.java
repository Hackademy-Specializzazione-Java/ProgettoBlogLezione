package it.aulab.progetto_blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //Carica l'intero spring context
public class ProgettoBlogApplication {

	public static void main(String[] args) {
		//Comando di run dell'applicazione
		SpringApplication.run(ProgettoBlogApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper(){
		ModelMapper mapper = new ModelMapper();
		//in questa posizione vengono effettuati tutti i mapping extra del dto con DAO differenti
		return mapper;
	}

}
