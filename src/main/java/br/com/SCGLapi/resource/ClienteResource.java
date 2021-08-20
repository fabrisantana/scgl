package br.com.SCGLapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.SCGLapi.model.Cliente;
import br.com.SCGLapi.repository.ClienteRepository;
import br.com.SCGLapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private ClienteService clienteService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Cliente> clientes = clienteRepository.findAll();	
		return !clientes.isEmpty() ? ResponseEntity.ok(clientes) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Cliente> buscaPeloId(@PathVariable Integer id) {
		return clienteRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteBD = clienteRepository.save(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(clienteBD.getClienteId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(clienteBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteGravado = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		clienteRepository.deleteById(id);
	}
}
