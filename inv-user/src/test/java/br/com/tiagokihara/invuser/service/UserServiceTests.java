package br.com.tiagokihara.invuser.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.com.tiagokihara.invuser.domain.User;
import br.com.tiagokihara.invuser.dto.UserDto;
import br.com.tiagokihara.invuser.repository.UserRepository;
import br.com.tiagokihara.invuser.service.exception.UserNotFoundException;
import br.com.tiagokihara.invuser.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	private UserService userService;
	@Mock
	private UserRepository userRepository;
	
	private User user;

	@BeforeEach
	void setUp() {
		this.userService = new UserServiceImpl(this.userRepository, new ModelMapper());
		this.user = new User(1L, "Tiago Kihara", "tiagokihara@gmail.com", "kihara");
	}

	@Test
	void shouldThrownUserNotFoundException() {
		when(userRepository.findById(1L)).thenThrow(UserNotFoundException.class);
		Assertions.assertThrows(UserNotFoundException.class, () -> userService.getById(1L));
	}
	
	@Test
	void shouldReturnAllUsers() {
		List<User> usersMock = new ArrayList<>();
		usersMock.add(this.user);
		when(userRepository.findAll()).thenReturn(usersMock);
		
		List<UserDto> usersDto = userService.getAll();
		
		Assertions.assertEquals(1, usersDto.size());
		Assertions.assertEquals(1L, usersDto.get(0).getId());
	}
	
	@Test
	void shouldReturnUserById() {
		when(userRepository.findById(1L)).thenReturn(Optional.of(this.user));
		UserDto userDto = userService.getById(1L);
		
		Assertions.assertEquals(1L, userDto.getId());
		Assertions.assertEquals("Tiago Kihara", userDto.getName());
		Assertions.assertEquals("tiagokihara@gmail.com", userDto.getEmail());
	}

}
