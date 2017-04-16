package top.yeaho.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import top.yeaho.entities.School;

public class SchoolDaoImpl {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addSchool(School school){
		Session session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.save(school);
		transaction.commit();
		session.close();
	}
}
