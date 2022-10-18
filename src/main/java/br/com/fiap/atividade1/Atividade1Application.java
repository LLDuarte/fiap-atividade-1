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
			List<PizzaDTO> pizzas = new ArrayList();

			pizzas.add(new PizzaDTO("Calabresa", new HashSet<>(Arrays.asList("Calabresa", "Cebola", "Azeitonas verdes", "Queijo"))));
			pizzas.add(new PizzaDTO("Marguerita", new HashSet<>(Arrays.asList("Queijo", "Tomate", "Manjericão"))));
			pizzas.add(new PizzaDTO("Queijo", new HashSet<>(Arrays.asList("Queijo", "Tomate"))));
			pizzas.add(new PizzaDTO("Napolitana", new HashSet<>(Arrays.asList("Parmesão", "Tomate", "Orégano", "Alho"))));
			pizzas.add(new PizzaDTO("Calabria", new HashSet<>(Arrays.asList("Calabresa", "Cebola", "Queijo", "Orégano"))));
			pizzas.add(new PizzaDTO("Pepperoni", new HashSet<>(Arrays.asList("Pepperoni", "Queijo", "Requeijão"))));
			pizzas.add(new PizzaDTO("Brasileira", new HashSet<>(Arrays.asList("Molho de tomate", "Requeijão", "Presunto", "Azeitonas verdes"))));
			pizzas.add(new PizzaDTO("Vegetariana", new HashSet<>(Arrays.asList("Molho de tomate", "Queijo", "Tomate", "Champignon", "Pimentão verde", "Cebola", "Azeitonas verdes"))));
			pizzas.add(new PizzaDTO("4 Queijos", new HashSet<>(Arrays.asList("Queijo", "Parmesão", "Provolone", "Cream Cheese"))));

			pizzaBusiness.createBatch(pizzas);
		};
	}
}

