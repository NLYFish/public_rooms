package pers.hy.public_rooms.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Repair;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.dao.RepairDao;
import pers.hy.public_rooms.form.RepairAddForm;
import pers.hy.public_rooms.form.RepairQueryForm;

@Transactional
public class RepairDaoImpl implements RepairDao {

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
	public List<Repair> getRepairList(RepairQueryForm repairQueryForm){
		String sql="select * from repair ";
		boolean b=true;
		if (!repairQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID=?";
			}
		}
		
		if (!repairQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME=?";
			}
		}
		
		if (!repairQueryForm.getRepairer().equals("")) {
			if(b==true){
			    sql =sql+"where REPAIRER=?";
			    b=false;
			}else{
				sql =sql+"and REPAIRER=?";
			}
		}
		
		if (!repairQueryForm.getRepairYear().equals("")) {
			if(b==true){
			    sql =sql+"where YEAR(REPAIR_DATE)=?";
			    b=false;
			}else{
				sql =sql+"and YEAR(REPAIR_DATE)=?";
			}
		}
		
		if (!repairQueryForm.getRepairMonth().equals("")) {
			if(b==true){
			    sql =sql+"where MONTH(REPAIR_DATE)=?";
			    b=false;
			}else{
				sql =sql+"and MONTH(REPAIR_DATE)=?";
			}
		}
	
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!repairQueryForm.getRoomId().equals("")) {
			query.setString(n, repairQueryForm.getRoomId());
			n++;
		}
		
		if (!repairQueryForm.getRoomName().equals("")) {
			query.setString(n, repairQueryForm.getRoomName());
			n++;
		}
		
		if (!repairQueryForm.getRepairer().equals("")) {
			query.setString(n, repairQueryForm.getRepairer());
			n++;
		}
		
		if (!repairQueryForm.getRepairYear().equals("")) {
			query.setString(n, repairQueryForm.getRepairYear());
			n++;
		}
		
		if (!repairQueryForm.getRepairMonth().equals("")) {
			query.setString(n, repairQueryForm.getRepairMonth());
			n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;	
		List<Repair> repairList=sqlquery.addEntity(Repair.class).list();
		return repairList;
	}
	

	public Repair addRepair(RepairAddForm repairAddForm){
		
		Room room=(Room)getHibernateTemplate().get(Room.class, repairAddForm.getRoomId());
		
		if(room==null){
			return null;	
		}else{
				Repair r=new Repair();
				r.setRoomId(repairAddForm.getRoomId());
				r.setRoomName(room.getRoomName());	
				r.setRepairer(repairAddForm.getRepairer());
				r.setRepairerPhone(repairAddForm.getRepairerPhone());
				r.setRepairHire(repairAddForm.getRepairHire());
				r.setRepairOther(repairAddForm.getRepairOther());
				
			    try{
					String dateString=repairAddForm.getRepairDate();
					SimpleDateFormat ssdf=new SimpleDateFormat("yyyy-MM-dd");
					Date repairDate=ssdf.parse(dateString);
					r.setRepairDate(repairDate);	
				}catch(Exception e){}
				
				getHibernateTemplate().save(r);
				return r;
		}
	}

	public void deleteRepair(int[] repairSelect){
		for(int i=0;i<repairSelect.length;i++){
			Repair repair=(Repair)getHibernateTemplate().get(Repair.class,repairSelect[i]);
			getHibernateTemplate().delete(repair);
		}
	}
	
}
