package pers.hy.public_rooms.daoImpl;

import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserDeleteForm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

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
		
	public User deleteUser(UserDeleteForm userDeleteForm){
		User user=(User)getHibernateTemplate().get(User.class,userDeleteForm.getId());
		if(user==null){
			return null;
		}else{
			getHibernateTemplate().delete(user);
			return user;
		}
	}
	
	
	public List getUserList(){
		String sql="select * from user";
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		List<User> userList=session.createSQLQuery(sql).addEntity(User.class).list();
		return userList;
	}

}
