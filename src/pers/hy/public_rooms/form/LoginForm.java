package pers.hy.public_rooms.form;

public class LoginForm {

	private String id;
	private String password;
	private String type;
	
	public LoginForm(){
		this.id="";
		this.password="";
		this.type="";
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setPassword(String password){
		this.password=password;
	}

	public void setType(String type){
		this.type=type;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getType(){
		return this.type;
	}
}
