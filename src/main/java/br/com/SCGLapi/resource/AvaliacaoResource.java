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

import br.com.SCGLapi.model.Avaliacao;
import br.com.SCGLapi.repository.AvaliacaoRepository;
import br.com.SCGLapi.service.AvaliacaoService;


@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired 
	private AvaliacaoService avaliacaoService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();	
		return !avaliacoes.isEmpty() ? ResponseEntity.ok(avaliacoes) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Avaliacao> buscaPeloId(@PathVariable Integer id) {
		return avaliacaoRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Avaliacao> criar(@RequestBody Avaliacao avaliacao, HttpServletResponse response) {
		Avaliacao avaliacaoBD = avaliacaoRepository.save(avaliacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(avaliacaoBD.getIdAvaliacao()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(avaliacaoBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Avaliacao avaliacao) {
		Avaliacao avaliacaoGravada = avaliacaoService.atualizar(id, avaliacao);
		return ResponseEntity.ok(avaliacaoGravada);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		avaliacaoRepository.deleteById(id);
	}
}
