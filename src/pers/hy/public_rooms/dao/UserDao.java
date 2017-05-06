package pers.hy.public_rooms.dao;

import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.InformationUpdateForm;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserUpdateForm;

import java.util.List;

public interface UserDao {

	public User getUserById(String id);
	public User addUser(UserAddForm userAddForm);
	public void deleteUser(String[] userSelect);
	public List<User> getUserList();
	public User updateUserPage(String userUpdateId);
	public void updateUser(UserUpdateForm userUpdateForm);
	public void updatePassword(String id,String newPassword);
	public User updateInformationPage(String i);
	public void updateInformation(InformationUpdateForm informationUpdateForm);
}
