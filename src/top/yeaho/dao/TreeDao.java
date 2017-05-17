package top.yeaho.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import top.yeaho.db.DBOper;
import top.yeaho.entities.TreeNode;

/**
 * Ŀ¼����Dao�� ������ʵ�ֶ�Ŀ¼���� ��ɾ�Ĳ�
 * @author wang zhaojie
 */
public class TreeDao {

	private DBOper dbOper;

	
	/**
	 * ���ݱ������γ������������ݿⴴ�����ñ����ڴ洢�ÿγ̵�Ŀ¼����
	 * @param tableName
	 * @return ������ɹ�return true ����return false
	 */
	public  boolean createTable(String tableName) {
			//��sql���ڴ�����
			String sql = "create table public." + tableName + "(id SERIAL PRIMARY KEY NOT NULL,"
					+ "name varchar(255) not null," + "parent_id int not null," + "level int not null)";
			//���´����ı����Ĭ�ϵĵ�һ����¼
			String row1 = "INSERT INTO public." + tableName + " (name,parent_id,level) VALUES (\'" + tableName + "\',0,1);";
			try {
				Connection 	conn = dbOper.getConnPas();
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
				stmt.execute(row1);
				//�����ɹ�				
				stmt.close();
				conn.close();
				return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} 
	}
	
	/**
	 * ����в����½�
	 * @param tablename ����
	 * @param chapterName	��������½���
	 * @param p_chapterName	���½������ĸ��½���
	 */
	public  boolean insertIntoTable(String tableName,String chapterName,String p_chapterName )
	{
		Connection conn =null ;
		Statement stmt=null;
		ResultSet rs =null;
		String queryParentIdAndLevel = "select id,level from public."+tableName+" where name=\'"+p_chapterName+"\';";	
		System.out.println(queryParentIdAndLevel);	
		try {
				conn = dbOper.getConnPas();				
				stmt = conn.createStatement();
				if(stmt!=null)
				{
					rs = stmt.executeQuery(queryParentIdAndLevel);
					int parent_id = -1;
					int level = 0;
					while (rs.next()) {
						parent_id = rs.getInt(1);
						level = rs.getInt(2) + 1;
					}
					String sql = "INSERT INTO public." + tableName + " (name,parent_id,level) " + "VALUES (\'" + chapterName
							+ "\'," + parent_id + "," + level + ");";
					stmt.execute(sql);
				}
				else
				{
					System.out.println("δ�������ӡ�����������������������");
					return false;
				}
				rs.close();
				stmt.close();
				conn.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
			
		}	
	
/**
 *  �����½���
 * @param tableName
 * @param chapterName	���½���
 * @param newChapterName	���½���
 * @return ���³ɹ� return true
 */
	public  boolean updateChapter(String tableName, String chapterName,String newChapterName)
	{
		String sql ="update public."+tableName+" set name=\'"+newChapterName+"\' where name=\'"+chapterName+"\';";
		try {
			Connection conn= dbOper.getConnPas();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
			return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

	/**
	 * ɾ��ĳһ�½�
	 * @param tableName
	 * @param chapterName ����ɾ�����½���
	 */
	public  boolean deleteChapter(String tableName,String chapterName)
	{		
		//��ѯ����ɾ���ļ�¼���½ڣ���id
		String queryRow = "select id from public."+tableName+" where name=\'"+chapterName+"\';";
			try {
				Connection conn = dbOper.getConnPas();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(queryRow);
				int id = -1;
				while (rs.next()) {
					id = rs.getInt(1);
				}
				//ɾ����id��Ӧ�ļ�¼�µ��ӽڵ�
				String delSubChapter = "delete from public." + tableName + " where parent_id=" + id + ";";
				stmt.execute(delSubChapter);
				// Ȼ��ɾ����id��Ӧ�ļ�¼
				String delChapter = "delete from public." + tableName + " where id=" + id + ";";
				stmt.execute(delChapter);
				rs.close();
				stmt.close();
				conn.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	
	/**
	 * ��ȡĿ¼�����еļ�¼
	 * @return  
	 */
	public List<TreeNode> showCourseTree(String tableName)
	{
		String sql = "SELECT * FROM public."+tableName;
		TreeNode root = new TreeNode();//���ڵ�
		List<TreeNode> list = new ArrayList<TreeNode>();//��Ŵ�resultSet��ȡ�������м�¼��δ�������νṹ
		try {
			Connection conn;
			conn = dbOper.getConnPas();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				//�ҳ����ڵ㣬��Ϊ�ڽ���ʱ���Զ������˵�һ����¼��ʵ���ϵ�һ����¼�����������ĸ��ڵ�
				if(rs.getInt(3)==0)
				{
					root.setId(rs.getInt(1));
					root.setNodeName(rs.getString(2));
					root.setParentId(rs.getInt(3));
					root.setLevel(rs.getInt(4));
					list.add(root);
				}
				else
				{
					TreeNode treeNode = new TreeNode();
					treeNode.setId(rs.getInt(1));
					treeNode.setNodeName(rs.getString(2));
					treeNode.setParentId(rs.getInt(3));
					treeNode.setLevel(rs.getInt(4));
					list.add(treeNode);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
//------------------------------------------------------
	public TreeDao() {
		super();
		// ȱʡ�Ĺ��캯��
	}

	public DBOper getDbOper() {
		return dbOper;
	}

	public void setDbOper(DBOper dbOper) {
		this.dbOper = dbOper;
	}
	
	
}
