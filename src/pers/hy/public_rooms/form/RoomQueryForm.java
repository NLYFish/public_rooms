package pers.hy.public_rooms.form;

public class RoomQueryForm {

	private String roomId;
	private String roomName;
	private String roomBuilding;
	private String roomFloor;
	
	public RoomQueryForm(){
		this.roomId="";
		this.roomName="";
		this.roomBuilding="";
		this.roomFloor="";
	}
	
	public void setRoomId(String roomId){
		this.roomId=roomId;
	}
	
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRoomName(String roomName){
		this.roomName=roomName;
	}
	
	public String getRoomName(){
		return this.roomName;
	}
	
	public void setRoomBuilding(String roomBuilding){
		this.roomBuilding=roomBuilding;
	}
	
	public String getRoomBuilding(){
		return this.roomBuilding;
	}
	
	public void setRoomFloor(String roomFloor){
		this.roomFloor=roomFloor;
	}
	
	public String getRoomFloor(){
		return this.roomFloor;
	}
	
}
