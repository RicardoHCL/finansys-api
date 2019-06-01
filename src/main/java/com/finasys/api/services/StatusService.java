package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.converter.DozerConverter;
import com.finasys.api.dtos.StatusDTO;
import com.finasys.api.exceptions.GenericException;
import com.finasys.api.models.Status;
import com.finasys.api.repositories.status.StatusRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class StatusService extends GenericService<Status, StatusDTO, Long, StatusRepository> {

	@Autowired
	private StatusRepository repository;

	public StatusDTO consultar(Long id) {
		StatusDTO statusDTO = this.converterEntidadeParaDTO(this.consultarPorId(id).get());
		return statusDTO;
	}

	@Override
	public Status converterDTOParaEntidade(StatusDTO dto) throws GenericException {
		return DozerConverter.converterObjeto(dto, Status.class);
	}

	@Override
	public StatusDTO converterEntidadeParaDTO(Status pojo) throws GenericException {
		return DozerConverter.converterObjeto(pojo, StatusDTO.class);
	}

	@Override
	public StatusRepository getRepositorio() {
		return this.repository;
	}

	public List<StatusDTO> listar() {
		return DozerConverter.converterListaObjetos(this.consultarTodos(), StatusDTO.class);
	}

	public StatusDTO salvar(StatusDTO statusDTO) {
		Status status = this.converterDTOParaEntidade(statusDTO);
		StatusDTO statusDTOSalvo = this.converterEntidadeParaDTO(this.salvar(status, null));
		return statusDTOSalvo;
	}

}
