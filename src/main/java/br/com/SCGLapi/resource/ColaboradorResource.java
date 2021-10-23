package br.com.SCGLapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import br.com.SCGLapi.model.Colaborador;
import br.com.SCGLapi.repository.ColaboradorRepository;
import br.com.SCGLapi.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired 
	private ColaboradorService colaboradorService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Colaborador> colaboradores = colaboradorRepository.findAll(Sort.by("colaboradorNome"));	
		return !colaboradores.isEmpty() ? ResponseEntity.ok(colaboradores) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Colaborador> buscaPeloId(@PathVariable Integer id) {
		return colaboradorRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Colaborador> criar(@RequestBody Colaborador colaborador, HttpServletResponse response) {
		Colaborador colaboradorBD = colaboradorRepository.save(colaborador);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(colaboradorBD.getColaboradorId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(colaboradorBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Colaborador colaborador) {
		Colaborador colaboradorGravado = colaboradorService.atualizar(id, colaborador);
		return ResponseEntity.ok(colaboradorGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		colaboradorRepository.deleteById(id);
	}
}
