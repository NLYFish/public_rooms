package pers.hy.public_rooms.dao;

import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;
import java.util.List;

public interface UserDao {

	public User getUserById(String id);
	public User addUser(UserAddForm userAddForm);
	public void deleteUser(String[] userSelect);
	public List getUserList();
}
