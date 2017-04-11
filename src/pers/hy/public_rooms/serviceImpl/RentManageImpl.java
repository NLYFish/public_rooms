package pers.hy.public_rooms.serviceImpl;

import pers.hy.public_rooms.form.RentAddForm;
import pers.hy.public_rooms.form.RentLogsForm;
import pers.hy.public_rooms.service.RentManage;
import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RentUpdateForm;

import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.dao.RentDao;
import pers.hy.public_rooms.bean.Rent;



public class RentManageImpl implements RentManage {

	private RentDao rentDao;
	
	public void setRentDao(RentDao rentDao){
		this.rentDao=rentDao;
	}
	
	public String getRentList(RentQueryForm rentQueryForm){
		ActionContext ctx=ActionContext.getContext();
		ctx.put("rents", rentDao.getRentList(rentQueryForm));
		return "rentManage";
	}
	
	
	public String addRent(RentAddForm rentAddForm) {
		if(rentAddForm.getRoomId().equals("")||rentAddForm.getRoomName().equals("")||rentAddForm.getRenterName().equals("")
				||rentAddForm.getRenterId().equals("")||rentAddForm.getRenterPhone().equals("")
				||rentAddForm.getStartDate().equals("")||rentAddForm.getEndDate().equals("")
				||rentAddForm.getHire().equals("")){
			return "rentAdd";
		}else{
			Rent rent=rentDao.addRent(rentAddForm);
			if(rent==null){
				ActionContext ctx=ActionContext.getContext();
				ctx.put("exist", "exist");
				return "rentAdd";
			}else{
				return "rentManage";
			}
		}
	}

	public String updateRentPage(String rentUpdateId){
		Rent rent=rentDao.updateRentPage(rentUpdateId);
		if(rent==null){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("notExist", "notExist");
			return "rentManage"; 
		}else{
			
			RentUpdateForm r=new RentUpdateForm();
			r.setRoomId(rent.getRoomId());
			r.setRoomName(rent.getRoomName());
			r.setRenterName(rent.getRenterName());
			r.setRenterId(rent.getRenterId());
			r.setRenterPhone(rent.getRenterPhone());
			
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String startDate=sdf.format(rent.getRentStartDate());
				String endDate=sdf.format(rent.getRentEndDate());
				r.setStartDate(startDate);
				r.setEndDate(endDate);
			}catch(Exception e){}
			
			r.setHire(rent.getRentHire());
			r.setOther(rent.getRentOther());
			
			
			ActionContext ctx=ActionContext.getContext();
			ctx.put("updateRent", r);
			return "rentUpdate";
		}
	}
	
	public String updateRent(RentUpdateForm rentUpdateForm){
		rentDao.updateRent(rentUpdateForm);
		return "rentManage";
	}
	
	public String deleteRent(String[] rentSelect){
		rentDao.deleteRent(rentSelect);
		return "rentManage";
	}
	
	public String getRentExpire(){
		ActionContext ctx=ActionContext.getContext();
		ctx.put("rents", rentDao.getRentExpire());
		return "rentManage";
	}
	
	public String rentExpire(String[] rentSelect){
		rentDao.rentExpire(rentSelect);
		return "rentManage";
	}
	
	public String getRentLogs(RentLogsForm rentLogsForm){
		ActionContext ctx=ActionContext.getContext();
		ctx.put("rentLs", rentDao.getRentLogs(rentLogsForm));
		return "rentLogs";
	}
	
	
}
