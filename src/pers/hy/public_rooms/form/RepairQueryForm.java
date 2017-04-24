package pers.hy.public_rooms.form;

public class RepairQueryForm {

		private String roomId;
		private String roomName;
		private String repairer;
		private String repairYear;
		private String repairMonth;
		
		public RepairQueryForm(){
			this.roomId="";
			this.roomName="";
			this.repairer="";
			this.repairYear="";
			this.repairMonth="";
		}
			
		public void setRepairYear(String repairYear){
			this.repairYear=repairYear;
		}
		
		public String getRepairYear(){
			return this.repairYear;
		}
		
		public void setRepairMonth(String repairMonth){
			this.repairMonth=repairMonth;
		}
		
		public String getRepairMonth(){
			return this.repairMonth;
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
		
		
}

