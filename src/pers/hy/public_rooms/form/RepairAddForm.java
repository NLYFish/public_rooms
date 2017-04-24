package pers.hy.public_rooms.form;

public class RepairAddForm {

	private String roomId;
	private String roomName;
	private String repairer;
	private String repairerPhone;
	private String repairHire;
	private String repairDate;
	private String repairOther;
	
	public RepairAddForm(){
		this.roomId="";
		this.roomName="";
		this.repairer="";
		this.repairerPhone="";
		this.repairHire="";
		this.repairDate="";
		this.repairOther="";
	}
	
	public void setRepairHire(String repairHire){
		this.repairHire=repairHire;
	}
	
	public String getRepairHire(){
		return this.repairHire;
	}
		
	public void setRepairDate(String repairDate){
		this.repairDate=repairDate;
	}
	
	public String getRepairDate(){
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
