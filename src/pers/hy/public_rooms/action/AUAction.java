package pers.hy.public_rooms.action;

import com.opensymphony.xwork2.ActionSupport;

import pers.hy.public_rooms.serviceImpl.Factory;

public class AUAction extends ActionSupport {

	public String execute(){
		if(Factory.getHttpSession("type")==null)
		{
			return "login";
		}else{
			
			if(Factory.getHttpSession("type").equals("0")){
				return "adminIndex";
			}else if(Factory.getHttpSession("type").equals("1")){
				return "userIndex";
			}else{
			    return "input";
			}
		}
	
	}
}
