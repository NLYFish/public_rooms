package pers.hy.public_rooms.form;

public class PasswordUpdateForm {

	private String oldPassword;
	private String newPassword;
	private String surePassword;
	
	public PasswordUpdateForm(){
		this.oldPassword="";
		this.newPassword="";
		this.surePassword="";
	}
	
	public String getOldPassword(){
		return this.oldPassword;
	}
	
	public void setOldPassword(String oldPassword){
		this.oldPassword=oldPassword;
	}
	
	public String getNewPassword(){
		return this.newPassword;
	}
	
	public void setNewPassword(String newPassword){
		this.newPassword=newPassword;
	}
	
	public String getSurePassword(){
		return this.surePassword;
	}
	
	public void setSurePassword(String surePassword){
		this.surePassword=surePassword;
	}
}
