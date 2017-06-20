package top.yeaho.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author wang zhaojie 
 * @time 2017/6/10
 * @Description :该Action用于实现文件的上传
 *
 */
public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	//文件上传域指定的文件，属性名upload必须与文件上传域的name属性相同
	private File upload; 
	// 上传文件的原始文件名：由Struts2自动赋值, name+FileName
	private String uploadFileName;
	//上传文件的MIME类型：由Struts2自动赋值, name+ContentTypeֵ
	private String uploadContentType;
	
	
	public String execute()throws IOException
	{
		//获取ServletContext
		ServletContext servletCtx = ServletActionContext.getServletContext();		
		//获取指向文件的输入流
		InputStream in = new FileInputStream(upload);
		//根据项目的文件存放路径，获取操作系统上的真实路径
		String path = servletCtx.getRealPath("/WEB-INF/upload");
		//获取输出流（输出位置：path+File.separator+uploadFileName）,可指定绝对路径（需要手动创建文件夹）
		OutputStream out = new FileOutputStream("F:\\uploads"+File.separator+uploadFileName);
		//设立字节数组作为缓冲区(大小为1K)
		byte[] buffer = new byte[1024];
		//每次读入的字节数
		int len =0;

		while((len=in.read(buffer))>0)
		{
			//将字节数组中的字节送入输出流,写到硬盘
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();	
		return SUCCESS;
	}
	

	
//-------------------getter、setter---------------------------
	public UploadAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
}
