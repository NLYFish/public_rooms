package pers.hy.public_rooms.action;

import java.io.File;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import pers.hy.public_rooms.service.MessageManage;

public class MessageAction {
	
    private String message=null;
    private MessageManage messageManage;
    private String[] noticeSelect=null;
    private String downloadFileName=null;
    
    private File file=null;
    private String fileFileName=null;
    private String fileContentType=null;
    
    public InputStream getDownloadFile() {
    	try{
    		String dfn=new String(downloadFileName.getBytes("ISO-8859-1"),"UTF-8");
    		return messageManage.getDownloadFile(dfn); 
    	}catch(Exception e){}
    	    return null;
	}
    
    
    public void setDownloadFileName(String downloadFileName){
    	this.downloadFileName=downloadFileName;
    }
    
    public String getDownloadFileName(){
    	return this.downloadFileName;
    }
    
    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType)
    {
        this.fileContentType = fileContentType;
    }
    
    public void setNoticeSelect(String[] noticeSelect){
    	this.noticeSelect=noticeSelect;
    }
    
    public String[] getNoticeSelect(){
    	return this.noticeSelect;
    }
    
    public void setMessageManage(MessageManage messageManage){
    	this.messageManage=messageManage;
    }
	
	public void setMessage(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return this.message;
	}

	public String getMessageDo(){
		return messageManage.getMessageDo();
	}
	
	
	public String setMessageDo(){
		if(message==null){
			return "noticeManage";
		}else{
			return messageManage.setMessageDo(message);	
		}
    }
	
	public String getNoticeDo(){
		return messageManage.getNoticeDo();
	}
	
	public String uploadNotice(){
		if(file==null || fileFileName==null || fileContentType==null){
			return "noticeManage";
		}else{
			return messageManage.uploadNotice(file,fileFileName,fileContentType);
		}
		
	}
	
	public String deleteNotice(){
		if(noticeSelect==null){
			return "noticeManage";
		}else{
			return messageManage.deleteNotice(noticeSelect);
		}
		
	}
	
	public String downloadNotice(){
		if(downloadFileName==null){
			return "noticeManage";
		}else{
			return "success";
		}
	}
	
}
