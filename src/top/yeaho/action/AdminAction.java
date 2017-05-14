package top.yeaho.action;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import top.yeaho.entities.Admin;
import top.yeaho.entities.Course;
import top.yeaho.service.AdminServiceImpl;

public class AdminAction extends ActionSupport{
	/**
	 * 该类主要包含了系统管理员可用操作的函数类
	 * 涉及管理员的操作必须在本类完成编写，同时开启拦截器
	 * 拦截序列 = 登录拦截 + 权限拦截 + 自定义拦截序列
	 */
	private static final long serialVersionUID = 1L;
	private String adminName = "";
	private String adminPassword = "";
	private AdminServiceImpl adminServiceImpl;
	private String adminAddResult;
	private Admin admin;
	private String courseName;
	private String courseDes;
	private Course course; //尚未Spring注册
	
	/**
	 * 以下getter和setter主要用于Spring注入和模型驱动
	 * */
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDes() {
		return courseDes;
	}
	public void setCourseDes(String courseDes) {
		this.courseDes = courseDes;
	}
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
	
	/**
	 * 用于注册管理员显示注册页面 
	 * */
	public String regAdminView(){
		return "reg";
	}
	
	/**
	 * 用于管理员登录显示页面
	 * */
	public String loginAdminView(){
		return "login";
	}
	
	/**
	 * 用于显示添加课程的第一屏页面
	 * */
	public String regCourseView(){
		return Action.SUCCESS;
	}
	
	/**
	 * 用于显示登陆后管理员的主页面（尚未启用）
	 * */
	public String display(){
		Session session = null;
		return "display";
	}
	
	/**
	 * 当注册管理员页面数据填写完毕后，将数据POST给该函数，该函数用于注册管理员数据持久化
	 * */
	public String checkRegAdmin(){
		admin.setAdminName(this.adminName);
		admin.setAdminPwd(this.adminPassword);
		adminServiceImpl.addAdmin(admin);
		return "SUCCESS";
	}
	
	/**
	 * 用于注册一门新的课程，系统管理员第一步需要提供课程名和课程描述
	 * 逻辑层生成实体类写入数据库后，跳转到信息补充页面进一步完善课程信息
	 * */
	public String regCourse(){
		
		course.setCourseName(courseName);
		course.setCourseDes(courseDes);
		return Action.SUCCESS;
	}
	
}
