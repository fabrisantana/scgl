package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Atendimento;
import br.com.SCGLapi.repository.AtendimentoRepository;


@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public Atendimento atualizar(Integer id, Atendimento atendimento) {
		Optional<Atendimento> atendimentoGravado = atendimentoRepository.findById(id);
		
		if(!atendimentoGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Atendimento atendimentoTemp = atendimentoGravado.get();
		BeanUtils.copyProperties(atendimento, atendimentoTemp, "id");
		atendimentoRepository.save(atendimentoTemp);
		return atendimentoRepository.save(atendimentoTemp);	
	}
}
