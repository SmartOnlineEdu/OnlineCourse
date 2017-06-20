package top.yeaho.action;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import top.yeaho.service.TreeService;
/**
 * 
 * @author: wang zhaojie
 * @time: 2017年6月20日下午2:49:33
 * @Description: 关于目录树的Action
 */
public class TreeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String courseName;
	private String tableName;
	private String chapterName;
	//父章节名
	private String p_chapterName;
	//新章节名
	private String newChapterName;
	
	private TreeService treeService;
	
	
	/**
	 * 获取JSON格式的课程树，并设置入request的属性中
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
	 * 创建新增课程的表，存储该课程的章节
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
	 * 向某课程所对应的表中添加章节
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
	 * 更新章节
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
	 * 删除某一章节
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

	public TreeService getTreeService() {
		return treeService;
	}

	public void setTreeService(TreeService treeService) {
		this.treeService = treeService;
	}
	
}
