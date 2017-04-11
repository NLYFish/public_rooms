package pers.hy.public_rooms.form;

public class RentAddForm {

	private String roomId;
	private String roomName;
	private String renterName;
	private String renterId;
	private String renterPhone;
	private String startDate;
	private String endDate;
	private String hire;
	private String other;
	
	public RentAddForm(){
		this.roomId="";
		this.roomName="";
		this.renterName="";
		this.renterId="";
		this.renterPhone="";
		this.startDate=""; 
		this.endDate="";
		this.hire="";
		this.other="";
		
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
	
	public void setRenterPhone(String renterPhone){
		this.renterPhone=renterPhone;
	}
	
	public String getRenterPhone(){
		return this.renterPhone;
	}
	
	public void setStartDate(String startDate){
		this.startDate=startDate;
	}
	
	public String getStartDate(){
		return this.startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate=endDate;
	}
	
	public String getEndDate(){
		return this.endDate;
	}
	
	public void setHire(String hire){
		this.hire=hire;
	}
	
	public String getHire(){
		return this.hire;
	}
	
	public void setOther(String other){
		this.other=other;
	}
	
	public String getOther(){
		return this.other;
	}
}
