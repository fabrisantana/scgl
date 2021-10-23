
package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Usuario;
import br.com.SCGLapi.repository.UsuarioCrudRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioCrudRepository UsuarioCrudRepository;
	
	public Usuario atualizar(String id, Usuario usuario) {
		Optional<Usuario> usuarioGravado = UsuarioCrudRepository.findById(id);
		
		if(!usuarioGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Usuario usuarioTemp = usuarioGravado.get();
		BeanUtils.copyProperties(usuario, usuarioTemp, "id");	
		return UsuarioCrudRepository.save(usuarioTemp);	
	}
}
