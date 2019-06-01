package com.finasys.api.repositories.entry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finasys.api.models.Entry;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */
public interface EntryRepository extends JpaRepository<Entry, Long>, EntryRepositoryCustom {

}
