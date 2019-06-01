package com.finasys.api.repositories.entry;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finasys.api.models.Entry;
import com.finasys.api.repositories.GenericRepositoryImpl;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Repository
@Transactional(readOnly = true)
public class EntryRepositoryImpl extends GenericRepositoryImpl<Entry, Long> implements EntryRepositoryCustom {

}
