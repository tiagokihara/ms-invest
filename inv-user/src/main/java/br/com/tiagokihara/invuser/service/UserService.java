package br.com.tiagokihara.invuser.service;

import java.util.List;

import br.com.tiagokihara.invuser.dto.UserDto;

public interface UserService {
	
	UserDto getById(Long id);

	List<UserDto> getAll();
}
