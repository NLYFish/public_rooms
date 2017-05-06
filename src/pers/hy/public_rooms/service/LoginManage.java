package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.InformationUpdateForm;
import pers.hy.public_rooms.form.LoginForm;
import pers.hy.public_rooms.form.PasswordUpdateForm;;

public interface LoginManage {
	public String getLoginResult(LoginForm loginForm);
	public String getExitResult();
	public String updatePasswordPage();
	public String updatePassword(PasswordUpdateForm passwordUpdateForm);
	public String updateInformationPage();
	public String updateInformation(InformationUpdateForm informationUpdateForm);
}
