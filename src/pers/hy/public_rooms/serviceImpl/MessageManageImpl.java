package pers.hy.public_rooms.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.service.MessageManage;

public class MessageManageImpl implements MessageManage {

	public String getMessageDo() {
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			return "messageManage"; 
		}else{
			return "input";
		}
	}

	public String setMessageDo(String message) {
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "messageManage";
		}else if(sessionResult.equals("0")){
			return "messageManage";
		}else if(sessionResult.equals("1")){
			try{
			    ActionContext ctx = ActionContext.getContext();
		        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);  
		        
		        String path = request.getSession().getServletContext().getRealPath("/message");
		        	        
		        System.out.println(path);
		        
		        File f=new File(path);
		        f.mkdir();
		        
		        String fileName="通知.txt";
		        
		        FileOutputStream fos = new FileOutputStream(f+"/"+fileName);   
		        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");   
		        osw.write(message);   
		        osw.flush(); 
		        osw.close();
		        
		        /*
				BufferedWriter w=new BufferedWriter(new FileWriter(f+"/"+fileName));
				w.write(message);
				w.flush();
				w.close();*/
			}catch(Exception e){}
			
			return "messageManage";
		}else{
			return "input";
		}	
	}
	
	
	public String getNoticeDo(){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			
			ActionContext ctx = ActionContext.getContext();
	        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);  
	        
	        String path = request.getSession().getServletContext().getRealPath("/message/notice");
	        	        
	        File f=new File(path);
	        String[] noticeList=f.list();
	        
	        Factory.setHttpRequest("notices", noticeList);

			return "noticeManage"; 
		}else{
			return "input";
		}
	}
	
	public String deleteNotice(String[] noticeSelect){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "noticeManage";
		}else if(sessionResult.equals("0")){
			return "noticeManage";
		}else if(sessionResult.equals("1")){
			
			ActionContext ctx = ActionContext.getContext();
	        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);  
	        
	        String path = request.getSession().getServletContext().getRealPath("/message/notice");
	        	        
	        for(int i=0;i<noticeSelect.length;i++){
	            	
	        	String file=path+"/"+noticeSelect[i];
	            File f=new File(file);
	            f.delete();
	            
	        } 
	        return "noticeManage"; 
		}else{
			return "input";
		}	  
	}

	public String uploadNotice(File file,String fileFileName,String fileContentType){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "noticeManage";
		}else if(sessionResult.equals("0")){
			return "noticeManage";
		}else if(sessionResult.equals("1")){
			try{
				ActionContext ctx = ActionContext.getContext();
		        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);  
		        
		        String path = request.getSession().getServletContext().getRealPath("/message/notice");
		        
		        System.out.println(path);
		        
		        File f=new File(path);
		        f.mkdir();
		        
		        InputStream is = new FileInputStream(file);
		        OutputStream os = new FileOutputStream(new File(path, fileFileName));
		        
		        byte[] buffer = new byte[1];
		        int length = 0;
		        
		        while((length = is.read(buffer, 0, buffer.length))!=-1)
		        {
		            os.write(buffer);
		        }
		        
		        os.close();
		        is.close();
			}catch(Exception e){}
			
	        return "noticeManage"; 
		}else{
			return "input";
		}	  
	}
		
	public InputStream getDownloadFile(String downloadFileName){
		try{
			ActionContext ctx = ActionContext.getContext();
	        HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);    
	        String path = request.getSession().getServletContext().getRealPath("/message/notice");   
	        
	        File file=new File(path,downloadFileName);  
	        
	        System.out.println(file);
	        
	        InputStream is = new FileInputStream(file);
	        return is;
		}catch(Exception e){
			return null;
		}
		
	}
	
}
