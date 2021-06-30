package br.com.tiagokihara.invuser.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tiagokihara.invuser.domain.User;
import br.com.tiagokihara.invuser.repository.UserRepository;
import br.com.tiagokihara.invuser.service.UserService;
import br.com.tiagokihara.invuser.service.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

}
