package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.UserManage;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserUpdateForm;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class UserManageImpl implements UserManage{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	public String addUser(UserAddForm userAddForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "userManage";
		}else if(sessionResult.equals("1")){
			return "userManage";
		}else if(sessionResult.equals("0")){
			
			List<String> l=new ArrayList<String>();
			l.add(userAddForm.getId());
			l.add(userAddForm.getNo());
			l.add(userAddForm.getPhone());
			l.add(userAddForm.getPassword());
			l.add(userAddForm.getName());
			
			if(Factory.getValidation(l)==false){
				return "userAdd";
			}else{
				User user=userDao.addUser(userAddForm);
				if(user==null){
					ActionContext ctx=ActionContext.getContext();
					ctx.put("exist","exist");
					return "userAdd";
				}else{
					return "userManage";
				}	
			}
		}else{
			return "input";
		}
	}
	
	public String deleteUser(String[] userSelect){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "userManage";
		}else if(sessionResult.equals("1")){
			return "userManage";
		}else if(sessionResult.equals("0")){
			userDao.deleteUser(userSelect);
		    return "userManage";  
		}else{
			return "input";
		}	  
	}

	public String getUserList(){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("1")){
			return "userIndex";
		}else if(sessionResult.equals("0")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("users", userDao.getUserList());
			return "userManage";
		}else{
			return "input";
		}
		
	}
	
	
	public String updateUserPage(String userUpdateId){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "userManage";
		}else if(sessionResult.equals("1")){
			return "userManage";
		}else if(sessionResult.equals("0")){
			
			User user=userDao.updateUserPage(userUpdateId);
			if(user==null){
				ActionContext ctx=ActionContext.getContext();
				ctx.put("notExist", "notExist");
				return "userManage"; 
			}else{
				ActionContext ctx=ActionContext.getContext();
				ctx.put("updateUser", user);
				return "userUpdate";
			}
			
		}else{
			return "input";
		}
	}

	public String updateUser(UserUpdateForm userUpdateForm){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "userManage";
		}else if(sessionResult.equals("1")){
			return "userManage";
		}else if(sessionResult.equals("0")){
			
			List<String> l=new ArrayList<String>();
			l.add(userUpdateForm.getId());
			l.add(userUpdateForm.getNo());
			l.add(userUpdateForm.getName());
			l.add(userUpdateForm.getPhone());
			l.add(userUpdateForm.getPassword());
			
			if(Factory.getValidation(l)==false){
				return "userManage";
			}else{
				userDao.updateUser(userUpdateForm);
				return "userManage";
			}
			
		}else{
			return "input";
		}
	}
	
}
