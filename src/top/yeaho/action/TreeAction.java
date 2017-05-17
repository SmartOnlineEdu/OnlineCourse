package top.yeaho.action;

import java.io.IOException;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import top.yeaho.entities.TreeNode;
import top.yeaho.service.CourseService;
import top.yeaho.service.TreeService;
/**
 * Ŀ¼����Action
 * @author wang zhaojie 
 *
 */
public class TreeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String courseName;
	private String tableName;
	private String chapterName;
	private String p_chapterName;
	private String newChapterName;
	private CourseService courseService;
	private TreeService treeService;
	

	/**
	 *��ȡ���пγ̣�������request��
	 */
	public String getAllCourse()
	{
		List list = courseService.getAllCourse();
		ServletActionContext.getRequest().setAttribute("allCourse", list);
		return SUCCESS;
	}
	
	/**
	 * ��ȡ�γ���ת�����list����������request��
	 */
	public String showTree() {
		String treeJSON;
		try {
			treeJSON = treeService.showCourseTree( courseName.trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		ServletActionContext.getRequest().setAttribute("tree", treeJSON);
		return SUCCESS;	
	}
	
	/**
	 * ���������γ̵ı��洢�ÿγ̵��½�
	 */
	public String createTable()
	{
		boolean b = treeService.createTreeTable(tableName.trim());
		if(b)
			return SUCCESS;
		else
			return ERROR;
	}
	
	/**
	 * ��ĳ�γ�����Ӧ�ı�������½�
	 */
	public String insertIntoTable()
	{
		boolean b=treeService.insertIntoTable(tableName.trim(), chapterName.trim(), p_chapterName.trim());
		if(b)
			return SUCCESS;
		else
			return ERROR;
	}
	
	/**
	 * �����½�
	 */
	public String updateChapter()
	{
		boolean b=treeService.updateChapter(tableName, chapterName, newChapterName);
		if(b)
			return SUCCESS;
		else
			return ERROR;
	}
	
	/**
	 * ɾ��ĳһ�½�
	 */
	public String deleteChapter()
	{
		boolean b=treeService.deleteChapter(tableName, chapterName);
		if(b)
			return SUCCESS;
		else
			return ERROR;
	}
	
	
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getP_chapterName() {
		return p_chapterName;
	}

	public void setP_chapterName(String p_chapterName) {
		this.p_chapterName = p_chapterName;
	}

	public String getNewChapterName() {
		return newChapterName;
	}

	public void setNewChapterName(String newChapterName) {
		this.newChapterName = newChapterName;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public TreeService getTreeService() {
		return treeService;
	}

	public void setTreeService(TreeService treeService) {
		this.treeService = treeService;
	}
}
