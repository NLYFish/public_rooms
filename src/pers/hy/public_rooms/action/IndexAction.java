package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.service.IndexManage;


public class IndexAction {

	private IndexManage indexManage;
	private RoomQueryForm roomQueryForm=new RoomQueryForm();
	private RentQueryForm rentQueryForm=new RentQueryForm();
	
	public void setRentQueryForm(RentQueryForm rentQueryForm){
		this.rentQueryForm=rentQueryForm;
	}
	
	public RentQueryForm getRentQueryForm(){
		return this.rentQueryForm;
	}
	
	public void setIndexManage(IndexManage indexManage){
		this.indexManage=indexManage;
	} 
	
	public void setRoomQueryForm(RoomQueryForm roomQueryForm){
		this.roomQueryForm=roomQueryForm;
	}
	
	public RoomQueryForm getRoomQueryForm(){
		return this.roomQueryForm;
	}
	
	public String getNoticeDo(){
		return indexManage.getNoticeDo();
	}
	
	public String getRoomList(){
		return indexManage.getRoomList(roomQueryForm);
	}
	
	public String getRentList(){
		return indexManage.getRentList(rentQueryForm);
	}
	
}
