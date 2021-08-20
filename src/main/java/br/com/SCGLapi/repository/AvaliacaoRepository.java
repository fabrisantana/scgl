package br.com.SCGLapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.SCGLapi.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}