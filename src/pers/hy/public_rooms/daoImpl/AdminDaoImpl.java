package pers.hy.public_rooms.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Admin;
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
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Admin getAdminById(String id) {
		Admin admin=(Admin)getHibernateTemplate().get(Admin.class,id);
		return admin;
	}

	public void updatePassword(String id,String newPassword){
		Admin admin=(Admin)getHibernateTemplate().get(Admin.class,id);
		admin.setAdminPassword(newPassword);
		getHibernateTemplate().save(admin);
	}
	
}
