package top.yeaho.action;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import top.yeaho.entities.Admin;
import top.yeaho.service.AdminServiceImpl;

public class AdminAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adminName = "";
	private String adminPassword = "";
	private AdminServiceImpl adminServiceImpl;
	private String adminAddResult;
	private Admin admin;
	
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminServiceImpl getAdminServiceImpl() {
		return adminServiceImpl;
	}

	public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	public String getAdminAddResult() {
		return adminAddResult;
	}

	public void setAdminAddResult(String adminAddResult) {
		this.adminAddResult = adminAddResult;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String reg(){
		return "reg";
	}
	
	public String login(){
		return "login";
	}
	
	public String display(){
		Session session = null;
		return "display";
	}
	
	public String checkRegAdmin(){
		admin.setAdminName(this.adminName);
		admin.setAdminPwd(this.adminPassword);
		adminServiceImpl.addAdmin(admin);
		return "SUCCESS";
	}
}
