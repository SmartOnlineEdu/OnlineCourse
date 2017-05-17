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
 * 目录树的Dao层 、真正实现对目录树的 增删改查
 * @author wang zhaojie
 */
public class TreeDao {

	private DBOper dbOper;

	
	/**
	 * 根据表名（课程名），在数据库创建表（该表用于存储该课程的目录树）
	 * @param tableName
	 * @return 若建表成功return true 否则return false
	 */
	public  boolean createTable(String tableName) {
			//该sql用于创建表
			String sql = "create table public." + tableName + "(id SERIAL PRIMARY KEY NOT NULL,"
					+ "name varchar(255) not null," + "parent_id int not null," + "level int not null)";
			//向新创建的表插入默认的第一条记录
			String row1 = "INSERT INTO public." + tableName + " (name,parent_id,level) VALUES (\'" + tableName + "\',0,1);";
			try {
				Connection 	conn = dbOper.getConnPas();
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
				stmt.execute(row1);
				//创建成功				
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
	 * 向表中插入章节
	 * @param tablename 表名
	 * @param chapterName	待插入的章节名
	 * @param p_chapterName	该章节所属的父章节名
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
					System.out.println("未建立连接。。。。。。。。。。。。");
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
 *  更新章节名
 * @param tableName
 * @param chapterName	旧章节名
 * @param newChapterName	新章节名
 * @return 更新成功 return true
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
	 * 删除某一章节
	 * @param tableName
	 * @param chapterName ：待删除的章节名
	 */
	public  boolean deleteChapter(String tableName,String chapterName)
	{		
		//查询出待删除的记录（章节）的id
		String queryRow = "select id from public."+tableName+" where name=\'"+chapterName+"\';";
			try {
				Connection conn = dbOper.getConnPas();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(queryRow);
				int id = -1;
				while (rs.next()) {
					id = rs.getInt(1);
				}
				//删除该id对应的记录下的子节点
				String delSubChapter = "delete from public." + tableName + " where parent_id=" + id + ";";
				stmt.execute(delSubChapter);
				// 然后删除该id对应的记录
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
	 * 获取目录树表中的记录
	 * @return  
	 */
	public List<TreeNode> showCourseTree(String tableName)
	{
		String sql = "SELECT * FROM public."+tableName;
		TreeNode root = new TreeNode();//根节点
		List<TreeNode> list = new ArrayList<TreeNode>();//存放从resultSet中取出的所有记录，未建立树形结构
		try {
			Connection conn;
			conn = dbOper.getConnPas();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				//找出根节点，因为在建表时，自动插入了第一条记录，实际上第一条记录就是整个树的根节点
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
		// 缺省的构造函数
	}

	public DBOper getDbOper() {
		return dbOper;
	}

	public void setDbOper(DBOper dbOper) {
		this.dbOper = dbOper;
	}
	
	
}
