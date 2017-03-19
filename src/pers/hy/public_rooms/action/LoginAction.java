package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.LoginForm;
import pers.hy.public_rooms.service.Login;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private LoginForm loginForm=new LoginForm();
	private Login login;
	
	public void setLogin(Login login){
		this.login=login;
	}
	
	public void setLoginForm(LoginForm loginForm){
		this.loginForm=loginForm;
	}
	
	public LoginForm getLoginForm(){
		return this.loginForm;
	}
	
	public String exit(){
		return login.getExitResult();
	}
	
	public String execute(){
	    return login.getLoginResult(loginForm);
	}

}
