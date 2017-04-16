package top.yeaho.dao;

import java.util.List;

import top.yeaho.entities.Admin;

public interface AdminDao {
	public List<Admin> getAllAdmin();
	public boolean addAdmin(Admin admin);
	public boolean editAdmin(Admin admin);
	public boolean delAdmin(Admin admin);
	public boolean queryAdmin();
}
