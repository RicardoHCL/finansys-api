package com.finasys.api.repositories.status;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finasys.api.models.Status;
import com.finasys.api.repositories.GenericRepositoryImpl;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Repository
@Transactional(readOnly = true)
public class StatusRepositoryImpl extends GenericRepositoryImpl<Status, Long> implements StatusRepositoryCustom {

}
