package pers.hy.public_rooms.bean;

import java.util.Date;

public class RentLogs {

	private int no;
	private String roomId;
	private String roomName;
	private String renterName;
	private String renterId;
	private String renterPhone;
	private Date rentStartDate;
	private Date rentEndDate;
	private String rentHire;
	private String rentOther;
	
	public void setNo(int no){
		this.no=no;
	}
	
	public int getNo(){
		return this.no;
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
	
}
