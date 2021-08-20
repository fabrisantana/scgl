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

import br.com.SCGLapi.model.Fisioterapeuta;
import br.com.SCGLapi.repository.FisioterapeutaRepository;
import br.com.SCGLapi.service.FisioterapeutaService;

@RestController
@RequestMapping("/fisioterapeutas")
public class FisioterapeutaResource {

	@Autowired
	private FisioterapeutaRepository fisioterapeutaRepository;
	
	@Autowired 
	private FisioterapeutaService fisioterapeutaService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<Fisioterapeuta> fisioterapeutas = fisioterapeutaRepository.findAll();	
		return !fisioterapeutas.isEmpty() ? ResponseEntity.ok(fisioterapeutas) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<Fisioterapeuta> buscaPeloId(@PathVariable Integer id) {
		return fisioterapeutaRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<Fisioterapeuta> criar(@RequestBody Fisioterapeuta fisioterapeuta, HttpServletResponse response) {
		Fisioterapeuta fisioterapeutaBD = fisioterapeutaRepository.save(fisioterapeuta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(fisioterapeutaBD.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(fisioterapeutaBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody Fisioterapeuta fisioterapeuta) {
		Fisioterapeuta fisioterapeutaGravado = fisioterapeutaService.atualizar(id, fisioterapeuta);
		return ResponseEntity.ok(fisioterapeutaGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		fisioterapeutaRepository.deleteById(id);
	}
}
