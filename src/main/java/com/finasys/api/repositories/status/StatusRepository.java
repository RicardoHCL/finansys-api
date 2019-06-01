package com.finasys.api.repositories.status;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finasys.api.models.Status;


/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom {

}
