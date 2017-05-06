package pers.hy.public_rooms.daoImpl;

import pers.hy.public_rooms.dao.UserDao;
import pers.hy.public_rooms.bean.User;
import pers.hy.public_rooms.form.InformationUpdateForm;
import pers.hy.public_rooms.form.UserAddForm;
import pers.hy.public_rooms.form.UserUpdateForm;

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
			u.setUserNo(userAddForm.getNo());
			u.setUserName(userAddForm.getName());
			u.setUserPhone(userAddForm.getPhone());
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
	public List<User> getUserList(){
		String sql="select * from user";
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		List<User> userList=session.createSQLQuery(sql).addEntity(User.class).list();
		return userList;
	}

	
	public User updateUserPage(String userUpdateId){
		User user=(User)getHibernateTemplate().get(User.class,userUpdateId);
		if(user==null){
			return null;
		}else{
			return user;
		}
	}
	
	public void updateUser(UserUpdateForm userUpdateForm){
		User user=(User)getHibernateTemplate().get(User.class,userUpdateForm.getId());
		user.setUserNo(userUpdateForm.getNo());
		user.setUserName(userUpdateForm.getName());
		user.setUserPhone(userUpdateForm.getPhone());
		user.setUserPassword(userUpdateForm.getPassword());
		getHibernateTemplate().save(user);	
	}
	
	public void updatePassword(String id,String newPassword){
		User user=(User)getHibernateTemplate().get(User.class,id);
		user.setUserPassword(newPassword);
		getHibernateTemplate().save(user);
	}
	
	public User updateInformationPage(String id){
		User user=(User)getHibernateTemplate().get(User.class,id);
		return user;
	}
	
	public void updateInformation(InformationUpdateForm informationUpdateForm){
		User user=(User)getHibernateTemplate().get(User.class,informationUpdateForm.getId());
		user.setUserNo(informationUpdateForm.getNo());
		user.setUserName(informationUpdateForm.getName());
		user.setUserPhone(informationUpdateForm.getPhone());
		getHibernateTemplate().save(user);	
	}
	
}
