package pers.hy.public_rooms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.bean.Repair;
import pers.hy.public_rooms.dao.RepairDao;
import pers.hy.public_rooms.form.RepairAddForm;
import pers.hy.public_rooms.form.RepairQueryForm;
import pers.hy.public_rooms.service.RepairManage;

public class RepairManageImpl implements RepairManage {
	
	private RepairDao repairDao;
	
	public void setRepairDao(RepairDao repairDao){
		this.repairDao=repairDao;
	}
	
	public String getRepairList(RepairQueryForm repairQueryForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("repairs", repairDao.getRepairList(repairQueryForm));
			return "repairManage";
		}else{
			return "input";
		}
		
	}

	public String addRepair(RepairAddForm repairAddForm){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "repairManage";
		}else if(sessionResult.equals("0")){
			return "repairManage";
		}else if(sessionResult.equals("1")){
			
			List<String> l=new ArrayList<String>();
			l.add(repairAddForm.getRoomId());
			l.add(repairAddForm.getRepairer());
			l.add(repairAddForm.getRepairerPhone());
			l.add(repairAddForm.getRepairDate());
			l.add(repairAddForm.getRepairHire());
			
			if(Factory.getValidation(l)==false){
				return "repairAdd";
			}else{
				Repair repair=repairDao.addRepair(repairAddForm);
				if(repair==null){
					ActionContext ctx=ActionContext.getContext();
					ctx.put("noExist", "noExist");
					return "repairAdd";
				}else{
					return "repairManage";
				}
			}
		}else{
			return "input";
		}
	}
	
	public String deleteRepair(int[] repairSelect){
		
		String sessionResult=Factory.getHttpSession("type");	
		if(sessionResult==null){
			return "repairManage";
		}else if(sessionResult.equals("0")){
			return "repairManage";
		}else if(sessionResult.equals("1")){
			repairDao.deleteRepair(repairSelect);
			return "repairManage";
		}else{
			return "input";
		}	
	}
	
}
