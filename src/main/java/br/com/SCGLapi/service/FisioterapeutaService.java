package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.Fisioterapeuta;
import br.com.SCGLapi.repository.FisioterapeutaRepository;

@Service
public class FisioterapeutaService {

	@Autowired
	private FisioterapeutaRepository fisioterapeutaRepository;
	
	public Fisioterapeuta atualizar(Integer id, Fisioterapeuta fisioterapeuta) {
		Optional<Fisioterapeuta> fisioterapeutaGravado = fisioterapeutaRepository.findById(id);
		
		if(!fisioterapeutaGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		Fisioterapeuta fisioterapeutaTemp = fisioterapeutaGravado.get();
		BeanUtils.copyProperties(fisioterapeuta, fisioterapeutaTemp, "id");
		fisioterapeutaRepository.save(fisioterapeutaTemp);
		return fisioterapeutaRepository.save(fisioterapeutaTemp);	
	}
}
