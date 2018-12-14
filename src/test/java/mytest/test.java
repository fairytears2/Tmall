package mytest;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.netease.course.model.Product;


public class test{
	
	@PersistenceContext
	EntityManager entityManager;
	
	SessionFactory  sessionFactory = null;	
	Session session =null;	
	Transaction transaction = null;
	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();		
		ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();		
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
  
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	

	@Test
	public void test() {
		String hql = "select new Product(p.id,p.name,p.category) from Product p where p.category = :account";		
		Query<Product> query = session.createQuery(hql);	
		System.out.println(query.setParameter("account", 83).list());;	
		
	}
	
}
