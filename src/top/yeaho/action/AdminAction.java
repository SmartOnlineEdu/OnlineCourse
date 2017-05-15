package top.yeaho.action;

import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import top.yeaho.entities.Admin;
import top.yeaho.entities.Course;
import top.yeaho.entities.Module;
import top.yeaho.entities.Student;
import top.yeaho.service.AdminServiceImpl;

public class AdminAction extends ActionSupport{
	/**
	 * 
	 * @author gaofeng
	 * @time 2017-05-14 20:20:00
	 * @version 1.0
	 * 
	 * 该类主要包含了系统管理员可用操作的函数类
	 * 涉及管理员的操作必须在本类完成编写，同时开启拦截器
	 * 拦截序列 = 登录拦截 + 权限拦截 + 自定义拦截序列
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adminName = "";
	private String adminPassword = "";
	private AdminServiceImpl adminServiceImpl;
	private String adminAddResult;
	private Admin admin;
	private String courseName;
	private String courseDes;
	private Course course; 
	private Module module;
	private Student student;
	private String courseInformation;
	private String courseNo;
	
	
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getCourseInformation() {
		return courseInformation;
	}
	public void setCourseInformation(String courseInformation) {
		this.courseInformation = courseInformation;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
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
		ActionContext actionContext = ActionContext.getContext();
		module.setModuleAuthor("Jeff Scoot");
		module.setModuleDescription("海思教育本科专科企业3+2教育平台课程添加页面");
		module.setModuleKeywords("海思教育,本科,专科,企业,校企合作,3+2教学,3+2教育平台,管理员添加");
		module.setModuleName("添加管理员");
		module.setModuleLink("regCourse.action");
		module.setTip("为学校新建管理员以管理学校日常教务");
		module.setModuleBerif("请您填写管理员信息，点击按钮提交信息");
		module.setPageTitle("学校管理员注册 - 海思教育");
		student.setStudentName("高峰");
		student.setStudentCampus("曲阜师范大学");
		student.setStudentClass("2014级软件外包对日");
		student.setStudentCompany("青岛英谷教育");
		
		actionContext.put("module", module);
		actionContext.put("student", student);
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
		ActionContext actionContext = ActionContext.getContext();
		module.setModuleAuthor("Jeff Scoot");
		module.setModuleDescription("海思教育本科专科企业3+2教育平台课程添加页面");
		module.setModuleKeywords("海思教育,本科,专科,企业,校企合作,3+2教学,3+2教育平台,课程添加,添加课程");
		module.setModuleName("添加课程");
		module.setModuleLink("regCourse.action");
		module.setTip("允许学校管理员增设新的课程");
		module.setModuleBerif("请先填写基础信息，随后进入课程详情设置页面");
		module.setPageTitle("学校添加课程 - 海思教育");
		student.setStudentName("曹燕妮");
		student.setStudentCampus("曲阜师范大学");
		student.setStudentClass("2014级软件开发");
		student.setStudentCompany("惠普集团");
		
		actionContext.put("module", module);
		actionContext.put("student", student);
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
		ActionContext actionContext = ActionContext.getContext();
		module.setPageTitle("信息提示 - 海思教育");
		module.setModuleAuthor("Jeff Scoot");
		module.setModuleDescription("海思教育本科专科企业3+2教育平台信息提示");
		module.setModuleKeywords("海思教育,本科,专科,企业,校企合作,3+2教学,3+2教育平台,操作结果");
		module.setModuleName("添加管理员结果");
		module.setModuleLink("regAdmin.action");
		module.setTip("");
		module.setModuleBerif("学校管理员添加成功，请您继续操作");
		student.setStudentName("高峰");
		student.setStudentCampus("曲阜师范大学");
		student.setStudentClass("2014级软件外包对日");
		student.setStudentCompany("惠普集团");
		
		actionContext.put("module", module);
		actionContext.put("student", student);
		
		
		return "SUCCESS";
	}
	
	/**
	 * 用于注册一门新的课程，系统管理员第一步需要提供课程名和课程描述
	 * 逻辑层生成实体类写入数据库后，跳转到信息补充页面进一步完善课程信息
	 * */
	public String regCourseData(){
		
		course.setCourseName(courseName);
		course.setCourseDes(courseDes);
		return Action.SUCCESS;
	}
	
}
