package top.yeaho.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import top.yeaho.dao.TreeDao;
import top.yeaho.entities.TreeNode;
/**
 * �γ�Ŀ¼�� ҵ����
 * ����Ŀ¼������ɾ�Ĳ�ҵ��
 * @author wang zhaojie 
 */
public class TreeService {

	private TreeDao treeDao;
	
	/**
	 * չʾĿ¼��
	 * @return json���͵�Ŀ¼��
	 */
	public String showCourseTree(String tableName)throws IOException
	{
		List<TreeNode> list= treeDao.showCourseTree(tableName);
		int length= list.size();
		//���֮�佨���������������νṹ
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
		
//		List<TreeNode> treelist = new ArrayList<TreeNode>();
		//��ʼ��һ���յ�json�������ڴ洢������
		JSONObject tree = new JSONObject();
		//��list�������ҳ����ڵ㣨�����������������νṹ�����Ը��ڵ�ݹ����
		for (TreeNode rootNode : list) {
			if(rootNode.getParentId()==0)	
			{
				JSONArray array= new JSONArray();
				tree.put( rootNode.getNodeName(),array);
				
				transToJSON(rootNode.getChildren(),array);
				//treelist.add(rootNode);
				//showTree(rootNode.getChildren(),treelist);			
				break;
			}
		}
		StringWriter out = new StringWriter();
		tree.writeJSONString(out);
		String treeJSONText = out.toString();
		return treeJSONText;
//		return treelist;		 
	}
	/**
	 * �ݹ齫������ת��json����
	 * @param list
	 * @param array
	 */
	public void transToJSON(List<TreeNode> list,JSONArray array)
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
	 * �������ڴ洢�ÿγ̵�Ŀ¼���ı�
	 * @param tableName ����
	 * @return �����ɹ�return true
	 */
	public boolean createTreeTable(String tableName)
	{
		return treeDao.createTable(tableName);
	}
	/**
	 * 
	 * @param tableName ����
	 * @param chapterName	��������½���
	 * @param p_chapterName	 �����ĸ��½���
	 * @return	����ɹ���return  true
	 */
	public boolean insertIntoTable(String tableName,String chapterName,String p_chapterName)
	{
		return treeDao.insertIntoTable(tableName, chapterName, p_chapterName);
	}
	/**
	 * ��γ̱��и����½�
	 * @param tableName������
	 * @param chapterName �� ���½�����
	 * @param newChapterName  ���½���
	 */
	public  boolean updateChapter(String tableName, String chapterName,String newChapterName)
	{
		return treeDao.updateChapter(tableName, chapterName, newChapterName);
	}

	/**
	 * ɾ��ĳһ�½�
	 * @param tableName
	 * @param chapterName ����ɾ�����½���
	 */
	public  boolean deleteChapter(String tableName,String chapterName)
	{
		return treeDao.deleteChapter(tableName, chapterName);
	}
	
	
	
//---------------------------------------------------------------------------
	
	public TreeService() {
		super();
		// ȱʡ�Ĺ��캯��
	}

	public TreeDao getTreeDao() {
		return treeDao;
	}

	public void setTreeDao(TreeDao treeDao) {
		this.treeDao = treeDao;
	}
}
