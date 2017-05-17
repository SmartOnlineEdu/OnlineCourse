package top.yeaho.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * �γ�dao�㣬��ȡ���ݿ�γ���Ϣ
 * @author wang zhaojie 
 */
public class CourseDao {

	private SessionFactory sessionFactory;

	/**
	 * �鿴�����Ѵ��ڵĿγ�
	 * @return
	 */
	public  List getAllCourse()
	{		
		Session session = sessionFactory.openSession();
		 Query query = session.createQuery("from Course");
		List list = query.list();
		session.close();
		return list;
	}
	
	public CourseDao() {
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
