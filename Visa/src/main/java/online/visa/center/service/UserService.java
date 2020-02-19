package online.visa.center.service;

import java.util.List;

import online.visa.center.model.User;

public interface UserService {

	void createUser(User user);

	void updateUser(User user);

	List<User> getAllUsers();

	User getUser(Long id);

	void deleteUser(User user);

	User findUserByUsername(String username);
}
