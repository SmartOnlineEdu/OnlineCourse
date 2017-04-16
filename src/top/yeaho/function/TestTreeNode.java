package top.yeaho.function;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import top.yeaho.db.DBOper;
import top.yeaho.entities.ChildNode;

public class TestTreeNode {
	

	public static void main(String[] args) {
		DBOper dbOper = new DBOper();
		String sql = "select * from course_310001_node where status=1";
		ArrayList<ChildNode> arrayList = new ArrayList<ChildNode>();
		try {
			dbOper.getConnPas();
			ResultSet rs = dbOper.executeQuery(sql, null);
			while(rs.next()){
				ChildNode child = new ChildNode();
				child.setId(rs.getInt("id"));
				child.setPreNode(rs.getString("preNode"));
				child.setCurrentNode(rs.getString("currentNode"));
				child.setGroupOrder(rs.getInt("groupOrder"));
				child.setNodeName(rs.getString("nodeName"));;
				child.setResource(rs.getString("resource"));
				child.setDescription(rs.getString("description"));
				arrayList.add(child);
			}
			dbOper.closeAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Iterator<ChildNode> iterator = arrayList.iterator();
		while(iterator.hasNext()){
			ChildNode childNode = iterator.next();
			System.out.println(childNode.getId() + "\t" + childNode.getPreNode() + "\t" + childNode.getCurrentNode() + "\t" + childNode.getNodeName());
		}
		
		LinkedHashMap<String, ChildNode> linkedHashMap = new LinkedHashMap<String, ChildNode>();
		while(iterator.hasNext()){
			if(iterator.next().getPreNode().equals("#")){}
			
		}
		
		
	}

}
