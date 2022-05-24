package br.com.fiap.atividade1;

import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.dto.PizzaDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Atividade1Application {

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	}

	@Bean
	CommandLineRunner run(PizzaBusiness pizzaBusiness) {
		return args -> {
			PizzaDTO dto = new PizzaDTO("Frango com Catupiry", new HashSet<>(Arrays.asList("Molho de tomate", "Frango", "Catupiry")));

			pizzaBusiness.create(dto);

			dto = new PizzaDTO("Calabresa", new HashSet<>(Arrays.asList("Calabresa", "Cebola", "Orégano")));

			pizzaBusiness.create(dto);
		};
	}
}
