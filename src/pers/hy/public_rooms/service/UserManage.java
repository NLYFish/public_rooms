package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.UserAddForm;

public interface UserManage {

	public String addUser(UserAddForm userAddForm);
	public String deleteUser(String[] userSelect);
	public String getUserList();
}
