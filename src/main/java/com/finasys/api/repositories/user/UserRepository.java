package com.finasys.api.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finasys.api.models.User;

/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
