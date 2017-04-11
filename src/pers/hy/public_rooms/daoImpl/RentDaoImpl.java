package pers.hy.public_rooms.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Rent;
import pers.hy.public_rooms.bean.RentLogs;
import pers.hy.public_rooms.dao.RentDao;
import pers.hy.public_rooms.form.RentAddForm;
import pers.hy.public_rooms.form.RentLogsForm;
import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RentUpdateForm;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

@Transactional
public class RentDaoImpl implements RentDao {
	
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
	public List getRentList(RentQueryForm rentQueryForm){
		String sql="select * from rent ";
		boolean b=true;
		if (!rentQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID="+"'"+rentQueryForm.getRoomId()+"'";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID="+"'"+rentQueryForm.getRoomId()+"'";
			}
		}
		
		if (!rentQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME="+"'"+rentQueryForm.getRoomName()+"'";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME="+"'"+rentQueryForm.getRoomName()+"'";
			}
		}
		
		if (!rentQueryForm.getRenterName().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_NAME="+"'"+rentQueryForm.getRenterName()+"'";
			    b=false;
			}else{
				sql =sql+"and RENTER_NAME="+"'"+rentQueryForm.getRenterName()+"'";
			}
		}
		
		if (!rentQueryForm.getRenterId().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_ID="+"'"+rentQueryForm.getRenterId()+"'";
			    b=false;
			}else{
				sql =sql+"and RENTER_ID="+"'"+rentQueryForm.getRenterId()+"'";
			}
		}
			
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession(); 
		List<Rent> rentList=session.createSQLQuery(sql).addEntity(Rent.class).list();
		return rentList;
	}
	
	
	public Rent addRent(RentAddForm rentAddForm){
		Rent rent=(Rent)getHibernateTemplate().get(Rent.class, rentAddForm.getRoomId());
		if(rent==null){	
			Rent r=new Rent();
			r.setRoomId(rentAddForm.getRoomId());
			r.setRoomName(rentAddForm.getRoomName());
			r.setRenterName(rentAddForm.getRenterName());
			r.setRenterId(rentAddForm.getRenterId());
			r.setRenterPhone(rentAddForm.getRenterPhone());
			
			try{
				String startDateString=rentAddForm.getStartDate();
				String endDateString=rentAddForm.getEndDate();
				SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat esdf=new SimpleDateFormat("yyyy-MM-dd");
				Date startDate=ssdf.parse(startDateString);
				Date endDate=esdf.parse(endDateString);
				r.setRentStartDate(startDate);
				r.setRentEndDate(endDate);
			}catch(Exception e){}
			
			r.setRentHire(rentAddForm.getHire());
			r.setRentOther(rentAddForm.getOther());
			getHibernateTemplate().save(r);
			return r;
		}else{
			return null;
		}
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Rent updateRentPage(String rentUpdateId){
		Rent rent=(Rent)getHibernateTemplate().get(Rent.class,rentUpdateId);
		if(rent==null){
			return null;
		}else{
			return rent;
		}
	}
	
	public void updateRent(RentUpdateForm rentUpdateForm){
					
		Rent rent=(Rent)getHibernateTemplate().get(Rent.class, rentUpdateForm.getRoomId());
		rent.setRoomName(rentUpdateForm.getRoomName());
		rent.setRenterName(rentUpdateForm.getRenterName());
		rent.setRenterId(rentUpdateForm.getRenterId());
		rent.setRenterPhone(rentUpdateForm.getRenterPhone());
		
		try{
			String startDateString=rentUpdateForm.getStartDate();
			String endDateString=rentUpdateForm.getEndDate();
			SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat esdf=new SimpleDateFormat("yyyy-MM-dd");
			Date startDate=ssdf.parse(startDateString);
			Date endDate=esdf.parse(endDateString);
			rent.setRentStartDate(startDate);
			rent.setRentEndDate(endDate);
		}catch(Exception e){}
		
		rent.setRentHire(rentUpdateForm.getHire());
		rent.setRentOther(rentUpdateForm.getOther());
		
		getHibernateTemplate().update(rent);
	}
	
	
	public void deleteRent(String[] rentSelect){
		for(int i=0;i<rentSelect.length;i++){
			Rent rent=(Rent)getHibernateTemplate().get(Rent.class,rentSelect[i]);
			getHibernateTemplate().delete(rent);
		}
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) 
	public List getRentExpire(){
		String sql="select * from rent where RENT_END_DATE<NOW()";	
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession(); 
		List<Rent> rentList=session.createSQLQuery(sql).addEntity(Rent.class).list();
		return rentList;
	}
	
	public void rentExpire(String[] rentSelect){
		for(int i=0;i<rentSelect.length;i++){
			Rent rent=(Rent)getHibernateTemplate().get(Rent.class, rentSelect[i]);
			RentLogs rentLogs=new RentLogs();
			rentLogs.setRoomId(rent.getRoomId());
			rentLogs.setRoomName(rent.getRoomName());
			rentLogs.setRenterName(rent.getRenterName());
			rentLogs.setRenterId(rent.getRenterId());
			rentLogs.setRenterPhone(rent.getRenterPhone());
			rentLogs.setRentStartDate(rent.getRentStartDate());
			rentLogs.setRentEndDate(rent.getRentEndDate());
			rentLogs.setRentHire(rent.getRentHire());
			rentLogs.setRentOther(rent.getRentOther());
			
			getHibernateTemplate().delete(rent);
			getHibernateTemplate().save(rentLogs);
		}
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) 
	public List getRentLogs(RentLogsForm rentLogsForm){
		String sql="select * from rent_logs ";
		boolean b=true;
		if (!rentLogsForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID="+"'"+rentLogsForm.getRoomId()+"'";
			    b=false;
			}else{ 
				sql =sql+"and ROOM_ID="+"'"+rentLogsForm.getRoomId()+"'";
			}
		}
		
		if (!rentLogsForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME="+"'"+rentLogsForm.getRoomName()+"'";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME="+"'"+rentLogsForm.getRoomName()+"'";
			}
		}
		
		if (!rentLogsForm.getRenterName().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_NAME="+"'"+rentLogsForm.getRenterName()+"'";
			    b=false;
			}else{
				sql =sql+"and RENTER_NAME="+"'"+rentLogsForm.getRenterName()+"'";
			}
		}
		
		if (!rentLogsForm.getRenterId().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_ID="+"'"+rentLogsForm.getRenterId()+"'";
			    b=false;
			}else{
				sql =sql+"and RENTER_ID="+"'"+rentLogsForm.getRenterId()+"'";
			}
		}
		
		if(!rentLogsForm.getRentDate().equals("")){
			if(b==true){
				sql=sql+"where RENT_START_DATE < "+"'"+rentLogsForm.getRentDate()+"'"
			        +"and RENT_END_DATE > "+"'"+rentLogsForm.getRentDate()+"'";
			}else{
				sql=sql+"and RENT_START_DATE < "+"'"+rentLogsForm.getRentDate()+"'"
				        +"and RENT_END_DATE > "+"'"+rentLogsForm.getRentDate()+"'";
			}
		}
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession(); 
		List<RentLogs> rentLs=session.createSQLQuery(sql).addEntity(RentLogs.class).list();	
		return rentLs;
	}
	
	
}

