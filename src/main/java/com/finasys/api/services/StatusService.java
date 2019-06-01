package com.finasys.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.converter.DozerConverter;
import com.finasys.api.dtos.StatusDTO;
import com.finasys.api.models.Status;
import com.finasys.api.repositories.status.StatusRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class StatusService extends GenericService<Status, Long, StatusRepository>{

	@Autowired
	private StatusRepository repository;



	@Override
	void excluirEntidade(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public StatusRepository getRepositorio() {
		return this.repository;
	}

	@Override
	Status persistirEntidade(Status pojo) {
		return this.repository.save(pojo);
	}

	public StatusDTO salvar(StatusDTO statusDTO) {
		var status  = DozerConverter.converterObjeto(statusDTO, Status.class);
		var statusDTOSalvo  = DozerConverter.converterObjeto(this.salvar(status, null), StatusDTO.class);
		return statusDTOSalvo;
	}

}
