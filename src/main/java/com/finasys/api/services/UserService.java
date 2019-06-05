package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.dtos.UserDTO;
import com.finasys.api.models.User;
import com.finasys.api.repositories.user.UserRepository;

/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */

@Service
public class UserService extends GenericService<User, UserDTO, Long, UserRepository> {

	@Autowired
	private UserRepository repository;

	@Override
	public User converterDTOParaEntidade(UserDTO pojoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO converterEntidadeParaDTO(User pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> converterListaEntidadeParaListaDTO(List<User> listaPojos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRepository getRepositorio() {
		return this.repository;
	}

}
