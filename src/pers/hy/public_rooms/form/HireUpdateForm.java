package pers.hy.public_rooms.form;

public class HireUpdateForm {


		private String roomId;
		private String roomName;
		private String hire;
				
		public HireUpdateForm(){
			this.roomId="";
			this.roomName="";
			this.hire=""; 
		}
		
		public void setHire(String hire){
			this.hire=hire;
		}
		
		public String getHire(){
			return this.hire;
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
