package pers.hy.public_rooms.bean;

import java.util.Date;

public class Rent {
	private String roomId;
	private String roomName;
	private String type;
	private String renter;
	private String renterName;
	private String renterId;
	private String renterPhone;
	private Date rentStartDate;
	private Date rentEndDate;
	private String rentDay;
	private String rentHires;
	private String rentHire;
	private String rentOther;
	
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
	
	public void setRentStartDate(Date rentStartDate){
		this.rentStartDate=rentStartDate;
	}
	
	public Date getRentStartDate(){
		return this.rentStartDate;
	}
	
	public void setRentEndDate(Date rentEndDate){
		this.rentEndDate=rentEndDate;
	}
	
	public Date getRentEndDate(){
		return this.rentEndDate;
	}
	
	public void setRentHires(String rentHires){
		this.rentHires=rentHires;
	}
	
	public String getRentHires(){
		return this.rentHires;
	}
	
	public void setRentHire(String rentHire){
		this.rentHire=rentHire;
	}
	
	public String getRentHire(){
		return this.rentHire;
	}
	
	public void setRentOther(String rentOther){
		this.rentOther=rentOther;
	}
	
	public String getRentOther(){
		return this.rentOther;
	}
	
	public void setRentDay(String rentDay){
		this.rentDay=rentDay;
	}
	
	public String getRentDay(){
		return this.rentDay;
	}
	
	
}
