package com.finasys.api.converter;

import java.util.ArrayList;
import java.util.List;

import com.finasys.api.dtos.CategoryDTO;
import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.dtos.StatusDTO;
import com.finasys.api.models.Entry;
import com.finasys.api.utils.FinUtil;

/**
 *
 * @author Ricardo Lima
 * @version 02/06/2019
 *
 */
public class EntryConverter {

	public static Entry converterEntryDTOParaEntry(EntryDTO entryDTO) {

		return new Entry(entryDTO.getId(), entryDTO.getNome(), entryDTO.getDescricao(), entryDTO.getCategoriaId(), entryDTO.getValor(), entryDTO.getData(),
				entryDTO.isParcelado(), entryDTO.isDespesa(), entryDTO.getQntParcelas(), entryDTO.getVlrParcelas(), entryDTO.getStatusId());
	}

	public static EntryDTO converterEntryParaEntryDTO(Entry entry) {
		return new EntryDTO(entry.getId(), entry.getNome(), entry.getDescricao(), entry.getValor().toString(), FinUtil.converteDataParaString(entry.getData()),
				entry.isParcelado(), entry.isDespesa(), entry.getQntParcelas(), entry.getVlrParcelas() != null ? entry.getVlrParcelas().toString() : null, DozerConverter.converterObjeto(entry.getCategoria(), CategoryDTO.class) ,
						DozerConverter.converterObjeto(entry.getStatus(), StatusDTO.class));
	}

	public static List<Entry> converterListaEntryDTOParaListaEntry(List<EntryDTO> listaEntryDTO) {

		List<Entry> listaEntry = new ArrayList<>();
		listaEntryDTO.forEach(entryDTO -> listaEntry.add(converterEntryDTOParaEntry(entryDTO)));
		return listaEntry;
	}


	public static List<EntryDTO> converterListaEntryParaListaEntryDTO(List<Entry> listaEntry) {

		List<EntryDTO> listaEntryDTO = new ArrayList<>();
		listaEntry.forEach(entry -> listaEntryDTO.add(converterEntryParaEntryDTO(entry)));
		return listaEntryDTO;
	}

}
