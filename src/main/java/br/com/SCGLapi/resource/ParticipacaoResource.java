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

import br.com.SCGLapi.model.Participacao;
import br.com.SCGLapi.repository.ParticipacaoRepository;
import br.com.SCGLapi.service.ParticipacaoService;


@RestController
@RequestMapping("/participacoes")
public class ParticipacaoResource {

	@Autowired
	private ParticipacaoRepository participacaoRepository;
	
	@Autowired 
	private ParticipacaoService participacaoService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Participacao> participacoes = participacaoRepository.findAll();	
		return !participacoes.isEmpty() ? ResponseEntity.ok(participacoes) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Participacao> buscaPeloId(@PathVariable Integer id) {
		return participacaoRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Participacao> criar(@RequestBody Participacao participacao, HttpServletResponse response) {
		Participacao participacaoBD = participacaoRepository.save(participacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(participacaoBD.getIdParticipacao()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(participacaoBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Participacao participacao) {
		Participacao participacaoGravada = participacaoService.atualizar(id, participacao);
		return ResponseEntity.ok(participacaoGravada);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		participacaoRepository.deleteById(id);
	}
}
