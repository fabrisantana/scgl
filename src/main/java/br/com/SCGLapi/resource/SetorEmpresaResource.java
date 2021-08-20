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

import br.com.SCGLapi.model.SetorEmpresa;
import br.com.SCGLapi.repository.SetorEmpresaRepository;
import br.com.SCGLapi.service.SetorEmpresaService;

@RestController
@RequestMapping("/setoresEmpresa")
public class SetorEmpresaResource {

	@Autowired
	private SetorEmpresaRepository setorEmpresaRepository;
	
	@Autowired 
	private SetorEmpresaService setorEmpresaService;
	
	//Listar Todas

	@GetMapping
	public ResponseEntity<?> listar(){
		List<SetorEmpresa> setoresEmpresa = setorEmpresaRepository.findAll();	
		return !setoresEmpresa.isEmpty() ? ResponseEntity.ok(setoresEmpresa) : ResponseEntity.noContent().build();
	}
	
	//Listar uma
	@GetMapping("/{id}")
	public java.util.Optional<SetorEmpresa> buscaPeloId(@PathVariable Integer id) {
		return setorEmpresaRepository.findById(id);
	}
	
	//Cadastrar
	
	@PostMapping
	public ResponseEntity<SetorEmpresa> criar(@RequestBody SetorEmpresa setorEmpresa, HttpServletResponse response) {
		SetorEmpresa setorEmpresaBD = setorEmpresaRepository.save(setorEmpresa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(setorEmpresaBD.getIdSetorEmpresa()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(setorEmpresaBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @Valid @RequestBody SetorEmpresa setorEmpresa) {
		SetorEmpresa setorEmpresaGravado = setorEmpresaService.atualizar(id, setorEmpresa);
		return ResponseEntity.ok(setorEmpresaGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		setorEmpresaRepository.deleteById(id);
	}
}
