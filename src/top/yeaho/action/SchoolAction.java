package top.yeaho.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SchoolAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public String reg(){
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("functionTitle", "注册学校");
		return "reg";
	}
	
	public String checkRegSchool(){
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("functionTitle", "注册结果");
		actionContext.put("regSchoolResult", "恭喜您，注册成功！");
		actionContext.put("information", "感谢您注册本网站，<a href=\"login.action\">现在开始登陆</a>");
		return "success";
	}
}
