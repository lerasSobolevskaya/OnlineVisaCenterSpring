package online.visa.center.dao;

import java.util.List;

public interface BaseDao<T, ID> {

	ID save(T entity);

	void update(T entity);

	List<T> getAll();

	void delete(T entity);

	T getById(ID id);
}
