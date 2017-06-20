package top.yeaho.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author: wang zhaojie
 * @time: 2017年6月20日下午3:11:11
 * @Description: 课程树每个节点的类型，可以根据业务修改结点的属性
 */
public class TreeNode {

	private int id;
	private String nodeName;
	private int parentId;//当前结点的
	private int level;//当前结点的所属层级
	private List children;//当前结点的所有子节点集合
	
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
