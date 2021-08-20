package br.com.SCGLapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.SCGLapi.model.SetorEmpresa;
import br.com.SCGLapi.repository.SetorEmpresaRepository;

@Service
public class SetorEmpresaService {

	@Autowired
	private SetorEmpresaRepository setorEmpresaRepository;
	
	public SetorEmpresa atualizar(Integer id, SetorEmpresa setorEmpresa) {
		Optional<SetorEmpresa> setorEmpresaGravado = setorEmpresaRepository.findById(id);
		
		if(!setorEmpresaGravado.isPresent()) {
			throw new EmptyResultDataAccessException(1); //1 significa que foi esperado 1 registro
		}
		
		SetorEmpresa setorEmpresaTemp = setorEmpresaGravado.get();
		BeanUtils.copyProperties(setorEmpresa, setorEmpresaTemp, "id");
		setorEmpresaRepository.save(setorEmpresaTemp);
		return setorEmpresaRepository.save(setorEmpresaTemp);	
	}
}

