package pers.hy.public_rooms.daoImpl;

import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;;

public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate ht=null;
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	private HibernateTemplate getHibernateTemplate(){
		if(ht==null){
			ht=new HibernateTemplate(sessionFactory);
		}
		return ht;
	}
	
	public User getUserById(String id){
		User user=(User)getHibernateTemplate().get(User.class, id);
		return user;
	}
	
	public User addUser(UserAddForm userAddForm){
		User user=(User)getHibernateTemplate().get(User.class, userAddForm.getId());
		if(user==null){
			User u=new User();
			u.setUserId(userAddForm.getId());
			u.setUserPassword(userAddForm.getPassword());
			getHibernateTemplate().save(u);
			return u;
		}else{
			return null;
		}
	}

}
