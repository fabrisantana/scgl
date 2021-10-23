package br.com.SCGLapi.resource;

import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.SCGLapi.model.Usuario;
import br.com.SCGLapi.repository.UsuarioCrudRepository;
import br.com.SCGLapi.service.UsuarioService;


@RestController
//@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioCrudRepository usuarioCrudRepository;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	//Listar Todas
	@GetMapping(value="/usuarios")
	public ResponseEntity<?> listar(){
		List<Usuario> usuarios = usuarioCrudRepository.findAll();	
		return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
	}
	
	//Listar um
	@GetMapping("/usuarios/{id}")
	public java.util.Optional<Usuario> buscaPeloId(@PathVariable String id) {
		return usuarioCrudRepository.findById(id);
	}
	
	//Cadastrar
	@PostMapping(value="/usuarios")
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
		//Criptografa a senha a ser gravada no banco
		BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
		String senhaCriptografada = criptografar.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		usuarioCrudRepository.save(usuario);
		
		Usuario usuarioBD = usuarioCrudRepository.save(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id")
				.buildAndExpand(usuarioBD.getLogin()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(usuarioBD);
	}
	
	//Alterar
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> atualizar(@PathVariable String id, @Valid @RequestBody Usuario usuario) {
		
		//Criptografa a senha a ser gravada no banco
		BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
		String senhaCriptografada = criptografar.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		usuarioCrudRepository.save(usuario);
		
		Usuario usuarioGravado = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioGravado);
	}
	
	//Deletar
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String id) {
		usuarioCrudRepository.deleteById(id);
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET)   
	 public ModelAndView showResults(final HttpServletRequest request, Principal principal) {
		final String currentUser = principal.getName();
		return null;

	 }
	 */
}
