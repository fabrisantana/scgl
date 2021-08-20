package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Avaliacao;
import br.com.SCGLapi.repository.AvaliacaoRepository;


@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	public Avaliacao atualizar(Integer id, Avaliacao avaliacao) {
		Optional<Avaliacao> avaliacaoGravada = avaliacaoRepository.findById(id);
		
		if(!avaliacaoGravada.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Avaliacao avaliacaoTemp = avaliacaoGravada.get();
		BeanUtils.copyProperties(avaliacao, avaliacaoTemp, "id");
		avaliacaoRepository.save(avaliacaoTemp);
		return avaliacaoRepository.save(avaliacaoTemp);	
	}
}
