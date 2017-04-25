package pers.hy.public_rooms.form;

public class HireQueryForm {

	private String roomId;
	private String roomName;
	
	public HireQueryForm(){
		this.roomId="";
		this.roomName="";
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
}
