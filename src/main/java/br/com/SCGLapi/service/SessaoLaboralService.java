package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.SessaoLaboral;
import br.com.SCGLapi.repository.SessaoLaboralRepository;


@Service
public class SessaoLaboralService {

	@Autowired
	private SessaoLaboralRepository sessaoLaboralRepository;
	
	public SessaoLaboral atualizar(Integer id, SessaoLaboral sessaoLaboral) {
		Optional<SessaoLaboral> sessaoLaboralGravada = sessaoLaboralRepository.findById(id);
		
		if(!sessaoLaboralGravada.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		SessaoLaboral sessaoLaboralTemp = sessaoLaboralGravada.get();
		BeanUtils.copyProperties(sessaoLaboral, sessaoLaboralTemp, "id");
		sessaoLaboralRepository.save(sessaoLaboralTemp);
		return sessaoLaboralRepository.save(sessaoLaboralTemp);
	}
}
