package pers.hy.public_rooms.form;

public class InformationUpdateForm {


	private String id;
	private String no;
	private String name;
	private String phone;
	
	public InformationUpdateForm(){
		this.id="";
		this.no="";
		this.name="";
		this.phone="";
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
	
	public String getId(){
		return this.id;
	}
	
}
