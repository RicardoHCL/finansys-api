package com.finasys.api.services;

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

	@Override
	public EntryRepository getRepositorio() {
		return this.repository;
	}

}
