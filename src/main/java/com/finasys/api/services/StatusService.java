package com.finasys.api.services;

import java.util.List;

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
public class StatusService extends GenericService<Status, Long, StatusRepository> {

	@Autowired
	private StatusRepository repository;

	public StatusDTO consultar(Long id) {
		var statusDTO = DozerConverter.converterObjeto(this.consultarPorId(id).get(), StatusDTO.class);
		return statusDTO;
	}

	@Override
	public StatusRepository getRepositorio() {

		return this.repository;
	}

	public List<StatusDTO> listar() {
		return DozerConverter.converterListaObjetos(this.consultarTodos(), StatusDTO.class);
	}

	public StatusDTO salvar(StatusDTO statusDTO) {
		var status = DozerConverter.converterObjeto(statusDTO, Status.class);
		var statusDTOSalvo = DozerConverter.converterObjeto(this.salvar(status, null), StatusDTO.class);
		return statusDTOSalvo;
	}

}
