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

import br.com.SCGLapi.model.SessaoLaboral;
import br.com.SCGLapi.repository.SessaoLaboralRepository;
import br.com.SCGLapi.service.SessaoLaboralService;


@RestController
@RequestMapping("/sessoesLaborais")
public class SessaoLaboralResource {

	@Autowired
	private SessaoLaboralRepository sessaoLaboralRepository;
	
	@Autowired 
	private SessaoLaboralService sessaoLaboralService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<SessaoLaboral> sessoesLaborais = sessaoLaboralRepository.findAll();	
		return !sessoesLaborais.isEmpty() ? ResponseEntity.ok(sessoesLaborais) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<SessaoLaboral> buscaPeloId(@PathVariable Integer id) {
		return sessaoLaboralRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<SessaoLaboral> criar(@RequestBody SessaoLaboral sessaoLaboral, HttpServletResponse response) {
		SessaoLaboral sessaoLaboralBD = sessaoLaboralRepository.save(sessaoLaboral);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(sessaoLaboralBD.getIdSessaoLaboral()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(sessaoLaboralBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody SessaoLaboral sessaoLaboral) {
		SessaoLaboral sessaoLaboralGravada = sessaoLaboralService.atualizar(id, sessaoLaboral);
		return ResponseEntity.ok(sessaoLaboralGravada);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		sessaoLaboralRepository.deleteById(id);	
	}
}
