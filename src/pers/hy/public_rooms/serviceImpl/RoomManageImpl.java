package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.service.RoomManage;

import java.util.ArrayList;
import java.util.List;

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
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("1")){
			return "userIndex";
		}else if(sessionResult.equals("0")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("rooms", roomDao.getRoomList(roomQueryForm));
			return "roomManage";
		}else{
			return "input";
		}

	}

	public String addRoom(RoomAddForm roomAddForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "roomManage";
		}else if(sessionResult.equals("1")){
			return "roomManage";
		}else if(sessionResult.equals("0")){
			
			List<String> l=new ArrayList<String>();
			l.add(roomAddForm.getId());
			l.add(roomAddForm.getName());
			l.add(roomAddForm.getBuilding());
			l.add(roomAddForm.getFloor());
			l.add(roomAddForm.getArea());
			l.add(roomAddForm.getHire());
			
			if(Factory.getValidation(l)==false){
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
		}else{
			return "input";
		}
		
		
	}
	
	public String updateRoomPage(String roomUpdateId){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "roomManage";
		}else if(sessionResult.equals("1")){
			return "roomManage";
		}else if(sessionResult.equals("0")){
			
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
			
		}else{
			return "input";
		}
		
	
	}
	
	public String updateRoom(RoomUpdateForm roomUpdateForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "roomManage";
		}else if(sessionResult.equals("1")){
			return "roomManage";
		}else if(sessionResult.equals("0")){
			
			List<String> l=new ArrayList<String>();
			l.add(roomUpdateForm.getId());
			l.add(roomUpdateForm.getName());
			l.add(roomUpdateForm.getBuilding());
			l.add(roomUpdateForm.getFloor());
			l.add(roomUpdateForm.getArea());
			l.add(roomUpdateForm.getHire());
			
			if(Factory.getValidation(l)==false){
				return "roomManage";
			}else{
				roomDao.updateRoom(roomUpdateForm);
				return "roomManage";
			}
			
		}else{
			return "input";
		}
		
	}
	
	public String deleteRoom(String[] roomSelect){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "roomManage";
		}else if(sessionResult.equals("1")){
			return "roomManage";
		}else if(sessionResult.equals("0")){
			
			roomDao.deleteRoom(roomSelect);
			return "roomManage";
			
		}else{
			return "input";
		}
		
	}
	
}
