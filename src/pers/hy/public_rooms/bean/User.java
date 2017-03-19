package pers.hy.public_rooms.bean;

public class User {
	private String userId;
	private String userPassword;
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}

	public String getUserId(){
		return this.userId;
	}
	
	public String getUserPassword(){
		return this.userPassword;
	}
}
