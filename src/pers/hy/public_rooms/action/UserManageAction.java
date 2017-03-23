package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserDeleteForm;
import com.opensymphony.xwork2.ActionSupport;
import pers.hy.public_rooms.service.UserManage;

public class UserManageAction extends ActionSupport{
	private UserAddForm userAddForm=new UserAddForm();
	private UserDeleteForm userDeleteForm=new UserDeleteForm();
	private UserManage userManage;	
	
	public void setUserAddForm(UserAddForm userAddForm){
		this.userAddForm=userAddForm;
	}
	
	public UserAddForm getUserAddForm(){
		return this.userAddForm;
	}
	
	public void setUserDeleteForm(UserDeleteForm userDeleteForm){
		this.userDeleteForm=userDeleteForm;
	}
	
	public UserDeleteForm getUserDeleteForm(){
		return this.userDeleteForm;
	}
	
	
	public void setUserManage(UserManage userManage){
		this.userManage=userManage;
	}
	
	public String getUserList(){
		return userManage.getUserList();
	}
	
	public String addUser(){
		return userManage.addUser(userAddForm);
	}
	
	public String deleteUser(){
		return userManage.deleteUser(userDeleteForm);
	}
	
}
