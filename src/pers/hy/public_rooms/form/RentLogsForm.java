package pers.hy.public_rooms.form;

public class RentLogsForm {
	private String roomId;
	private String roomName;
	private String renterName;
	private String renterId;
	private String rentDate;
	
	public RentLogsForm(){
		this.roomId="";
		this.roomName="";
		this.renterName="";
		this.renterId="";
		this.rentDate="";
		
	}
	
	public void setRentDate(String rentDate){
		this.rentDate=rentDate;
	}
		
	public String getRentDate(){
		return this.rentDate;
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


