package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserUpdateForm;

public interface UserManage {

	public String addUser(UserAddForm userAddForm);
	public String deleteUser(String[] userSelect);
	public String getUserList();
	public String updateUserPage(String userUpdateId);
	public String updateUser(UserUpdateForm userUpdateForm);
}
