package br.com.fiap.atividade1.business;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.atividade1.model.Pizza;
import br.com.fiap.atividade1.repository.PizzaRepository;

/**
 * The Class PizzaBusiness.
 */
@RestController
public class PizzaBusiness {
	
	/** The pizza repository. */
	@Autowired
	private PizzaRepository pizzaRepository;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Pizza> getAll() {
		return this.pizzaRepository.findAll();
	}
	
	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Pizza> get(Long id) {
		return this.pizzaRepository.findById(id);
	}

	/**
	 * Creates the.
	 *
	 * @param pizza the pizza
	 * @return the pizza
	 */
	public Pizza create(Pizza pizza) {
		Pizza newPizza = this.pizzaRepository.save(pizza);
		
		return newPizza;
	}

	/**
	 * Update.
	 *
	 * @param id the id
	 * @param newPizza the new pizza
	 * @return the optional
	 */
	public Optional<Pizza> update(long id, Pizza newPizza) {
		Optional<Pizza> oldPizza = pizzaRepository.findById(id);
        
        if(oldPizza.isPresent()){
            Pizza pizza = oldPizza.get();
            
            pizza.setName(newPizza.getName());
            pizza.setIngredients(newPizza.getIngredients());
            
            pizzaRepository.save(pizza);
            
            return Optional.of(pizza);
        }
            
		return Optional.empty();
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	public ResponseEntity<Object> delete(long id) {
		Optional<Pizza> pizza = this.pizzaRepository.findById(id);
		
        if(pizza.isPresent()) {
            pizzaRepository.delete(pizza.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}