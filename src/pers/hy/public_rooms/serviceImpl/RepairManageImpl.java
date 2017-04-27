package pers.hy.public_rooms.serviceImpl;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.bean.Rent;
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
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
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
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "repairManage";
		}else if(sessionResult.equals("0")){
			return "repairManage";
		}else if(sessionResult.equals("1")){
			if(repairAddForm.getRoomId().equals("")||repairAddForm.getRepairer().equals("")
					||repairAddForm.getRepairerPhone().equals("")||repairAddForm.getRepairDate().equals("")||repairAddForm.getRepairHire().equals("")){
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
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
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
