package pers.hy.public_rooms.form;

public class UserUpdateForm {

	private String id;
	private String no;
	private String name;
	private String phone;
	private String password;
	
	public UserUpdateForm(){
		this.id="";
		this.no="";
		this.name="";
		this.phone="";
		this.password="";
	}
	

	public void setNo(String no){
		this.no=no;
	}
	
	public String getNo(){
		return this.no;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getPhone(){
		return this.phone;
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
