package br.com.SCGLapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.SCGLapi.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	Usuario findByLogin(String loginUsuario);
}

//Essa classe é para o Spring Security realizar a verificação de usuários no login