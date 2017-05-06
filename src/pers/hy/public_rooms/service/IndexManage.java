package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RoomQueryForm;

public interface IndexManage {

	public String getNoticeDo();
	public String getRoomList(RoomQueryForm roomQueryForm);
	public String getRentList(RentQueryForm rentQueryForm);
}
