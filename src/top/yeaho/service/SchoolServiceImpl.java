package top.yeaho.service;

import top.yeaho.dao.SchoolDaoImpl;
import top.yeaho.entities.School;

public class SchoolServiceImpl {
	private SchoolDaoImpl schoolDaoImpl;
	
	
	public SchoolDaoImpl getSchoolDaoImpl() {
		return schoolDaoImpl;
	}


	public void setSchoolDaoImpl(SchoolDaoImpl schoolDaoImpl) {
		this.schoolDaoImpl = schoolDaoImpl;
	}


	public void addSchool(School school){
		schoolDaoImpl.addSchool(school);
	}
}
