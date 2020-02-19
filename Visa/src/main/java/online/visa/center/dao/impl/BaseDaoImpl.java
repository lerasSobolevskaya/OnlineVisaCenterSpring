package online.visa.center.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import online.visa.center.dao.BaseDao;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	private Class<T> entityClass;

	@Autowired
	private SessionFactory sessionFactory;

	public BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ID save(T entity) {
		ID id = (ID) getCurrentSession().save(entity);
		return id;
	}

	@Override
	public void update(T entity) {
		getCurrentSession().update(entity);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		String getAll = "from " + entityClass.getName();
		List<T> entities = (List<T>) getCurrentSession().createQuery(getAll).list();
		return entities;
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);

	}

	@Override
	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		T entity = (T) getCurrentSession().get(entityClass.getName(), id);
		return entity;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
