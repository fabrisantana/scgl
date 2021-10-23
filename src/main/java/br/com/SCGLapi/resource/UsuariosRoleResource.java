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

import br.com.SCGLapi.model.UsuariosRole;
import br.com.SCGLapi.repository.UsuariosRoleRepository;
import br.com.SCGLapi.service.UsuariosRoleService;

@RestController
@RequestMapping("/usuariosRole")
public class UsuariosRoleResource {

	@Autowired
	private UsuariosRoleRepository usuarioRoleRepository;
	
	@Autowired 
	private UsuariosRoleService usuarioRoleService;
	
	//Listar Todas
	@GetMapping
	public ResponseEntity<?> listar(){
		List<UsuariosRole> usuarioRole = usuarioRoleRepository.findAll();	
		return !usuarioRole.isEmpty() ? ResponseEntity.ok(usuarioRole) : ResponseEntity.noContent().build();
	}
	
	//Listar um
	@GetMapping("/{id}")
	public java.util.Optional<UsuariosRole> buscaPeloId(@PathVariable String id) {
		return usuarioRoleRepository.findById(id);
	}
	
	//Cadastrar	
	@PostMapping
	public ResponseEntity<UsuariosRole> criar(@RequestBody UsuariosRole usuarioRole, HttpServletResponse response) {
		UsuariosRole usuarioRoleBD = usuarioRoleRepository.save(usuarioRole);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(usuarioRoleBD.getLoginUsuario() ).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(usuarioRoleBD);
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @Valid @RequestBody UsuariosRole usuarioRole) {
		UsuariosRole usuarioRoleGravado = usuarioRoleService.atualizar(id, usuarioRole);
		return ResponseEntity.ok(usuarioRoleGravado);
	}
	
	//Deletar
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String id) {
		usuarioRoleRepository.deleteById(id);
	}
}
