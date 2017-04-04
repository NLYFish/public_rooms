package pers.hy.public_rooms.bean;

public class Room {
	private String roomId;
	private String roomName;
	private String roomBuilding;
	private String roomFloor;
	private String roomArea;
	private String roomAddress;
	private String roomOther;
	
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
	
	
	public void setRoomArea(String roomArea){
		this.roomArea=roomArea;
	}
	
	public String getRoomArea(){
		return this.roomArea;
	}
	
	public void setRoomAddress(String roomAddress){
		this.roomAddress=roomAddress;
	}
	
	public String getRoomAddress(){
		return this.roomAddress;
	}
	
	public void setRoomOther(String roomOther){
		this.roomOther=roomOther;
	}
	
	public String getRoomOther(){
		return this.roomOther;
	}
	
}
