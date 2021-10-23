package br.com.SCGLapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.SCGLapi.model.SetorEmpresa;


public interface SetorEmpresaRepository extends JpaRepository<SetorEmpresa, Integer> {
	//Optional<SetorEmpresa> findByIdCliente(Integer idCliente);

}
