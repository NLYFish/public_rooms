package pers.hy.public_rooms.action;

import pers.hy.public_rooms.service.RoomManage;
import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.form.RoomUpdateForm;

public class RoomManageAction {
	private RoomManage roomManage;
	private RoomQueryForm roomQueryForm=new RoomQueryForm();
	private String[] roomSelect=null;
	private RoomAddForm roomAddForm=new RoomAddForm();
	private String roomUpdateId=null;
	private RoomUpdateForm roomUpdateForm=null;
	
	public void setRoomUpdateForm(RoomUpdateForm roomUpdateForm){
		this.roomUpdateForm=roomUpdateForm;
	}
	
	public RoomUpdateForm getRoomUpdateForm(){
		return this.roomUpdateForm;
	}
	
	public void setRoomUpdateId(String roomUpdateId){
		this.roomUpdateId=roomUpdateId;
	}
	
	public String getRoomUpdateId(){
		return this.roomUpdateId;
	}
	
	public void setRoomAddForm(RoomAddForm roomAddForm){
		this.roomAddForm=roomAddForm;
	}
	
	public RoomAddForm getRoomAddForm(){
		return this.roomAddForm;
	}
	
	public void setRoomManage(RoomManage roomManage){
		this.roomManage=roomManage;
	}

	public void setRoomQueryForm(RoomQueryForm roomQueryForm){
		this.roomQueryForm=roomQueryForm;
	}
	
	public RoomQueryForm getRoomQueryForm(){
		return this.roomQueryForm;
	}
	
	public void setRoomSelect(String[] roomSelect){
		this.roomSelect=roomSelect;
	}
	
	public String[] getRoomSelect(){
		return this.roomSelect;
	}
	
	public String getRoomList(){
		return roomManage.getRoomList(roomQueryForm);
	}
	
	public String addRoom(){
		return roomManage.addRoom(roomAddForm);
	}
	
	
	public String updateRoomPage(){
		if(roomUpdateId==null){
			return "roomManage";
		}else{
			return roomManage.updateRoomPage(roomUpdateId);
		}
		
	}
	
	public String updateRoom(){
		if(roomUpdateForm==null){
			return "roomManage";
		}else{
			return roomManage.updateRoom(roomUpdateForm);
		}
	}
	
	
	public String deleteRoom(){
		if(roomSelect==null){
			return "roomManage";
		}else{
			return roomManage.deleteRoom(roomSelect);
		}
		
	}
	

}
