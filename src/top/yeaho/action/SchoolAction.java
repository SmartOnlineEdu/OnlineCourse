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
		actionContext.put("functionTitle", "ע��ѧУ");
		return "reg";
	}
	
	public String checkRegSchool(){
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("functionTitle", "ע����");
		actionContext.put("regSchoolResult", "��ϲ����ע��ɹ���");
		actionContext.put("information", "��л��ע�᱾��վ��<a href=\"login.action\">���ڿ�ʼ��½</a>");
		return "success";
	}
}
