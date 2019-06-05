package com.finasys.api.repositories.category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finasys.api.models.Category;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {


}
