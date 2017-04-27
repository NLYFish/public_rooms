package pers.hy.public_rooms.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.service.InformationManage;

public class InformationManageImpl implements InformationManage {

	public String getInformationManage() {
		
		System.out.println("t");
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			return "informationManage"; 
		}else{
			return "input";
		}
	}

	public String setInformation(String information) {
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "informationManage";
		}else if(sessionResult.equals("0")){
			return "informationManage";
		}else if(sessionResult.equals("1")){
			try{
			    ActionContext actionContext = ActionContext.getContext();
		        HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);  
		        String path = request.getSession().getServletContext().getRealPath("");
		        
		        File f=new File(path+"/text");
		        f.mkdir();
		        
				BufferedWriter w=new BufferedWriter(new FileWriter(f+"/informationText.txt"));
				w.write(information);
				w.flush();
				w.close();
			}catch(Exception e){}
			
			return "informationManage";
		}else{
			return "input";
		}	
	}
}
