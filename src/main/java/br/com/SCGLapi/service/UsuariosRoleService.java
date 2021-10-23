package br.com.SCGLapi.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.UsuariosRole;
import br.com.SCGLapi.repository.UsuariosRoleRepository;

@Service
public class UsuariosRoleService {

	@Autowired
	private UsuariosRoleRepository usuarioRoleRepository;
	
	public UsuariosRole atualizar(String id, UsuariosRole usuarioRole) {
		Optional<UsuariosRole> usuarioRoleGravado = usuarioRoleRepository.findById(id);
		
		if(!usuarioRoleGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		UsuariosRole usuarioRoleTemp = usuarioRoleGravado.get();
		BeanUtils.copyProperties(usuarioRole, usuarioRoleTemp, "id");
		usuarioRoleRepository.save(usuarioRoleTemp);
		return usuarioRoleRepository.save(usuarioRoleTemp);	
	}
	
}

