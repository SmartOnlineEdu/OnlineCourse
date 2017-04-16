package top.yeaho.entities;

public class Admin {
	private int ID;
	private String adminName;
	private String adminPwd;
	private int role;
	
	
	public Admin(){}
	
	public Admin(String name, String pwd){
		this.adminName = name;
		this.adminPwd = pwd;
		this.role = 1;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
	
}
