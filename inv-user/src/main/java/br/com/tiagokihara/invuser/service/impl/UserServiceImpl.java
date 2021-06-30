package br.com.tiagokihara.invuser.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.tiagokihara.invuser.domain.User;
import br.com.tiagokihara.invuser.dto.UserDto;
import br.com.tiagokihara.invuser.repository.UserRepository;
import br.com.tiagokihara.invuser.service.UserService;
import br.com.tiagokihara.invuser.service.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto getById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

		return convertToDto(user);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> users = userRepository.findAll();

		return users.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private UserDto convertToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}
}
