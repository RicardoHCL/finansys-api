package com.finasys.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.converter.EntryConverter;
import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.exceptions.GenericException;
import com.finasys.api.models.Entry;
import com.finasys.api.models.User;
import com.finasys.api.repositories.entry.EntryRepository;
import com.finasys.api.utils.FinUtil;

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

	public EntryDTO consultar(Long id) {
		EntryDTO entryDTO = this.converterEntidadeParaDTO(this.consultarPorId(id).get());
		return entryDTO;
	}

	@Override
	public List<Entry> consultarAtivos() throws GenericException {
		return this.repository.findByAtivo(true);
	}

	public List<EntryDTO> consultarEntriesPorMesEAano(Integer month, Integer year) { // TODO Refatorar posteriormente
		List<Entry> listaEntries = this.consultarAtivos();

		return this.converterListaEntidadeParaListaDTO(this.retornarEntriesValidasDeAcordoComMesEAno(listaEntries, month, year));
	}

	public Long contarLancamentosVinculadoACategoria(Long idCategoria) {
		return this.repository.countByAtivoAndCategoriaId(true, idCategoria);
	}

	public Long contarLancamentosVinculadoAoStatus(Long idStatus) {
		return this.repository.countByAtivoAndStatusId(true, idStatus);
	}

	@Override
	public Entry converterDTOParaEntidade(EntryDTO pojoDTO) {
		return EntryConverter.converterEntryDTOParaEntry(pojoDTO);
	}

	@Override
	public EntryDTO converterEntidadeParaDTO(Entry pojo) {
		return EntryConverter.converterEntryParaEntryDTO(pojo);
	}

	@Override
	public List<EntryDTO> converterListaEntidadeParaListaDTO(List<Entry> listaPojos) {
		return EntryConverter.converterListaEntryParaListaEntryDTO(listaPojos);
	}

	@Override
	public EntryRepository getRepositorio() {
		return this.repository;
	}

	public List<EntryDTO> listar() {
		return this.converterListaEntidadeParaListaDTO(this.consultarAtivos());
	}

	@Override
	public void resolverPreDependencias(Entry pojo, User usuario) throws GenericException {

		if (!pojo.isDespesa()) {
			pojo.setParcelado(false);
			pojo.setQntParcelas(null);
			pojo.setVlrParcelas(null);
		}

		if (pojo.isDespesa() && !pojo.isParcelado()) {
			pojo.setQntParcelas(null);
			pojo.setVlrParcelas(null);
		}
	}

	private List<Entry> retornarEntriesValidasDeAcordoComMesEAno(List<Entry> entries, Integer month, Integer year) {
		List<Entry> listaEntries = new ArrayList<>();
		entries.forEach(entry -> {
			if(month.equals(entry.getData().getMonthValue()) && year.equals(entry.getData().getYear())) {
				listaEntries.add(entry);
			}
		});

		return listaEntries;
	}

	public EntryDTO salvar(EntryDTO entryDTO) {
		Entry entry = this.converterDTOParaEntidade(entryDTO);
		EntryDTO entryDTOSalvo = this.converterEntidadeParaDTO(this.salvar(entry, null));
		return entryDTOSalvo;
	}

	@Override
	public void validarAlteracao(Entry pojo) throws GenericException {
		this.validarEntry(pojo);
	}

	private void validarEntry(Entry pojo) {
		if (pojo.isDespesa() && pojo.isParcelado()) {
			if (!FinUtil.isValorInteiroValido(pojo.getQntParcelas())
					|| FinUtil.isValorInteiroValido(Integer.valueOf(pojo.getVlrParcelas().toString()))) {
				throw new GenericException(
						"Os campos \"Quantidade de parcelas\" e \"Valor de cada parcela\" são obrigatórios.");
			}
		}
	}

	@Override
	public void validarInclusao(Entry pojo) throws GenericException {
		this.validarEntry(pojo);
	}

}
