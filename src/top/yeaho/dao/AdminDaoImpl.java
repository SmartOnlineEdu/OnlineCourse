package top.yeaho.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import top.yeaho.entities.Admin;

public class AdminDaoImpl implements AdminDao{
	
	private SessionFactory sessionFactory;

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Admin";
		Query query = session.createQuery(hql);
		List<Admin> list = query.list();
		session.close();
		return list;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		//getHibernateTemplate().save(admin);
		Session session = sessionFactory.openSession();
		Transaction transaction =  session.beginTransaction();
		session.save(admin);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public boolean editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean queryAdmin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public AdminDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
