package pers.hy.public_rooms.form;

public class RoomUpdateForm {

	private String id;
	private String name;
	private String building;
	private String floor;
	private String area;
	private String address;
	private String other;
	private String hire;
	
	public void setHire(String hire){
		this.hire=hire;
	}
	
	public String getHire(){
		return this.hire;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setBuilding(String building){
		this.building=building;
	}
	
	public String getBuilding(){
		return this.building;
	}
	
	public void setFloor(String floor){
		this.floor=floor;
	}
	
	public String getFloor(){
		return this.floor;
	}
	
	
	public void setArea(String area){
		this.area=area;
	}
	
	public String getArea(){
		return this.area;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setOther(String other){
		this.other=other;
	}
	
	public String getOther(){
		return this.other;
	}
}
