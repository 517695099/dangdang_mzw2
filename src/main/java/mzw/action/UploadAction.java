package mzw.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String fileName;
	
	public String upload()throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(fileName);
		FileUtils.copyFile(upload, new File(realPath+"\\"+uploadFileName));
		return "uploadSuccess";
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



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
