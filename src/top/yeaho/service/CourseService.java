package top.yeaho.service;

import java.util.List;
import top.yeaho.dao.CourseDao;

/**
 * 
 * @author wang zhaojie
 *
 */
public class CourseService {

	private CourseDao courseDao;
	
	//获取所有课程信息
	public List getAllCourse()
	{
		return courseDao.getAllCourse();
	}
		
	
	public CourseService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
}
