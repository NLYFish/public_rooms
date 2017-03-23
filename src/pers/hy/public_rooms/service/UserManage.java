package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserDeleteForm;

public interface UserManage {

	public String addUser(UserAddForm userAddForm);
	public String deleteUser(UserDeleteForm userDeleteForm);
	public String getUserList();
}
