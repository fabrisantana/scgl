package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Colaborador;
import br.com.SCGLapi.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public Colaborador atualizar(Integer id, Colaborador colaborador) {
		Optional<Colaborador> colaboradorGravado = colaboradorRepository.findById(id);
		
		if(!colaboradorGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Colaborador colaboradorTemp = colaboradorGravado.get();
		BeanUtils.copyProperties(colaborador, colaboradorTemp, "id");
		colaboradorRepository.save(colaboradorTemp);
		return colaboradorRepository.save(colaboradorTemp);	
	}
}
