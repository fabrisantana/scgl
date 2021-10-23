package br.com.SCGLapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.SCGLapi.model.Usuario;


public interface UsuarioCrudRepository extends JpaRepository<Usuario, String> {
	
}