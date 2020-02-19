package online.visa.center.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import online.visa.center.model.User;
import online.visa.center.model.dto.UserDto;
import online.visa.center.rest.exeption.BindingResultException;
import online.visa.center.rest.exeption.ThereIsNoSuchElementException;
import online.visa.center.service.UserService;
import online.visa.center.service.mapper.UserMapper;

@RestController
@RequestMapping(value = "/visa/center")
@Slf4j
public class UserController {

	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userMapper.toDtoList(userService.getAllUsers());
		if (users == null) {	
			log.error("Error while retrieving users");
			throw new ThereIsNoSuchElementException("The list of users is empty");
		}
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		UserDto user = userMapper.toDto(userService.getUser(id));
		if (user == null) {
			log.error("Error while retrieving user with id: " + id);
			throw new ThereIsNoSuchElementException("User with id " + id + " not found");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Error while creating user");
			throw new BindingResultException(bindingResult.getAllErrors());
		}
		User user = userMapper.toEntity(userDto);
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
		if (userService.getUser(id) == null) {
			log.error("Error while updating user with id: " + id);
			throw new ThereIsNoSuchElementException("User with id: " + id + " not found");
		}
		User user = userMapper.toEntity(userDto);
		userService.updateUser(user);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		if (user == null) {
			log.error("Error while deleting user with id: " + id);
			throw new ThereIsNoSuchElementException("User with id " + id + " not found");
		}
		userService.deleteUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
