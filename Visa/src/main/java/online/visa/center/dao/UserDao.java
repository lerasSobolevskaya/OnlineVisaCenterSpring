package online.visa.center.dao;

import online.visa.center.model.User;

public interface UserDao extends BaseDao<User, Long> {

	User findUserByUsername(String username);

}
