package online.visa.center.dao.impl;

import org.springframework.stereotype.Repository;

import online.visa.center.dao.UserDao;
import online.visa.center.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User findUserByUsername(String username) {
		User user = (User) getCurrentSession().createQuery("from User where username = :username")
				.setParameter("username", username).uniqueResult();
		return user;
	}

}
