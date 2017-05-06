package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.InformationUpdateForm;
import pers.hy.public_rooms.form.LoginForm;
import pers.hy.public_rooms.form.PasswordUpdateForm;
import pers.hy.public_rooms.service.LoginManage;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private LoginForm loginForm=new LoginForm();
	private LoginManage loginManage;
	private PasswordUpdateForm passwordUpdateForm=new PasswordUpdateForm();
	private InformationUpdateForm informtionUpdateForm=new InformationUpdateForm();
	
	public void setInformationUpdateForm(InformationUpdateForm informtionUpdateForm){
		this.informtionUpdateForm=informtionUpdateForm;
	}
	
	public InformationUpdateForm getInformationUpdateForm(){
		return this.informtionUpdateForm;
	}
	
	
	public void setPasswordUpdateForm(PasswordUpdateForm passwordUpdateForm){
		this.passwordUpdateForm=passwordUpdateForm;
	}
	
	public PasswordUpdateForm getPasswordUpdateForm(){
		return this.passwordUpdateForm;
	}
	
	
	public void setLoginManage(LoginManage loginManage){
		this.loginManage=loginManage;
	}
	
	public void setLoginForm(LoginForm loginForm){
		this.loginForm=loginForm;
	}
	
	public LoginForm getLoginForm(){
		return this.loginForm;
	}
	
	public String exit(){
		return loginManage.getExitResult(); 
	}
	
	public String login(){
	    return loginManage.getLoginResult(loginForm);
	}

	public String updatePasswordPage(){
		return loginManage.updatePasswordPage();
	}
	
	public String updatePassword(){
		return loginManage.updatePassword(passwordUpdateForm);
	}
	
	public String updateInformationPage(){
		return loginManage.updateInformationPage();
	}
	
	public String updateInformation(){
		return loginManage.updateInformation(informtionUpdateForm);
	}
	
}
