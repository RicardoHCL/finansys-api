package com.finasys.api.repositories;

import java.io.Serializable;

import com.finasys.api.models.Pojo;


/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

public interface GenericRepository<ENTIDADE extends Pojo<ID>, ID extends Serializable> {

	ENTIDADE buscar(ID id);
}
