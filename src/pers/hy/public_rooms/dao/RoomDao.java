package pers.hy.public_rooms.dao;

import java.util.List;

import pers.hy.public_rooms.form.RoomQueryForm;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;
import pers.hy.public_rooms.form.RoomAddForm;
import pers.hy.public_rooms.form.RoomUpdateForm;

public interface RoomDao {
	public List getRoomList(RoomQueryForm roomQueryForm);
	public Room addRoom(RoomAddForm roomAddForm);
	public Room updateRoomPage(String roomUpdateId);
	public void deleteRoom(String[] roomSelect);
	public void updateRoom(RoomUpdateForm roomUpdateForm);
}
