package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.UserManage;
import pers.hy.public_rooms.form.UserAddForm;
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
	}
	
	public String deleteUser(String[] userSelect){
			userDao.deleteUser(userSelect);
		    return "userManage";    
	}

	
	public String getUserList(){
		ActionContext ctx=ActionContext.getContext();
		ctx.put("users", userDao.getUserList());
		return "userManage";
	}

}
