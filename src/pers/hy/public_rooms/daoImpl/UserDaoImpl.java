package pers.hy.public_rooms.daoImpl;

import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.UserAddForm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
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
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
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
		
	public void deleteUser(String[] userSelect){
		
		for(int i=0;i<userSelect.length;i++){
			User user=(User)getHibernateTemplate().get(User.class,userSelect[i]);
			getHibernateTemplate().delete(user);
		}
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List getUserList(){
		String sql="select * from user";
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		List<User> userList=session.createSQLQuery(sql).addEntity(User.class).list();
		return userList;
	}

}
