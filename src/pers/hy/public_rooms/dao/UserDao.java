package pers.hy.public_rooms.dao;

import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;

public interface UserDao {

	public User getUserById(String id);
	public User addUser(UserAddForm userAddForm);
}
