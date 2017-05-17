package top.yeaho.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的每个节点的类型
 * @author wang zhaojie 
 *
 */
public class TreeNode {

	private int id;
	private String nodeName;
	private int parentId;
	private int level;
	private List children;
	
	public TreeNode() {
		super();
		this.children = new ArrayList<TreeNode>();
	}
	
	
	public TreeNode(String nodeName,  int parentId, int level, List children) {
		super();
		this.nodeName = nodeName;
		this.parentId = parentId;
		this.level = level;
		this.children = children;
	}


	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
