package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.form.RoomUpdateForm;

public interface RoomManage {

	public String getRoomList(RoomQueryForm roomQueryForm);
	public String addRoom(RoomAddForm roomAddForm);
	public String updateRoomPage(String roomUpdateId);
	public String updateRoom(RoomUpdateForm roomUpdateForm);
	public String deleteRoom(String[] roomSelect);
}
