package top.yeaho.service;

import java.util.List;

import top.yeaho.dao.AdminDaoImpl;
import top.yeaho.entities.Admin;

public class AdminServiceImpl implements AdminService{

	private AdminDaoImpl adminDaoImpl;
	
	public void setAdminDaoImpl(AdminDaoImpl adminDaoImpl){
		this.adminDaoImpl = adminDaoImpl;
	}
	
	public AdminDaoImpl getAdminDaoImpl() {
		return adminDaoImpl;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> list = adminDaoImpl.getAllAdmin();
		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		adminDaoImpl.addAdmin(admin);
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

}
