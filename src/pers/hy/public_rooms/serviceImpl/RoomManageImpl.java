package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.RoomManage;
import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.dao.RoomDao;
import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.form.RoomUpdateForm;

public class RoomManageImpl implements RoomManage {

	private RoomDao roomDao;
	
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public String getRoomList(RoomQueryForm roomQueryForm) {
		ActionContext ctx=ActionContext.getContext();
		ctx.put("rooms", roomDao.getRoomList(roomQueryForm));
		return "roomManage";
	}

	public String addRoom(RoomAddForm roomAddForm){
		if(roomAddForm.getId().equals("")||roomAddForm.getName().equals("")
				||roomAddForm.getBuilding().equals("")||roomAddForm.getFloor().equals("")
				||roomAddForm.getArea().equals("")){
			return "roomAdd";
		}else{
			Room room=roomDao.addRoom(roomAddForm);
			if(room==null){
				ActionContext ctx=ActionContext.getContext();
				ctx.put("exist", "exist");
				return "roomAdd";
			}else{
				return "roomManage";
			}
		}
	}
	
	public String updateRoomPage(String roomUpdateId){
		Room room=roomDao.updateRoomPage(roomUpdateId);
		if(room==null){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("notExist", "notExist");
			return "roomManage"; 
		}else{
			ActionContext ctx=ActionContext.getContext();
			ctx.put("updateRoom", room);
			return "roomUpdate";
		}
	}
	
	public String updateRoom(RoomUpdateForm roomUpdateForm){
		roomDao.updateRoom(roomUpdateForm);
		return "roomManage";
	}
	
	public String deleteRoom(String[] roomSelect){
		roomDao.deleteRoom(roomSelect);
		return "roomManage";
	}
	
}
