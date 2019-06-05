package com.finasys.api.repositories.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finasys.api.models.User;
import com.finasys.api.repositories.GenericRepositoryImpl;

/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl extends GenericRepositoryImpl<User, Long> implements UserRepositoryCustom{

}
