package pers.hy.public_rooms.form;

public class HireCountForm {

	private String roomId;
	private String roomName;
	private String type;
	private String year;
	private String month;
	
	public HireCountForm(){
		this.roomId="";
		this.roomName="";
		this.type="";
		this.year="";
		this.month="";
	}
		
	public void setType(String type){
		this.type=type;
	}
	
	public String getType(){
		return this.type;
	}
	
	
	public void setYear(String year){
		this.year=year;
	}
	
	public String getYear(){
		return this.year;
	}
	
	public void setMonth(String month){
		this.month=month;
	}
	
	public String getMonth(){
		return this.month;
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
