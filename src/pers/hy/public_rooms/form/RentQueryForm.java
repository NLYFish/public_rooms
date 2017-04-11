package pers.hy.public_rooms.form;

public class RentQueryForm {

	private String roomId;
	private String roomName;
	private String renterName;
	private String renterId;
	
	public RentQueryForm(){
		this.roomId="";
		this.roomName="";
		this.renterName="";
		this.renterId="";
		
	}
	
	public void setRoomName(String roomName){
		this.roomName=roomName;
	}
	
	public String getRoomName(){
		return this.roomName;
	}
	
	
	public void setRoomId(String roomId){
		this.roomId=roomId;
	}
	
	public String getRoomId(){
		return this.roomId;
	}
	
	public void setRenterName(String renterName){
		this.renterName=renterName;
	}
	
	public String getRenterName(){
		return this.renterName;
	}

	public void setRenterId(String renterId){
		this.renterId=renterId;
	}
	
	public String getRenterId(){
		return this.renterId;
	}
}
