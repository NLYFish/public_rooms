package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.RentAddForm;
import pers.hy.public_rooms.form.RentLogsForm;
import pers.hy.public_rooms.service.RentManage;
import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RentUpdateForm;
import pers.hy.public_rooms.form.RoomQueryForm;

public class RentManageAction {

	private RentAddForm rentAddForm=new RentAddForm();
	private RentQueryForm rentQueryForm=new RentQueryForm();
	private RoomQueryForm roomQueryForm=new RoomQueryForm();
	private RentManage rentManage;
	private String[] rentSelect=null;
	private String rentUpdateId=null;
	private RentUpdateForm rentUpdateForm=new RentUpdateForm();
	private RentLogsForm rentLogsForm=new RentLogsForm();
	private int[] rentLogsSelect=null;
	
	public void setRoomQueryForm(RoomQueryForm roomQueryForm){
		this.roomQueryForm=roomQueryForm;
	}
	
	public RoomQueryForm getRoomQueryForm(){
		return this.roomQueryForm;
	}
	
	public void setRentLogsSelect(int[] rentLogsSelect){
		this.rentLogsSelect=rentLogsSelect;
	}
	
	public int[] getRentLogsSelect(){
		return this.rentLogsSelect;
	}
	
	public void setRentLogsForm(RentLogsForm rentLogsForm){
		this.rentLogsForm=rentLogsForm;
	}
	
	public RentLogsForm getRentLogsForm(){
		return this.rentLogsForm;
	}
	
	
	public void setRentUpdateForm(RentUpdateForm rentUpdateForm){
		this.rentUpdateForm=rentUpdateForm;
	}
	
	public RentUpdateForm getRentUpdateForm(){
		return this.rentUpdateForm;
	}
	
	public void setRentUpdateId(String rentUpdateId){
		this.rentUpdateId=rentUpdateId;
	}
	
	public String getRentUpdateId(){
		return this.rentUpdateId;
	}
	
	public void setRentSelect(String[] rentSelect){
		this.rentSelect=rentSelect;
	}
	
	public String[] getRentSelect(){
		return this.rentSelect;
	}
	
	
	public void setRentQueryForm(RentQueryForm rentQueryForm){
		this.rentQueryForm=rentQueryForm;
	}
	
	public RentQueryForm getRentQueryForm(){
		return this.rentQueryForm;
	}
	
	public void setRentManage(RentManage rentManage){
		this.rentManage=rentManage;
	}
	
	public void setRentAddForm(RentAddForm rentAddForm){
		this.rentAddForm=rentAddForm;
	}
	
	public RentAddForm getRentAddForm(){
		return this.rentAddForm;
	}
	
	
	public String getRentList(){
		return rentManage.getRentList(rentQueryForm);
	}
	
	public String addRent(){
		return rentManage.addRent(rentAddForm);
	}
	
	
	public String updateRentPage(){
		if(rentUpdateId==null){
			return "rentManage";
		}else{
			return rentManage.updateRentPage(rentUpdateId);
		}
	}
	
	
	public String updateRent(){
		if(rentUpdateForm==null){
			return "rentManage";
		}else{
			return rentManage.updateRent(rentUpdateForm);
		}
	}
	
	public String deleteRent(){
		if(rentSelect==null){
			return "rentManage";
		}else{
			return rentManage.deleteRent(rentSelect);
		}
		
	}
	
	public String getRentExpire(){
		return rentManage.getRentExpire();
	}
	
	public String rentExpire(){
		if(rentSelect==null){
			return "rentManage";
		}else{
			return rentManage.rentExpire(rentSelect);
		}
	}
	
	public String getRentLogs(){
		return rentManage.getRentLogs(rentLogsForm);
	}
	
	public String deleteRentLogs(){
		if(rentLogsSelect==null){
			return "rentLogs";
		}else{
			return rentManage.deleteRentLogs(rentLogsSelect);
		}
		
	}
	
	public String getRoomList(){
		return rentManage.getRoomList(roomQueryForm);
	}
}
