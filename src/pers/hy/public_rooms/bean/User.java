package pers.hy.public_rooms.bean;

public class User {
	private String userId;
	private String userNo;
	private String userName;
	private String userPhone;
	private String userPassword;
	
	
	public void setUserNo(String userNo){
		this.userNo=userNo;
	}
	
	public String getUserNo(){
		return this.userNo;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserPhone(String userPhone){
		this.userPhone=userPhone;
	}
	
	public String getUserPhone(){
		return this.userPhone;
	}
	
	public void setUserId(String userId){
		this.userId=userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}

	public String getUserPassword(){
		return this.userPassword;
	}
}
