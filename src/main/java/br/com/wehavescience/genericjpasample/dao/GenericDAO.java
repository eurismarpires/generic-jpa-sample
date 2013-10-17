package br.com.wehavescience.genericjpasample.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author gabriel
 * 
 * Oct 17, 2013
 */

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
	private EntityManager entityManager;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void save(T entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(T entity) {
		try {
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(T entity) {
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}
