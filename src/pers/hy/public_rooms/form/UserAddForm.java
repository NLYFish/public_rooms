package pers.hy.public_rooms.form;

public class UserAddForm {

	private String id;
	private String password;
	
	public UserAddForm(){
		this.id="";
		this.password="";
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getPassword(){
		return this.password;
	}
	
}
	
