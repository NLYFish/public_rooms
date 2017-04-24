package pers.hy.public_rooms.bean;

import java.util.Date;

public class Repair {

	private int no;
	private String roomId;
	private String roomName;
	private String repairer;
	private String repairerPhone;
	private String repairHire;
	private Date repairDate;
	private String repairOther;
	
	public void setNo(int no){
		this.no=no;
	}
	
	public int getNo(){
		return this.no;
	}
	
	public void setRepairHire(String repairHire){
		this.repairHire=repairHire;
	}
	
	public String getRepairHire(){
		return this.repairHire;
	}
		
	public void setRepairDate(Date repairDate){
		this.repairDate=repairDate;
	}
	
	public Date getRepairDate(){
		return this.repairDate;
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
	
	public void setRepairer(String repairer){
		this.repairer=repairer;
	}
	
	public String getRepairer(){
		return this.repairer;
	}	
	
	public void setRepairerPhone(String repairerPhone){
		this.repairerPhone=repairerPhone;
	}
	
	public String getRepairerPhone(){
		return this.repairerPhone;
	}
	
	public void setRepairOther(String repairOther){
		this.repairOther=repairOther;
	}
	
	public String getRepairOther(){
		return this.repairOther;
	}
}

