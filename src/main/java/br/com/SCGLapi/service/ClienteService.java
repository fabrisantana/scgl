package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Cliente;
import br.com.SCGLapi.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Integer id, Cliente cliente) {
		Optional<Cliente> clienteGravado = clienteRepository.findById(id);
		
		if(!clienteGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Cliente clienteTemp = clienteGravado.get();
		BeanUtils.copyProperties(cliente, clienteTemp, "id");
		clienteRepository.save(clienteTemp);
		return clienteRepository.save(clienteTemp);	
	}
}
