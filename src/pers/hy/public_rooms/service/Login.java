package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.LoginForm;;

public interface Login {
	public String getLoginResult(LoginForm loginForm);
	public String getExitResult();
}
