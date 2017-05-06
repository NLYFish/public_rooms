package pers.hy.public_rooms.action;

import pers.hy.public_rooms.form.RepairAddForm;
import pers.hy.public_rooms.form.RepairQueryForm;
import pers.hy.public_rooms.service.RepairManage;

public class RepairManageAction {
	private RepairManage repairManage;
	private RepairQueryForm repairQueryForm=new RepairQueryForm();
	private RepairAddForm repairAddForm=new RepairAddForm();
	private int[] repairSelect=null;
	
	public void setRepairSelect(int[] repairSelect){
		this.repairSelect=repairSelect;
	}
	
	public int[] getRepairSelect(){
		return this.repairSelect;
	}
	
	public void setRepairManage(RepairManage repairManage){
		this.repairManage=repairManage;
	}
	
	public void setRepairQueryForm(RepairQueryForm repairQueryForm){
		this.repairQueryForm=repairQueryForm;
	}

	public RepairQueryForm getRepairQueryForm(){
		return this.repairQueryForm;
	}
	
	public void setRepairAddForm(RepairAddForm repairAddForm){
		this.repairAddForm=repairAddForm;
	}
	
	public RepairAddForm getRepairAddForm(){
		return this.repairAddForm;
	}
	
	public String getRepairList(){
		return repairManage.getRepairList(repairQueryForm);
	}
	
	public String addRepair(){
		return repairManage.addRepair(repairAddForm);
	}
	
	public String deleteRepair(){
		if(repairSelect==null){
			return "repairManage";
		}else{
			return repairManage.deleteRepair(repairSelect);
		}
		
	}
}
