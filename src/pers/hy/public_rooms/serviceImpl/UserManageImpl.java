package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.UserManage;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserDeleteForm;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;

public class UserManageImpl implements UserManage{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	public String addUser(UserAddForm userAddForm){
		if(userAddForm.getId().equals("")||userAddForm.getPassword().equals("")){
			return "userAddPage";
		}else{
			User user=userDao.addUser(userAddForm);
			if(user==null){
				return "userExist";
			}else{
				return "userAddSuccess";
			}
			
		}
	}
	
	public String deleteUser(UserDeleteForm userDeleteForm){
		if(userDeleteForm.getId().equals("")){
			return "userDeletePage";
		}else{
			User user=userDao.deleteUser(userDeleteForm);
			if(user==null){
				return "userNotExist";
			}else{
				return "userDeleteSuccess";
			}
		}
	}
	
	public String getUserList(){
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put("users", userDao.getUserList());
		return "userManage";
	}

}
