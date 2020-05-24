package com.paulocandido.atendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtendimentoApplication.class, args);
	}

	@Bean
	public Classe3 createClasse3(ClasseInjetavel ci){
		return new Classe3("teste", ci);
	}
}
