package top.yeaho.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import top.yeaho.dao.TreeDao;
import top.yeaho.entities.TreeNode;

/**
 * 
 * @author: wang zhaojie
 * @time: 2017年6月20日下午3:19:08
 * @Description: 课程目录树 Service 层
 */
public class TreeService {

	private TreeDao treeDao;
	
	/**
	 * 将目录树转成JSON数据，返回给前端
	 * @return json类型的目录树
	 */
	@SuppressWarnings("unchecked")
	public String showCourseTree(String tableName)throws IOException
	{
		//获取目录树的所有节点
		List<TreeNode> list= treeDao.showCourseTree(tableName);
		int length= list.size();
		//结点之间建立依赖，构成树形结构
		for(int i = 0;i<length;i++)
		{
			for(int j = 0;j<length;j++)
			{
				if(list.get(j).getParentId()==list.get(i).getId())
				{
					list.get(i).getChildren().add(list.get(j));
				}
			}
		}		
		
		//初始化一个空的json对象，用于存储整棵树
		JSONObject tree = new JSONObject();
		//对list遍历，找出根节点（根结点包含完整的树形结构），对根节点递归遍历
		for (TreeNode rootNode : list) {
			if(rootNode.getParentId()==0)	
			{
				JSONArray array= new JSONArray();
				tree.put( rootNode.getNodeName(),array);
				transToJSON(rootNode.getChildren(),array);
				break;
			}
		}
		//获取字符输出流
		StringWriter out = new StringWriter();
		//将JSON对象 转成JSON字符串
		tree.writeJSONString(out);
		String treeJSONText = out.toString();
		
		return treeJSONText;		 
	}
	/**
	 * 递归将树封装入JSON对象内
	 * @param list
	 * @param array
	 */
	@SuppressWarnings("unchecked")
	private void transToJSON(List<TreeNode> list,JSONArray array)
	{
		int length = list.size();
		for(int i=0;i<length;i++)
		{
			JSONObject subObj=new JSONObject();
			JSONArray subArray = new JSONArray();
			subObj.put(list.get(i).getNodeName(), subArray);
			array.add(subObj);
			transToJSON(list.get(i).getChildren(),subArray);
		}
	}

	/**
	 * 创建用于存储该课程目录树的表
	 * @param tableName 表名
	 * @return 创建成功return true
	 */
	public boolean createTreeTable(String tableName)
	{
		return treeDao.createTable(tableName);
	}
	/**
	 * 
	 * @param tableName 表名
	 * @param chapterName	待插入的章节名
	 * @param p_chapterName	 所属的父章节名
	 * @return	插入成功，return  true
	 */
	public boolean insertIntoTable(String tableName,String chapterName,String p_chapterName)
	{
		return treeDao.insertIntoTable(tableName, chapterName, p_chapterName);
	}
	/**
	 * 向课程表中更新章节
	 * @param tableName：表名
	 * @param chapterName ： 旧章节名称
	 * @param newChapterName  新章节名
	 */
	public  boolean updateChapter(String tableName, String chapterName,String newChapterName)
	{
		return treeDao.updateChapter(tableName, chapterName, newChapterName);
	}

	/**
	 * 删除某一章节
	 * @param tableName
	 * @param chapterName ：待删除的章节名
	 */
	public  boolean deleteChapter(String tableName,String chapterName)
	{
		return treeDao.deleteChapter(tableName, chapterName);
	}
	
//---------------------------getter\setter------------------------------------------
	public TreeDao getTreeDao() {
		return treeDao;
	}
	public void setTreeDao(TreeDao treeDao) {
		this.treeDao = treeDao;
	}
	
	
}
