package top.yeaho.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author wang zhaojie 
 * @time 2017/6/11
 * @Description 该Action用于实现文件下载功能，目前仅仅实现了下载功能；后期根据业务不断更新功能
 */
public class DownloadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * 该Action的属性可根据业务需求（如提交的请求发生变化）不断修改
	 */
	//待下载文件的完整文件名
	private String fileName = "F:\\uploads\\20springmvc注解开发-商品修改功能开发controller.avi";
	//下载时使用该属性对文件重命名，默认值为default_file_name
	private String downFileName = "default_file_name";
	
	/**
	 * 
	 * @return	返回一个指向待下载文件的输入流
	 * @throws IOException
	 */
	public InputStream getDownloadFile() throws IOException  
	{
		return new FileInputStream(new File(fileName));
	}
	
	public String execute() throws UnsupportedEncodingException
	{
		//获取文件的原始文件名，包括扩展名
		downFileName = fileName.substring(fileName.lastIndexOf("\\", fileName.length()-1)+1);
		
		//解决文件下载时不能正确获取中文文件名的问题		
		downFileName =new String( downFileName.getBytes("UTF-8"),"ISO8859-1");
		return SUCCESS;
	}
		
	
	//---------------getter��setter----------------------------------------

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}
	
}
