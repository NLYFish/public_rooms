package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.Login;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.Admin;
import pers.hy.public_rooms.dao.AdminDao;
import pers.hy.public_rooms.form.LoginForm;

import com.opensymphony.xwork2.ActionContext;

public class LoginImpl implements Login {

	private UserDao userDao;
	private AdminDao adminDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	public void setAdminDao(AdminDao adminDao){
		this.adminDao=adminDao;
	}
	
	public void setSession(LoginForm loginForm){
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put("type",loginForm.getType());
		ctx.getSession().put("id",loginForm.getId());
	}
	
	public String getSessionResult(){
		ActionContext ctx=ActionContext.getContext();
		if(ctx.getSession().get("type")==null){	
			return "null";
		}else{
			return (String)ctx.getSession().get("type");
		}
	}
	
	public String getLoginResult(LoginForm loginForm){
		
		String sessionResult=getSessionResult();
		
		//return "loginPage"
		if(sessionResult.equals("null")){
			if(loginForm.getType().equals("")){
				return "loginPage";
			}else{
				
				//return "userIndex"
				if(loginForm.getType().equals("1")){
					User u=userDao.getUserById(loginForm.getId());
					if(u!=null){
						if(u.getUserPassword().equals(loginForm.getPassword())){
							setSession(loginForm);
							return "userIndex";
						}else{
							return "loginFailure";
						}	
					}else{
						return "loginFailure";
					}
					
					//return "adminIndex"
				}else if(loginForm.getType().equals("0")){
					
					Admin a=adminDao.getAdminById(loginForm.getId());
					if(a!=null){
						if(a.getAdminPassword().equals(loginForm.getPassword())){
							setSession(loginForm);
							return "adminIndex";
						}else{
							return "loginFailure";
						}	
					}else{
						return "loginFailure";
					}
				}else{
					    return "loginFailure";
				}	
			}
			
			//return "userIndex"
		}else if(sessionResult.equals("1")){
			return "userIndex";
			
			//return "adminIndex"
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else{
			return "input";
		}
	}
	
	public String getExitResult(){
		ActionContext ctx=ActionContext.getContext();
		if(ctx.getSession().get("type")==null){	
			return "null";
		}else{
			ctx.getSession().remove("type");
			ctx.getSession().remove("id");
			return "exitPage";
		}
	}
}
