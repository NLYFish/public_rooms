package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserUpdateForm;

import com.opensymphony.xwork2.ActionSupport;
import pers.hy.public_rooms.service.UserManage;

public class UserManageAction extends ActionSupport{
	private UserAddForm userAddForm=new UserAddForm();
	private UserManage userManage;	
	private String[] userSelect=null;
	private String userUpdateId=null;
	private UserUpdateForm userUpdateForm=new UserUpdateForm();
	
	public UserUpdateForm getUserUpdateForm(){
		return this.userUpdateForm;
	}
	
	public void setUserUpdateForm(UserUpdateForm userUpdateForm){
		this.userUpdateForm=userUpdateForm;
	}
	
	public String getUserUpdateId(){
		return this.userUpdateId;
	}
	
	public void setUserUpdateId(String userUpdateId){
		this.userUpdateId=userUpdateId;
	}
	
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
	
	
	public String updateUserPage(){
		if(userUpdateId==null){
			return "userManage";
		}else{
			return userManage.updateUserPage(userUpdateId);
		}
	}
	
	public String updateUser(){
		return userManage.updateUser(userUpdateForm);
	}
	
	public String deleteUser(){
		if(userSelect==null){
			return "userManage";
		}else{
			return userManage.deleteUser(userSelect);
		}
		
	}
	
}
