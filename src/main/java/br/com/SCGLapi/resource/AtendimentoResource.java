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

import br.com.SCGLapi.model.Atendimento;
import br.com.SCGLapi.repository.AtendimentoRepository;
import br.com.SCGLapi.service.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoRepository AtendimentoRepository;
	
	@Autowired 
	private AtendimentoService AtendimentoService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Atendimento> Atendimentos = AtendimentoRepository.findAll();	
		return !Atendimentos.isEmpty() ? ResponseEntity.ok(Atendimentos) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Atendimento> buscaPeloId(@PathVariable Integer id) {
		return AtendimentoRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Atendimento> criar(@RequestBody Atendimento Atendimento, HttpServletResponse response) {
		Atendimento AtendimentoBD = AtendimentoRepository.save(Atendimento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(AtendimentoBD.getIdAtendimento()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(AtendimentoBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Atendimento Atendimento) {
		Atendimento AtendimentoGravado = AtendimentoService.atualizar(id, Atendimento);
		return ResponseEntity.ok(AtendimentoGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		AtendimentoRepository.deleteById(id);
	}
}
