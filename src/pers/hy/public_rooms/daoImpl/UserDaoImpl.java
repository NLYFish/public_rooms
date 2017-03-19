package pers.hy.public_rooms.daoImpl;

import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.User;

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

}
