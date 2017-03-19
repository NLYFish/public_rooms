package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.UserAddForm;
import com.opensymphony.xwork2.ActionSupport;
import pers.hy.public_rooms.service.UserManage;


public class UserManageAction extends ActionSupport{
	private UserAddForm userAddForm=new UserAddForm();
	private UserManage userManage;
	
	public void setUserAddForm(UserAddForm userAddForm){
		this.userAddForm=userAddForm;
	}
	
	public UserAddForm getUserAddForm(){
		return this.userAddForm;
	}
	
	public void setUserManage(UserManage userManage){
		this.userManage=userManage;
	}
	
	public String addUser(){
		return userManage.addUser(userAddForm);
	}
	
}
