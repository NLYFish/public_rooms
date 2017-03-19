package pers.hy.public_rooms.bean;

public class Admin {

	private String adminId;
	private String adminPassword;
	
	public void setAdminId(String adminId){
		this.adminId=adminId;
	}
	
	public void setAdminPassword(String adminPassword){
		this.adminPassword=adminPassword;
	}

	public String getAdminId(){
		return this.adminId;
	}
	
	public String getAdminPassword(){
		return this.adminPassword;
	}
}
