package pers.hy.public_rooms.action;

import com.opensymphony.xwork2.ActionSupport;

import pers.hy.public_rooms.serviceImpl.HttpSessionFactory;

public class IndexAction extends ActionSupport {

	public String execute(){
		if(HttpSessionFactory.getHttpSession("type")==null)
		{
			return "login";
		}else{
			
			if(HttpSessionFactory.getHttpSession("type").equals("0")){
				return "adminIndex";
			}else if(HttpSessionFactory.getHttpSession("type").equals("1")){
				return "userIndex";
			}else{
			    return "input";
			}
		}
	
	}
}
