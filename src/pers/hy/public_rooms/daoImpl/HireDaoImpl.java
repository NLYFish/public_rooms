package pers.hy.public_rooms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Hire;
import pers.hy.public_rooms.bean.RentLogs;
import pers.hy.public_rooms.bean.Repair;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.dao.HireDao;
import pers.hy.public_rooms.form.HireCountForm;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;

@Transactional
public class HireDaoImpl implements HireDao {
	
	
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
	public List<Room> getHireList(HireQueryForm hireQueryForm){
		 		
		String sql="select * from room ";
		boolean b=true;
		if (!hireQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID=?";
			}
		}
		
		if (!hireQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME=?";
			}
		}
		
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!hireQueryForm.getRoomId().equals("")) {
			query=query.setString(n, hireQueryForm.getRoomId());
			n++;
		}
		
		if (!hireQueryForm.getRoomName().equals("")) {
            query=query.setString(n, hireQueryForm.getRoomName());
            n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;	
		List<Room> roomList=sqlquery.addEntity(Room.class).list();
		return roomList;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Room updateHirePage(String hireUpdateId){
		Room room=(Room)getHibernateTemplate().get(Room.class,hireUpdateId);
		if(room==null){
			return null;
		}else{
			return room;
		}
	}
	
	public void updateHire(HireUpdateForm hireUpdateForm){		
		Room room=(Room)getHibernateTemplate().get(Room.class, hireUpdateForm.getRoomId());
		room.setRoomHire(hireUpdateForm.getHire());
		getHibernateTemplate().update(room);
	}

	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) 
	public Hire getHireCount(HireCountForm hireCountForm){
		
		Hire hire=new Hire();
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession(); 
		int income=0;
		int outcome=0;
		
		if(!hireCountForm.getType().equals("1")){
			
			String sql="select * from rent_logs where TYPE='租赁' ";
			if (!hireCountForm.getRoomId().equals("")) {
				sql =sql+"and ROOM_ID="+"'"+hireCountForm.getRoomId()+"'";	
			}
			
			if (!hireCountForm.getRoomName().equals("")) {
				sql =sql+"and ROOM_NAME="+"'"+hireCountForm.getRoomName()+"'";
			}
			
	
			if (!hireCountForm.getYear().equals("")) {
				sql =sql+"and YEAR(RENT_END_DATE)="+"'"+hireCountForm.getYear()+"'";
			}
			
			if (!hireCountForm.getMonth().equals("")) {
				sql =sql+"and MONTH(RENT_END_DATE)="+"'"+hireCountForm.getMonth()+"'";		
			}

			
			List<RentLogs> rentLs=session.createSQLQuery(sql).addEntity(RentLogs.class).list();	
			hire.setRentHires(rentLs);
			
			for(int i=0;i<rentLs.size();i++){
				income+=Integer.parseInt(rentLs.get(i).getRentHires());
			}
			
			hire.setIncome(String.valueOf(income));
			
		}
		
		
		if(!hireCountForm.getType().equals("0")){
			String sql="select * from repair ";
			boolean b=true;
			if (!hireCountForm.getRoomId().equals("")) {
				if(b==true){
				    sql =sql+"where ROOM_ID="+"'"+hireCountForm.getRoomId()+"'";
				    b=false;
				}else{
					sql =sql+"and ROOM_ID="+"'"+hireCountForm.getRoomId()+"'";
				}
			}
			
			if (!hireCountForm.getRoomName().equals("")) {
				if(b==true){
				    sql =sql+"where ROOM_NAME="+"'"+hireCountForm.getRoomName()+"'";
				    b=false;
				}else{
					sql =sql+"and ROOM_NAME="+"'"+hireCountForm.getRoomName()+"'";
				}
			}
			
			if (!hireCountForm.getYear().equals("")) {
				if(b==true){
				    sql =sql+"where YEAR(REPAIR_DATE)="+"'"+hireCountForm.getYear()+"'";
				    b=false;
				}else{
					sql =sql+"and YEAR(REPAIR_DATE)="+"'"+hireCountForm.getYear()+"'";
				}
			}
			
			if (!hireCountForm.getMonth().equals("")) {
				if(b==true){
				    sql =sql+"where MONTH(REPAIR_DATE)="+"'"+hireCountForm.getMonth()+"'";
				    b=false;
				}else{
					sql =sql+"and MONTH(REPAIR_DATE)="+"'"+hireCountForm.getMonth()+"'";
				}
			}
			
			List<Repair> repairList=session.createSQLQuery(sql).addEntity(Repair.class).list();
			hire.setRepairHires(repairList);
			
			for(int i=0;i<repairList.size();i++){
				outcome+=Integer.parseInt(repairList.get(i).getRepairHire());
			}
			
			hire.setOutcome(String.valueOf(outcome));
		}
		
		int sum=income-outcome;
		hire.setSum(String.valueOf(sum));
		
		return hire;
	}
	
}
