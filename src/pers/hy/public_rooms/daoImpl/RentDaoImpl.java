package pers.hy.public_rooms.daoImpl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Rent;
import pers.hy.public_rooms.bean.RentLogs;
import pers.hy.public_rooms.bean.Room;
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
	public List<Rent> getRentList(RentQueryForm rentQueryForm){
		String sql="select * from rent ";
		boolean b=true;
		if (!rentQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID=?";
			}
		}
		
		if (!rentQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME=?";
			}
		}
		
		if (!rentQueryForm.getType().equals("")) {			
			if(b==true){
			    sql =sql+"where TYPE=?";
			    b=false;
			}else{
				sql =sql+"and TYPE=?";
			}
		}
		
		
		if (!rentQueryForm.getRenter().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER=?";
			    b=false;
			}else{
				sql =sql+"and RENTER=?";
			}
		}
		
		if (!rentQueryForm.getRenterName().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_NAME=?";
			    b=false;
			}else{
				sql =sql+"and RENTER_NAME=?";
			}
		}
		
		if (!rentQueryForm.getRenterId().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_ID=?";
			    b=false;
			}else{
				sql =sql+"and RENTER_ID=?";
			}
		}
		
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!rentQueryForm.getRoomId().equals("")) {
			query.setString(n,rentQueryForm.getRoomId());
			n++;
		}
		
		if (!rentQueryForm.getRoomName().equals("")) {
			query.setString(n,rentQueryForm.getRoomName());
			n++;
		}
		
		if (!rentQueryForm.getType().equals("")) {
			String type="";
			if(rentQueryForm.getType().equals("0")){
				type="分配";
			}
			if(rentQueryForm.getType().equals("1")){
				type="租赁";
			}
			query.setString(n,type);
			n++;
		}
		
		if (!rentQueryForm.getRenter().equals("")) {
			query.setString(n,rentQueryForm.getRenter());
			n++;
		}
		
		if (!rentQueryForm.getRenterName().equals("")) {
			query.setString(n,rentQueryForm.getRenterName());
			n++;
		}
		
		if (!rentQueryForm.getRenterId().equals("")) {
			query.setString(n,rentQueryForm.getRenterId());
			n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;	
		List<Rent> rentList=sqlquery.addEntity(Rent.class).list();
		return rentList;
	}
	
	
	public Rent addRent(RentAddForm rentAddForm){
		Room room=(Room)getHibernateTemplate().get(Room.class, rentAddForm.getRoomId());
		
		if(room==null){
			return null;
		}else{
			
			Rent rent=(Rent)getHibernateTemplate().get(Rent.class, rentAddForm.getRoomId());
			if(rent==null){	
				Rent r=new Rent();
				r.setRoomId(rentAddForm.getRoomId());
				r.setRoomName(room.getRoomName());
				
				if(rentAddForm.getType().equals("0")){
					r.setType("分配");
				}
				
				if(rentAddForm.getType().equals("1")){
					r.setType("租赁");
				}
				
				r.setRenter(rentAddForm.getRenter());
				r.setRenterName(rentAddForm.getRenterName());
				r.setRenterId(rentAddForm.getRenterId());
				r.setRenterPhone(rentAddForm.getRenterPhone());
				r.setRentOther(rentAddForm.getOther());
				
				if(rentAddForm.getType().equals("0")){
					r.setRentDay(null);
					r.setRentHire(null);
					r.setRentHires(null);
					try{
						String dateString=rentAddForm.getStartDate();
						SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
						Date startDate=ssdf.parse(dateString);
						Date endDate=ssdf.parse(dateString);
						r.setRentStartDate(startDate);
						r.setRentEndDate(endDate);
						
					}catch(Exception e){}
				
				}
				
				if(rentAddForm.getType().equals("1")){
					int d=1;
					if(rentAddForm.getDay().equals("")){
						r.setRentDay("1");
					}else{
						r.setRentDay(rentAddForm.getDay());
						d=Integer.parseInt(rentAddForm.getDay());
					}
					
					try{
						String startDateString=rentAddForm.getStartDate();
						SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
						Date startDate=ssdf.parse(startDateString);
						Date endDate=new Date(startDate.getTime()+(long)d*24*60*60*1000);
						r.setRentStartDate(startDate);
						r.setRentEndDate(endDate);
						
					}catch(Exception e){}
					
					r.setRentHires(String.valueOf(Integer.parseInt(room.getRoomHire())*d));
					r.setRentHire(room.getRoomHire());
				}
				
				getHibernateTemplate().save(r);
				return r;
			}else{
				return null;
			}
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
					
		Rent r=(Rent)getHibernateTemplate().get(Rent.class, rentUpdateForm.getRoomId());
		
		Room room=(Room)getHibernateTemplate().get(Room.class, rentUpdateForm.getRoomId());
		
			r.setRoomId(rentUpdateForm.getRoomId());
			r.setRoomName(rentUpdateForm.getRoomName());
			
			if(rentUpdateForm.getType().equals("0")){
				r.setType("分配");
			}
			
			if(rentUpdateForm.getType().equals("1")){
				r.setType("租赁");
			}
			
			r.setRenter(rentUpdateForm.getRenter());
			r.setRenterName(rentUpdateForm.getRenterName());
			r.setRenterId(rentUpdateForm.getRenterId());
			r.setRenterPhone(rentUpdateForm.getRenterPhone());
			r.setRentOther(rentUpdateForm.getOther());
			
			if(rentUpdateForm.getType().equals("0")){
				r.setRentDay(null);
				r.setRentHire(null);
				r.setRentHires(null);
				try{
					String dateString=rentUpdateForm.getStartDate();
					SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
					Date startDate=ssdf.parse(dateString);
					Date endDate=ssdf.parse(dateString);
					r.setRentStartDate(startDate);
					r.setRentEndDate(endDate);
					
				}catch(Exception e){}
			
			}
			
			if(rentUpdateForm.getType().equals("1")){
				int d=1;
				if(rentUpdateForm.getDay().equals("")){
					r.setRentDay("1");
				}else{
					r.setRentDay(rentUpdateForm.getDay());
					d=Integer.parseInt(rentUpdateForm.getDay());
				}
				
				try{
					String startDateString=rentUpdateForm.getStartDate();
					SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
					Date startDate=ssdf.parse(startDateString);
					Date endDate=new Date(startDate.getTime()+(long)d*24*60*60*1000);
					r.setRentStartDate(startDate);
					r.setRentEndDate(endDate);
					
				}catch(Exception e){}
				
				r.setRentHires(String.valueOf(Integer.parseInt(room.getRoomHire())*d));
				r.setRentHire(room.getRoomHire());
			}

		getHibernateTemplate().update(r);
	}
	
	
	
	public void deleteRent(String[] rentSelect){
		for(int i=0;i<rentSelect.length;i++){
			Rent rent=(Rent)getHibernateTemplate().get(Rent.class,rentSelect[i]);
			getHibernateTemplate().delete(rent);
		}
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) 
	public List<Rent> getRentExpire(){
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
			rentLogs.setType(rent.getType());
			rentLogs.setRenter(rent.getRenter());
			rentLogs.setRenterName(rent.getRenterName());
			rentLogs.setRenterId(rent.getRenterId());
			rentLogs.setRenterPhone(rent.getRenterPhone());
			rentLogs.setRentStartDate(rent.getRentStartDate());
			rentLogs.setRentEndDate(rent.getRentEndDate());
			rentLogs.setRentDay(rent.getRentDay());
			rentLogs.setRentHires(rent.getRentHires());
			rentLogs.setRentHire(rent.getRentHire());
			rentLogs.setRentOther(rent.getRentOther());
			
			getHibernateTemplate().delete(rent);
			getHibernateTemplate().save(rentLogs);
		}
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) 
	public List<RentLogs> getRentLogs(RentLogsForm rentLogsForm){
		String sql="select * from rent_logs ";
		boolean b=true;
		if (!rentLogsForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID=?";
			    b=false;
			}else{ 
				sql =sql+"and ROOM_ID=?";
			}
		}
		
		if (!rentLogsForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME=?";
			}
		}
		
		if (!rentLogsForm.getRenterName().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_NAME=?";
			    b=false;
			}else{
				sql =sql+"and RENTER_NAME=?";
			}
		}
		
		if (!rentLogsForm.getRenterId().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER_ID=?";
			    b=false;
			}else{
				sql =sql+"and RENTER_ID=?";
			}
		}
				
		if (!rentLogsForm.getType().equals("")) {
			String type="";
			if(rentLogsForm.getType().equals("0")){
				type="分配";
			}
			
			if(rentLogsForm.getType().equals("1")){
				type="租赁";
			}
			
			if(b==true){
			    sql =sql+"where TYPE=?";
			    b=false;
			}else{
				sql =sql+"and TYPE=?";
			}
		}
		
		
		if (!rentLogsForm.getRenter().equals("")) {
			if(b==true){
			    sql =sql+"where RENTER=?";
			    b=false;
			}else{
				sql =sql+"and RENTER=?";
			}
		}
		
		if(!rentLogsForm.getRentDate().equals("")){
			if(b==true){
				sql=sql+"where DATE_FORMAT(RENT_START_DATE,'%Y-%m')<=? and DATE_FORMAT(RENT_END_DATE,'%Y-%m') >=?";
			}else{
				sql=sql+"and DATE_FORMAT(RENT_START_DATE,'%Y-%m')<=? and DATE_FORMAT(RENT_END_DATE,'%Y-%m') >=?";
			}
		}
		
		/*
		if(!rentLogsForm.getRentDate().equals("")){
			if(b==true){
				sql=sql+"where DATE_FORMAT(RENT_START_DATE,'%Y-%m')<= "+"'"+rentLogsForm.getRentDate()+"'"
			        +"and DATE_FORMAT(RENT_END_DATE,'%Y-%m') >= "+"'"+rentLogsForm.getRentDate()+"'";
			}else{
				sql=sql+"and RENT_START_DATE <= "+"'"+rentLogsForm.getRentDate()+"'"
				        +"and RENT_END_DATE >= "+"'"+rentLogsForm.getRentDate()+"'";
			}
		}
		*/
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!rentLogsForm.getRoomId().equals("")) {
			query.setString(n, rentLogsForm.getRoomId());
			n++;
		}
		
		if (!rentLogsForm.getRoomName().equals("")) {
			query.setString(n, rentLogsForm.getRoomName());
			n++;
		}
		
		if (!rentLogsForm.getRenterName().equals("")) {
			query.setString(n, rentLogsForm.getRenterName());
			n++;
		}
		
		if (!rentLogsForm.getRenterId().equals("")) {
			query.setString(n, rentLogsForm.getRenterId());
			n++;
		}
				
		if (!rentLogsForm.getType().equals("")) {
			String type="";
			if(rentLogsForm.getType().equals("0")){
				type="分配";
			}
			
			if(rentLogsForm.getType().equals("1")){
				type="租赁";
			}
			query.setString(n,type);
			n++;
		}
		
		if (!rentLogsForm.getRenter().equals("")) {
			query.setString(n, rentLogsForm.getRenter());
			n++;
		}
		
		if(!rentLogsForm.getRentDate().equals("")){
			query.setString(n, rentLogsForm.getRentDate());
			n++;
			query.setString(n, rentLogsForm.getRentDate());
			n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;	
		List<RentLogs> rentLs=sqlquery.addEntity(RentLogs.class).list();	
		return rentLs;
	}
	
	
	public void deleteRentLogs(int[] rentLogsSelect){
		for(int i=0;i<rentLogsSelect.length;i++){
			RentLogs rentls=(RentLogs)getHibernateTemplate().get(RentLogs.class,rentLogsSelect[i]);
			getHibernateTemplate().delete(rentls);
	}
	
}

}
