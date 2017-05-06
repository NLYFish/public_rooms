package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.HireCountForm;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;
import pers.hy.public_rooms.service.HireManage;

public class HireManageAction {
	
	private HireManage hireManage;
	private HireQueryForm hireQueryForm=new HireQueryForm();
	private HireUpdateForm hireUpdateForm=new HireUpdateForm();
	private String hireUpdateId=null; 
	private HireCountForm hireCountForm=new HireCountForm();
	
	public void setHireCountForm(HireCountForm hireCountForm){
		this.hireCountForm=hireCountForm;
	}
	
	public HireCountForm getHireCountForm(){
		return this.hireCountForm;
	}
	
	public void setHireUpdateId(String hireUpdateId){
		this.hireUpdateId=hireUpdateId;
	}
	
	public String getHireUpdateId(){
		return this.hireUpdateId;
	}
	
	public void setHireManage(HireManage hireManage){
		this.hireManage=hireManage;
	}
	
	public void setHireUpdateForm(HireUpdateForm hireUpdateForm){
		this.hireUpdateForm=hireUpdateForm;
	}
	
	public HireUpdateForm getHireUpdateForm(){
		return this.hireUpdateForm;
	}
	
	public void setHireQueryForm(HireQueryForm hireQueryForm){
		this.hireQueryForm=hireQueryForm;
	}
	
	public HireQueryForm getHireQueryForm(){
		return this.hireQueryForm;
	}

	public String getHireList(){
		return hireManage.getHireList(hireQueryForm);
	}
	
	public String updateHire(){
		return hireManage.updateHire(hireUpdateForm);
	}
	
	public String updateHirePage(){
		if(hireUpdateId==null){
			return "hireManage";
		}else{
			return hireManage.updateHirePage(hireUpdateId);
		}
		
	}
	
	public String getHireCount(){
		return hireManage.getHireCount(hireCountForm);
	}
}
