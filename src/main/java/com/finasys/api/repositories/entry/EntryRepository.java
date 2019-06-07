package com.finasys.api.repositories.entry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finasys.api.models.Entry;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */
public interface EntryRepository extends JpaRepository<Entry, Long>, EntryRepositoryCustom {

	Long countByAtivoAndCategoriaId(boolean ativo, Long idCategoria);
	Long countByAtivoAndStatusId(boolean ativo, Long idStatus);
	List<Entry> findByAtivo(boolean ativo);
	List<Entry> findByAtivoAndDataBetween(boolean ativo, LocalDate periodoInicial, LocalDate periodoFinal);
}

