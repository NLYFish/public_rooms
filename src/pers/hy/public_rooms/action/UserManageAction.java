package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.UserAddForm;
import com.opensymphony.xwork2.ActionSupport;
import pers.hy.public_rooms.service.UserManage;

public class UserManageAction extends ActionSupport{
	private UserAddForm userAddForm=new UserAddForm();
	private UserManage userManage;	
	private String[] userSelect=null;
	
	public String[] getUserSelect(){
		return this.userSelect;
	}
	
	public void setUserSelect(String[] userSelect){
		this.userSelect=userSelect;
	}
	
	
	public void setUserAddForm(UserAddForm userAddForm){
		this.userAddForm=userAddForm;
	}
	
	public UserAddForm getUserAddForm(){
		return this.userAddForm;
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
		if(userSelect==null){
			return "userManage";
		}else{
			return userManage.deleteUser(userSelect);
		}
		
	}
	
}
