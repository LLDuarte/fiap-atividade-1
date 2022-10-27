package br.com.fiap.atividade1;

import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.dto.PizzaDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.Resource;
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
			pizzas.add(new PizzaDTO("Marguerita", new HashSet<>(Arrays.asList("Tomate", "Manjericão"))));
			pizzas.add(new PizzaDTO("Brasileira", new HashSet<>(Arrays.asList("Molho de tomate", "Requeijão", "Presunto", "Azeitonas pretas"))));
			pizzas.add(new PizzaDTO("Vegetariana", new HashSet<>(Arrays.asList("Champignon", "Pimentão verde", "Cebolinha"))));
			pizzas.add(new PizzaDTO("4 Queijos", new HashSet<>(Arrays.asList("Parmesão", "Provolone", "Cream Cheese", "Queijo Prato"))));

			pizzaBusiness.createBatch(pizzas);
		};
	}
}

