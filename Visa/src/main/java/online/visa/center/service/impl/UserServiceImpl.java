package online.visa.center.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import online.visa.center.dao.UserDao;
import online.visa.center.model.User;
import online.visa.center.model.enums.Role;
import online.visa.center.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDao userDao;

	private BCryptPasswordEncoder encode;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void createUser(User user) {
		user.setPassword(encode.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);

	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public User getUser(Long id) {
		return userDao.getById(id);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User findUserByUsername(String username) {
		User user = userDao.findUserByUsername(username);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUserByUsername(username);
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(Role.ADMIN.name()));
		roles.add(new SimpleGrantedAuthority(Role.USER.name()));
		if (user == null) {
			throw new UsernameNotFoundException("User with username: " + username + " not found");
		}
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), roles);
	}

}
