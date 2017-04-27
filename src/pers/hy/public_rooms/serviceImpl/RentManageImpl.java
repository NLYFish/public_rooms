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
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "login";
		}else if(sessionResult.equals("0")){
			return "adminIndex";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("rents", rentDao.getRentList(rentQueryForm));
			return "rentManage";
		}else{
			return "input";
		}
		
	}
	
	public String addRent(RentAddForm rentAddForm) {
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			if(rentAddForm.getRoomId().equals("")||rentAddForm.getRenterName().equals("")
					||rentAddForm.getStartDate().equals("")||rentAddForm.getRenter().equals("")||rentAddForm.getRenterId().equals("")
					||rentAddForm.getRenterPhone().equals("")){
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
		}else{
			return "input";
		}
		
	}

	
	public String updateRentPage(String rentUpdateId){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			Rent rent=rentDao.updateRentPage(rentUpdateId);
			if(rent==null){
				ActionContext ctx=ActionContext.getContext();
				ctx.put("notExist", "notExist");
				return "rentManage"; 
			}else{
				
				RentUpdateForm r=new RentUpdateForm();
				r.setRoomId(rent.getRoomId());
				r.setRoomName(rent.getRoomName());
				r.setType(rent.getType());
				r.setRenter(rent.getRenter());
				r.setRenterName(rent.getRenterName());
				r.setRenterId(rent.getRenterId());
				r.setRenterPhone(rent.getRenterPhone());
				
				try{
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String startDate=sdf.format(rent.getRentStartDate());
					r.setStartDate(startDate);
					r.setDay(rent.getRentDay());
				}catch(Exception e){}

				r.setOther(rent.getRentOther());
				
				
				ActionContext ctx=ActionContext.getContext();
				ctx.put("updateRent", r);
				return "rentUpdate";
			}
		}else{
			return "input";
		}
	}
	
	public String updateRent(RentUpdateForm rentUpdateForm){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			if(rentUpdateForm.getRoomId().equals("")||rentUpdateForm.getRoomName().equals("")||rentUpdateForm.getRenterName().equals("")
					||rentUpdateForm.getStartDate().equals("")||rentUpdateForm.getRenter().equals("")||rentUpdateForm.getRenterId().equals("")
					||rentUpdateForm.getRenterPhone().equals("")){
					return "rentManage";
				}else{
					rentDao.updateRent(rentUpdateForm);
					return "rentManage";
			}
		}else{
			return "input";
		}

	}
	
	public String deleteRent(String[] rentSelect){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			rentDao.deleteRent(rentSelect);
			return "rentManage";
		}else{
			return "input";
		}
		
		
		
	}
	
	public String getRentExpire(){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("rents", rentDao.getRentExpire());
			return "rentManage";
		}else{
			return "input";
		}
	}
	
	public String rentExpire(String[] rentSelect){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			rentDao.rentExpire(rentSelect);
			return "rentManage";
		}else{
			return "input";
		}
		
		
	}
	
	public String getRentLogs(RentLogsForm rentLogsForm){
		
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentManage";
		}else if(sessionResult.equals("0")){
			return "rentManage";
		}else if(sessionResult.equals("1")){
			ActionContext ctx=ActionContext.getContext();
			ctx.put("rentLs", rentDao.getRentLogs(rentLogsForm));
			return "rentLogs";
		}else{
			return "input";
		}
	}
	
	public String deleteRentLogs(int[] rentLogsSelect){
		String sessionResult=HttpSessionFactory.getHttpSession("type");	
		if(sessionResult==null){
			return "rentLogs";
		}else if(sessionResult.equals("0")){
			return "rentLogs";
		}else if(sessionResult.equals("1")){
			rentDao.deleteRentLogs(rentLogsSelect);
			return "rentLogs";
		}else{
			return "input";
		}
	}
	
}
