package com.finasys.api.repositories.category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finasys.api.models.Category;
import com.finasys.api.repositories.GenericRepositoryImpl;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Repository
@Transactional(readOnly = true)
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category, Long> implements CategoryRepositoryCustom {

}
