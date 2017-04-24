package pers.hy.public_rooms.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Rent;
import pers.hy.public_rooms.bean.RentHire;
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
	public List getRepairList(RepairQueryForm repairQueryForm){
		String sql="select * from repair ";
		boolean b=true;
		if (!repairQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID="+"'"+repairQueryForm.getRoomId()+"'";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID="+"'"+repairQueryForm.getRoomId()+"'";
			}
		}
		
		if (!repairQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME="+"'"+repairQueryForm.getRoomName()+"'";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME="+"'"+repairQueryForm.getRoomName()+"'";
			}
		}
		
		if (!repairQueryForm.getRepairer().equals("")) {
			if(b==true){
			    sql =sql+"where REPAIRER="+"'"+repairQueryForm.getRepairer()+"'";
			    b=false;
			}else{
				sql =sql+"and REPAIRER="+"'"+repairQueryForm.getRepairer()+"'";
			}
		}
		
		if (!repairQueryForm.getRepairYear().equals("")) {
			if(b==true){
			    sql =sql+"where YEAR(REPAIR_DATE)="+"'"+repairQueryForm.getRepairYear()+"'";
			    b=false;
			}else{
				sql =sql+"and YEAR(REPAIR_DATE)="+"'"+repairQueryForm.getRepairYear()+"'";
			}
		}
		
		if (!repairQueryForm.getRepairMonth().equals("")) {
			if(b==true){
			    sql =sql+"where MONTH(REPAIR_DATE)="+"'"+repairQueryForm.getRepairMonth()+"'";
			    b=false;
			}else{
				sql =sql+"and MONTH(REPAIR_DATE)="+"'"+repairQueryForm.getRepairMonth()+"'";
			}
		}
					
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession(); 
		List<Repair> repairList=session.createSQLQuery(sql).addEntity(Repair.class).list();
		return repairList;
	}
	

	public Repair addRepair(RepairAddForm repairAddForm){
		
		Room room=(Room)getHibernateTemplate().get(Room.class, repairAddForm.getRoomId());
		
		if(room==null){
			return null;	
		}else{
				Repair r=new Repair();
				r.setRoomId(repairAddForm.getRoomId());
				r.setRoomName(repairAddForm.getRoomName());	
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
