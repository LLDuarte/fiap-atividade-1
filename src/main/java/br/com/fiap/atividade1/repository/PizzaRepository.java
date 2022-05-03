package br.com.fiap.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.atividade1.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
}