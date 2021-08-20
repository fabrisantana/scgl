package br.com.SCGLapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.SCGLapi.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

}