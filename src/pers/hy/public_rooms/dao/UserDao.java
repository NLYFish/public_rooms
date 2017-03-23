package pers.hy.public_rooms.dao;

import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserDeleteForm;
import java.util.List;

public interface UserDao {

	public User getUserById(String id);
	public User addUser(UserAddForm userAddForm);
	public User deleteUser(UserDeleteForm userDeleteForm);
	public List getUserList();
}
