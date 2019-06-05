package com.finasys.api.models;

import java.io.Serializable;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

public interface IEntidade<ID extends Serializable> extends Serializable {

	public ID getId();

	public void setId(ID id);

}