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
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "userManage";
		}else if(sessionResult.equals("1")){
			return "userManage";
		}else if(sessionResult.equals("0")){
			
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
		}else{
			return "input";
		}
	}
	
	public String deleteUser(String[] userSelect){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
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
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
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
	

}
