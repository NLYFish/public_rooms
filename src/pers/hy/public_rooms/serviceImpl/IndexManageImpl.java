package pers.hy.public_rooms.serviceImpl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import pers.hy.public_rooms.dao.RentDao;
import pers.hy.public_rooms.dao.RoomDao;
import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.service.IndexManage;

public class IndexManageImpl implements IndexManage {

	private RentDao rentDao;
	private RoomDao roomDao;
	
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public void setRentDao(RentDao rentDao){
		this.rentDao=rentDao;
	}
	
	public String getNoticeDo(){

		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);

		String path = request.getSession().getServletContext().getRealPath("/message/notice");

		File f = new File(path);
		String[] noticeList = f.list();

		Factory.setHttpRequest("notices", noticeList);

		return "index";
	}
	
    public String getRoomList(RoomQueryForm roomQueryForm) {
	
		ActionContext ctx = ActionContext.getContext();
		ctx.put("rooms", roomDao.getNotUseRoomList(roomQueryForm));
		return "roomQuery";

	}
	
    public String getRentList(RentQueryForm rentQueryForm){

		ActionContext ctx = ActionContext.getContext();
		ctx.put("rents", rentDao.getRentList(rentQueryForm));
		return "rentQuery";

	}
    
}
