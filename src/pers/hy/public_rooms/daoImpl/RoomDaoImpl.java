package pers.hy.public_rooms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.dao.RoomDao;
import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.form.RoomUpdateForm;

@Transactional
public class RoomDaoImpl implements RoomDao {

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
	public List<Room> getRoomList(RoomQueryForm roomQueryForm) {
		String sql="select * from room ";
		boolean b=true;
		if (!roomQueryForm.getRoomId().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_ID=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_ID=?";
			}
		}
		
		if (!roomQueryForm.getRoomName().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_NAME=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_NAME=?";
			}
		}
		
		if (!roomQueryForm.getRoomBuilding().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_BUILDING=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_BUILDING=?";
			}
		}
		
		if (!roomQueryForm.getRoomFloor().equals("")) {
			if(b==true){
			    sql =sql+"where ROOM_FLOOR=?";
			    b=false;
			}else{
				sql =sql+"and ROOM_FLOOR=?";
			}
		}
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!roomQueryForm.getRoomId().equals("")) {
			query.setString(n, roomQueryForm.getRoomId());
			n++;
		}
		
		if (!roomQueryForm.getRoomName().equals("")) {
			query.setString(n, roomQueryForm.getRoomName());
			n++;
		}
		
		if (!roomQueryForm.getRoomBuilding().equals("")) {
			query.setString(n, roomQueryForm.getRoomBuilding());
			n++;
		}
		
		if (!roomQueryForm.getRoomFloor().equals("")) {
			query.setString(n, roomQueryForm.getRoomFloor());
			n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;
		List<Room> roomList=sqlquery.addEntity(Room.class).list();
		return roomList;
	}

	
	public Room addRoom(RoomAddForm roomAddForm){
		Room room=(Room)getHibernateTemplate().get(Room.class, roomAddForm.getId());
		if(room==null){
			Room r=new Room();
			r.setRoomId(roomAddForm.getId());
			r.setRoomName(roomAddForm.getName());
			r.setRoomBuilding(roomAddForm.getBuilding());
			r.setRoomFloor(roomAddForm.getFloor());
			r.setRoomArea(roomAddForm.getArea());
			r.setRoomOther(roomAddForm.getOther());
			r.setRoomHire(roomAddForm.getHire());
			getHibernateTemplate().save(r);
			return r;
		}else{
			return null;
		}
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Room updateRoomPage(String roomUpdateId){
		Room room=(Room)getHibernateTemplate().get(Room.class,roomUpdateId);
		if(room==null){
			return null;
		}else{
			return room;
		}
	}
	
	public void updateRoom(RoomUpdateForm roomUpdateForm){		
		Room room=(Room)getHibernateTemplate().get(Room.class, roomUpdateForm.getId());
		room.setRoomName(roomUpdateForm.getName());
		room.setRoomBuilding(roomUpdateForm.getBuilding());
		room.setRoomFloor(roomUpdateForm.getFloor());
		room.setRoomArea(roomUpdateForm.getArea());
		room.setRoomOther(roomUpdateForm.getOther());
		room.setRoomHire(roomUpdateForm.getHire());
		getHibernateTemplate().update(room);
	}
	
	public void deleteRoom(String[] roomSelect){
		for(int i=0;i<roomSelect.length;i++){
			Room room=(Room)getHibernateTemplate().get(Room.class,roomSelect[i]);
			getHibernateTemplate().delete(room);
		}
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Room> getNotUseRoomList(RoomQueryForm roomQueryForm) {
		String sql="select * from room where ROOM_ID not in (select ROOM_ID from rent )";
		if (!roomQueryForm.getRoomId().equals("")) {
			sql =sql+"and ROOM_ID=?";
		}
		
		if (!roomQueryForm.getRoomName().equals("")) {
			sql =sql+"and ROOM_NAME=?";
		}
		
		if (!roomQueryForm.getRoomBuilding().equals("")) {
			sql =sql+"and ROOM_BUILDING=?";
		}
		
		if (!roomQueryForm.getRoomFloor().equals("")) {
			sql =sql+"and ROOM_FLOOR=?";
		}
		
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sql);
		
		int n=0;
		
		if (!roomQueryForm.getRoomId().equals("")) {
			query.setString(n, roomQueryForm.getRoomId());
			n++;
		}
		
		if (!roomQueryForm.getRoomName().equals("")) {
			query.setString(n, roomQueryForm.getRoomName());
			n++;
		}
		
		if (!roomQueryForm.getRoomBuilding().equals("")) {
			query.setString(n, roomQueryForm.getRoomBuilding());
			n++;
		}
		
		if (!roomQueryForm.getRoomFloor().equals("")) {
			query.setString(n, roomQueryForm.getRoomFloor());
			n++;
		}
		
		SQLQuery sqlquery=(SQLQuery)query;
		List<Room> roomList=sqlquery.addEntity(Room.class).list();
		return roomList;
	}
	
	
	
}
