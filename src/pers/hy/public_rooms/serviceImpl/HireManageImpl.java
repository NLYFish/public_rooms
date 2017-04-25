package pers.hy.public_rooms.serviceImpl;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.dao.HireDao;
import pers.hy.public_rooms.form.HireCountForm;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;
import pers.hy.public_rooms.service.HireManage;

public class HireManageImpl implements HireManage {
	
	private HireDao hireDao;
	
	public void setHireDao(HireDao hireDao){
		this.hireDao=hireDao;
	}
	
	public String getHireList(HireQueryForm hireQueryForm){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("hires", hireDao.getHireList(hireQueryForm));
			return "hireManage";
		}else{
			return "input";
		}
	}
	
	public String updateHirePage(String hireUpdateId){
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "hireManage";
		}else if(sessionResult.equals("0")){
			return "hireManage";
		}else if(sessionResult.equals("1")){
			Room room=hireDao.updateHirePage(hireUpdateId);
			if(room==null){
				ActionContext ctx=ActionContext.getContext();
				ctx.put("notExist", "notExist");
				return "hireManage"; 
			}else{
				ActionContext ctx=ActionContext.getContext();
				ctx.put("updateHire", room);
				return "hireUpdate";
			}
		}else{
			return "input";
		}

	}
	
	public String updateHire(HireUpdateForm hireUpdateForm){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "hireManage";
		}else if(sessionResult.equals("0")){
			return "hireManage";
		}else if(sessionResult.equals("1")){
			hireDao.updateHire(hireUpdateForm);
			return "hireManage";
		}else{
			return "input";
		}
	}

    public String getHireCount(HireCountForm hireCountForm){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("rentHires",hireDao.getHireCount(hireCountForm).getRentHires());
			ctx.put("repairHires",hireDao.getHireCount(hireCountForm).getRepairHires());
			ctx.put("income",hireDao.getHireCount(hireCountForm).getIncome());
			ctx.put("outcome",hireDao.getHireCount(hireCountForm).getOutcome());
			ctx.put("sum",hireDao.getHireCount(hireCountForm).getSum());
			return "hireCount";
		}else{
			return "input";
		}
	}
	
}
