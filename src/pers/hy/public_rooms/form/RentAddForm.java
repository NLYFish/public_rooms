package pers.hy.public_rooms.form;

public class RentAddForm {

	private String roomId;
	private String type;
	private String renter;
	private String renterName;
	private String renterId;
	private String renterPhone;
	private String startDate;
	private String day;
	private String other;
	
	public RentAddForm(){
		this.roomId="";
		this.type="";
		this.renter="";
		this.renterName="";
		this.renterId="";
		this.renterPhone="";
		this.startDate=""; 
		this.day="";
		this.other="";
		
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setRenter(String renter){
		this.renter=renter;
	}
	
	public String getRenter(){
		return this.renter;
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
	
	public void setDay(String day){
		this.day=day;
	}
	
	public String getDay(){
		return this.day;
	}
	
	public void setOther(String other){
		this.other=other;
	}
	
	public String getOther(){
		return this.other;
	}
}
