package br.com.fiap.atividade1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.model.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class PizzaController.
 */
@RestController
@Slf4j
public class PizzaController {
	
	/** The pizza business. */
	@Autowired
	private PizzaBusiness pizzaBusiness;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public List<Pizza> getAll() {
		log.info("entrei no controller");
        return pizzaBusiness.getAll();
    }
	
	/**
	 * Gets the pizza.
	 *
	 * @param id the id
	 * @return the pizza
	 */
	@RequestMapping(value = "/pizza/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pizza> get(@PathVariable(value = "id") long id)
    {
        Optional<Pizza> pizza = pizzaBusiness.get(id);
        
        if(pizza.isPresent())
            return new ResponseEntity<Pizza>(pizza.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	/**
	 * Post.
	 *
	 * @param pizza the pizza
	 * @return the pizza
	 */
	@RequestMapping(value = "/pizza/create", method =  RequestMethod.POST)
    public Pizza create(@RequestBody Pizza pizza)
    {
		Pizza newPizza = pizzaBusiness.create(pizza);
		
        return newPizza;
    }

    /**
     * Put.
     *
     * @param id the id
     * @param newPizza the new pizza
     * @return the response entity
     */
    @RequestMapping(value = "/pizza/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pizza> update(@PathVariable(value = "id") long id, @RequestBody Pizza newPizza)
    {
    	Optional<Pizza> updatedPizza = this.pizzaBusiness.update(id, newPizza);
        
    	if(updatedPizza.isPresent()) {
    		return new ResponseEntity<Pizza>(updatedPizza.get(), HttpStatus.OK);
        }

    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/pizza/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id)
    {
    	return this.pizzaBusiness.delete(id);
    }
}