package com.netease.course.dao.impl;




import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.netease.course.dao.BaseDao;
import com.netease.course.model.Pager;
import com.netease.course.model.SystemContext;



public class BaseDaoImpl<T> implements BaseDao<T> {


	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<?> clazz;
	
	
	public Class<?> getClazz(){
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Type[] types= pt.getActualTypeArguments();
		clazz = (Class<?>) types[0];
		return clazz;
	}
	
	
	@Override
	public T add(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public void delete(int id) {
		entityManager.remove(load(id));
		
	}

	@Override
	public void update(T t) {
		
		entityManager.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		return (T) entityManager.find(getClazz(), id);
	}
	
	

	
	
	/**
	 * 
	 * @param jpql
	 * @param objects
	 * @param alias
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String jpql , Object[] objects , Map<String, Object> alias){
		jpql = initsort(jpql);
		Query query = entityManager.createQuery(jpql);
		setParameter(query,objects);
		setParameterAlias(query,alias);
		return query.getResultList();
	}



	@SuppressWarnings("unchecked")
	public Pager<T> find(String jpql , Object[] objects , Map<String, Object> alias){
		jpql = initsort(jpql);
		Query query = entityManager.createQuery(jpql);
		setParameter(query, objects);
		setParameterAlias(query, alias);
		Pager<T> pager = new Pager<>();
		setPager(query,pager);	
		List<T> list= query.getResultList();
		pager.setRows(list);
		Query countquery=  entityManager.createQuery(count(jpql));
		setParameter(countquery, objects);
		setParameterAlias(countquery, alias);
		long total = (long) countquery.getSingleResult();
		pager.setTotal(total);
		return pager;
	}
	
	public Object queryByjpql (String jpql , Object[] objects , Map<String, Object> alias) {	
		Query query = entityManager.createQuery(jpql);
		setParameter(query, objects);
		setParameterAlias(query, alias);
		return query.getSingleResult();		
	}
	
	public void update(String jpql , Object[] objects , Map<String, Object> alias) {
		Query query = entityManager.createQuery(jpql);
		setParameter(query, objects);
		setParameterAlias(query, alias);
		query.executeUpdate();
	}
	
	
	
	
	@SuppressWarnings("unused")
	private void setPager(Query query, Pager<T> pager) {
		 Integer pageOffset = pager.getPageoffset();
		 Integer pagesize = pager.getPagesize();
		 if(pageOffset == null || pageOffset<1)
			 pageOffset = 0 ;
		 if(pagesize == null && pagesize <10) {
			 pagesize = 10 ;
		 } 
		 query.setFirstResult(pageOffset).setMaxResults(pagesize);	
	}

	/**
	 * 别名查询
	 * @param query
	 * @param alias
	 */
	private void setParameterAlias(Query query, Map<String, Object> alias) {
		if(alias != null){
			Set<String> keys =  alias.keySet();
			for (String key : keys) {
				Object object= alias.get(key);
				query.setParameter(key,object);		
			}
		}
		
	}
	/**
	 * ？查询
	 * @param query
	 * @param objects
	 */
	private void setParameter(Query query, Object[] objects) {
		if(objects != null && objects.length>0) {
			int indexnumber = 0;		
			for (Object object : objects) {
				query.setParameter(indexnumber++, object);		
			}
		}	
	}
	
	private String initsort(String jpql) {
		String sort = SystemContext.getSort();
		String method = SystemContext.getMethod();
		if(sort != null && "".equals(sort.trim())) {
			jpql = jpql + "order by" + sort;
			if(method.equals("desc")) {
				jpql = jpql + "desc";
			}else {
				jpql = jpql + "asc";
			}
		}		
		return jpql;
	}
	
	private String count(String jpql){
		String countjpql = jpql.substring(jpql.indexOf("from"));
		countjpql ="select count(*)" + jpql;
		return countjpql.replace("fetch", "");
	}
	
}
