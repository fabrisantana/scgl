package br.com.SCGLapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.SCGLapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}