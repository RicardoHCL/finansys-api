package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.models.Entry;
import com.finasys.api.repositories.entry.EntryRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class EntryService extends GenericService<Entry, EntryDTO, Long, EntryRepository> {

	@Autowired
	private EntryRepository repository;

	public Long contarLancamentosVinculadoACategoria(Long idCategoria) {
		return this.repository.countByAtivoAndCategoriaId(true, idCategoria);
	}

	public Long contarLancamentosVinculadoAoStatus(Long idStatus) {
		return this.repository.countByAtivoAndStatusId(true, idStatus);
	}

	@Override
	public Entry converterDTOParaEntidade(EntryDTO pojoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntryDTO converterEntidadeParaDTO(Entry pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntryDTO> converterListaEntidadeParaListaDTO(List<Entry> listaPojos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntryRepository getRepositorio() {
		return this.repository;
	}

}
