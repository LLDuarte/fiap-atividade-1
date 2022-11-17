package br.com.fiap.atividade1;

import br.com.fiap.atividade1.business.ClienteBusiness;
import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.dto.ClienteDTO;
import br.com.fiap.atividade1.dto.PizzaDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class Atividade1Application {

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	}

	@Bean
	CommandLineRunner run(PizzaBusiness pizzaBusiness, ClienteBusiness clienteBusiness) {
		return args -> {
			List<PizzaDTO> pizzas = new ArrayList();

			pizzas.add(new PizzaDTO(1L, "Calabresa", new HashSet<>(Arrays.asList("Calabresa", "Cebola", "Azeitonas verdes")) ));
			pizzas.add(new PizzaDTO(2L, "Mussarela", new HashSet<>(Arrays.asList("Alho", "Queijo Mussarela"))));
			pizzas.add(new PizzaDTO(3L, "Marguerita", new HashSet<>(Arrays.asList("Mussarela", "Tomate", "Manjericão"))));
			pizzas.add(new PizzaDTO(4L, "Brasileira", new HashSet<>(Arrays.asList("Requeijão", "Presunto", "Azeitonas pretas"))));
			pizzas.add(new PizzaDTO(5L, "Vegetariana", new HashSet<>(Arrays.asList("Champignon", "Pimentão verde", "Cebolinha"))));
			pizzas.add(new PizzaDTO(6L, "4 Queijos", new HashSet<>(Arrays.asList("Queijo Parmesão", "Provolone", "Cream Cheese", "Queijo Prato"))));
			pizzas.add(new PizzaDTO(7L, "Napolitana", new HashSet<>(Arrays.asList("Molho Marinara", "Queijo Gorgonzola"))));
			pizzas.add(new PizzaDTO(8L, "Calabria", new HashSet<>(Arrays.asList("Linguiça Calabresa", "Rúcula"))));
			pizzas.add(new PizzaDTO(9L, "Pepperoni", new HashSet<>(Arrays.asList("Pepperoni", "Molho de tomate"))));

			pizzaBusiness.createBatch(pizzas);

			ClienteDTO cliente = new ClienteDTO(
				1L,
				"cliente 1",
				"999999999",
				"email@email.com",
				"endereco generico",
				10,
				"bairro",
				"cidade"
			);

			clienteBusiness.create(cliente);
		};
	}
}

