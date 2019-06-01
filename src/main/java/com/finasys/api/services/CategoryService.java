package com.finasys.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.models.Category;
import com.finasys.api.repositories.category.CategoryRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class CategoryService extends GenericService<Category, Long, CategoryRepository>{

	@Autowired
	private CategoryRepository repository;

	@Override
	public CategoryRepository getRepositorio() {
		return this.repository;
	}

	@Override
	Category persistirEntidade(Category pojo) {
		return this.repository.save(pojo);
	}

	@Override
	void excluirEntidade(Long id) {
		this.repository.deleteById(id);
	}

}
