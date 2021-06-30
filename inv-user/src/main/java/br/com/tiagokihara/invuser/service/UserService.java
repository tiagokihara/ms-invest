package br.com.tiagokihara.invuser.service;

import java.util.List;

import br.com.tiagokihara.invuser.domain.User;

public interface UserService {
	
	User getById(Long id);

	List<User> getAll();
}
