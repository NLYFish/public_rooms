package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.LoginManage;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.Admin;
import pers.hy.public_rooms.dao.AdminDao;
import pers.hy.public_rooms.form.InformationUpdateForm;
import pers.hy.public_rooms.form.LoginForm;
import pers.hy.public_rooms.form.PasswordUpdateForm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

@Transactional
public class LoginManageImpl implements LoginManage {

	private UserDao userDao;
	private AdminDao adminDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	public void setAdminDao(AdminDao adminDao){
		this.adminDao=adminDao;
	}
	
	public String getLoginResult(LoginForm loginForm){
		
		String sessionResult=Factory.getHttpSession("type");
		
		//return "loginPage"
		if(sessionResult==null){
			
			List<String> l=new ArrayList<String>();
			l.add(loginForm.getType());
			l.add(loginForm.getId());
			l.add(loginForm.getPassword());
	
			if(Factory.getValidation(l)==false){
				return "login";
			}else{
				
				//return "userIndex"
				if(loginForm.getType().equals("1")){
					User u=userDao.getUserById(loginForm.getId());
					if(u!=null){
						if(u.getUserPassword().equals(loginForm.getPassword())){
							Factory.setHttpSession("type",loginForm.getType());
							Factory.setHttpSession("id",loginForm.getId());
							return "userIndex";
						}else{
							Factory.setHttpRequest("loginFailure", "loginFailure");
							return "login";
						}	
					}else{
						Factory.setHttpRequest("loginFailure", "loginFailure");
						return "login";
					}
					
					//return "adminIndex"
				}else if(loginForm.getType().equals("0")){
					
					Admin a=adminDao.getAdminById(loginForm.getId());
					if(a!=null){
						if(a.getAdminPassword().equals(loginForm.getPassword())){
							Factory.setHttpSession("type",loginForm.getType());
							Factory.setHttpSession("id",loginForm.getId());
							return "adminIndex";
						}else{
							Factory.setHttpRequest("loginFailure", "loginFailure");
							return "login";
						}	
					}else{
						Factory.setHttpRequest("loginFailure", "loginFailure");
						return "login";
					}
				}else{
					Factory.setHttpRequest("loginFailure", "loginFailure");
					return "login";
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
		if(Factory.getHttpSession("type")==null){	
			return "login";
		}else{
			Factory.removeHttpSession("type");
			Factory.removeHttpSession("id");
			return "login";
		}
	}
	
	public String updatePasswordPage(){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "passwordUpdate";
		}else if(sessionResult.equals("1")){
			return "passwordUpdate";
		}else{
			return "input";
		}
	}
	
	
	public String updatePassword(PasswordUpdateForm passwordUpdateForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else{
			
			String id=Factory.getHttpSession("id");
			
			List<String> l=new ArrayList<String>();
			l.add(passwordUpdateForm.getOldPassword());
			l.add(passwordUpdateForm.getNewPassword());
			l.add(passwordUpdateForm.getSurePassword());
			
			if(Factory.getValidation(l)==false){
				return "passwordUpdate";
			}else if(!passwordUpdateForm.getNewPassword().equals(passwordUpdateForm.getSurePassword())){
				return "passwordUpdate";
			}else{		
				if(sessionResult.equals("0")){
					if(adminDao.getAdminById(id).getAdminPassword().equals(passwordUpdateForm.getOldPassword())){
						adminDao.updatePassword(id, passwordUpdateForm.getNewPassword());
						return "login";
					}else{
						Factory.setHttpRequest("error", "error");
						return "passwordUpdate";
					}
					
				}else if(sessionResult.equals("1")){
					if(userDao.getUserById(id).getUserPassword().equals(passwordUpdateForm.getOldPassword())){
						userDao.updatePassword(id, passwordUpdateForm.getNewPassword());
						return "login";
					}else{
						Factory.setHttpRequest("error", "error");
						return "passwordUpdate";
					}
				}else{
					return "input";
				}
			}
		}			
	}
	
	public String updateInformationPage(){
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "login";
		}else if(sessionResult.equals("1")){
			
			String id=Factory.getHttpSession("id");
			
			User user=userDao.updateInformationPage(id);
			
			ActionContext ctx=ActionContext.getContext();
			ctx.put("updateInformation", user);
			return "informationUpdate";
	
		}else{
			return "input";
		}
	}
	
	public String updateInformation(InformationUpdateForm informationUpdateForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "login";
		}else if(sessionResult.equals("1")){
			
			List<String> l=new ArrayList<String>();
			l.add(informationUpdateForm.getId());
			l.add(informationUpdateForm.getNo());
			l.add(informationUpdateForm.getName());
			l.add(informationUpdateForm.getPhone());
			
			if(Factory.getValidation(l)==false){
				return "informationUpdate";
			}else{
				userDao.updateInformation(informationUpdateForm);
				return "informationUpdate";
			}	
		}else{
			return "input";
		}
	}
	
}
