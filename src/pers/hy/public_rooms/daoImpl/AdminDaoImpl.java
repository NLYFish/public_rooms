package pers.hy.public_rooms.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import pers.hy.public_rooms.bean.Admin;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.dao.AdminDao;

public class AdminDaoImpl implements AdminDao {

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
	
	@Override
	public Admin getAdminById(String id) {
		Admin admin=(Admin)getHibernateTemplate().get(Admin.class,id);
		return admin;
	}

}
