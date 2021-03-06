package pers.hy.public_rooms.dao;

import java.util.List;

import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.form.RoomUpdateForm;

public interface RoomDao {
	public List<Room> getRoomList(RoomQueryForm roomQueryForm);
	public Room addRoom(RoomAddForm roomAddForm);
	public Room updateRoomPage(String roomUpdateId);
	public void deleteRoom(String[] roomSelect);
	public void updateRoom(RoomUpdateForm roomUpdateForm);
	public List<Room> getNotUseRoomList(RoomQueryForm roomQueryForm);
}
