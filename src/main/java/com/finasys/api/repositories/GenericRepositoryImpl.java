package com.finasys.api.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.finasys.api.models.Pojo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */
public abstract class GenericRepositoryImpl<ENTIDADE extends Pojo<ID>, ID extends Serializable> implements GenericRepository<ENTIDADE, ID> {

	@Autowired
	@Getter @Setter
	private EntityManager entityManager;


	@Override
	public ENTIDADE buscar(ID id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT e ");
		sb.append(" FROM ");
		sb.append(this.getTargetClass());
		sb.append(" e WHERE id = :id ");
		TypedQuery<ENTIDADE> query = this.getEntityManager().createQuery(sb.toString(), this.getClassEntidade());
		query.setParameter("id", id);
		List<ENTIDADE> resultList = query.getResultList();
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@SuppressWarnings({ "unchecked" })
	protected Class<ENTIDADE> getClassEntidade() {
		return (Class<ENTIDADE>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}


	private String getTargetClass() {
		return this.getClassEntidade().getSimpleName();
	}
}
