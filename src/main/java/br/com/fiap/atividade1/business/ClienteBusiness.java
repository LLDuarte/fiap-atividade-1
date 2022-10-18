package br.com.fiap.atividade1.business;


import br.com.fiap.atividade1.dto.ClienteDTO;
import br.com.fiap.atividade1.model.Cliente;
import br.com.fiap.atividade1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Cliente business.
 */
@RestController
public class ClienteBusiness {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Gets all.
	 *
	 * @return the all
	 */
	public List<ClienteDTO> getAll() {
		return this.clienteRepository.findAllDTO();
	}

	/**
	 * Get cliente dto.
	 *
	 * @param id the id
	 * @return the cliente dto
	 */
	public ClienteDTO get(Long id) {
		return this.clienteRepository.findByIdDTO(id);
	}

	/**
	 * Create cliente dto.
	 *
	 * @param dto the dto
	 * @return the cliente dto
	 */
	public ClienteDTO create(ClienteDTO dto) {
		Cliente entity = new Cliente();

		this.mapDtoToEntity(dto, entity);

		Cliente Cliente = this.clienteRepository.save(entity);

		return new ClienteDTO(Cliente);
	}

	/**
	 * Update cliente dto.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the cliente dto
	 */
	public ClienteDTO update(long id, ClienteDTO dto) {
		Cliente oldCliente = clienteRepository.findById(id).orElse(null);

		if(oldCliente == null) return null;

		mapDtoToEntity(dto, oldCliente);

		clienteRepository.save(oldCliente);

		return new ClienteDTO(oldCliente);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	public ResponseEntity<Object> delete(long id) {
		Optional<Cliente> Cliente = this.clienteRepository.findById(id);

		if(Cliente.isPresent()) {
			clienteRepository.delete(Cliente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	/**
	 * Map dto to entity.
	 *
	 * @param dto the dto
	 */
	private void mapDtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCelular(dto.getCelular());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setBairro(dto.getBairro());
		entity.setCidade(dto.getCidade());
		entity.setComplemento(dto.getComplemento());
	}
}