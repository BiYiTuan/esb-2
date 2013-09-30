package com.boohoo.esb.database.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class JpaBaseDao<T, ID> implements BaseDao<T, Integer>{
	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaBaseDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public <S extends T> S save(S entity) {
		return entityManager.merge(entity);
	}
	
	@Override
	public long count() {
		Query query = entityManager.createQuery("select count(*) from " + entityClass.getName());
		return query.executeUpdate();
	}
	
	@Override
	public void delete(Integer id) {
		T findOne = findOne(id);
		if(findOne != null)
			delete(findOne);
		else{
			
		}
	}
	
	@Override
	public void delete(Iterable<? extends T> entities) {
		for (T t : entities) {
			delete(t);
		}
	}
	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public void deleteAll() {
		Query query = entityManager.createQuery("DELETE FROM " + entityClass.getName() + " d");
		query.executeUpdate();
	}
	
	@Override
	public boolean exists(Integer id) {
		return findOne(id) == null ? false : true;
	}
	
	@Override
	public Iterable<T> findAll() {
		Query query = entityManager.createQuery("SELECT A FROM " + entityClass.getName() + " A");
		return (List<T>)query.getResultList();
	}
	
	@Override
	public Iterable<T> findAll(Iterable<Integer> ids) {
		List<T> list = new ArrayList<T>();
		for (Integer id : ids) {
			list.add(findOne(id));
		}
		return list;
	}
	
	@Override
	public T findOne(Integer id) {
		return entityManager.find(entityClass, id);
	}
	
	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		List<S> list = new ArrayList<S>();
		for (S s : entities) {
			entityManager.merge(s);
		}
		return list;
	}
}