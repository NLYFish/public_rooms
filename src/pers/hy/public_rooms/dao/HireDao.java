package pers.hy.public_rooms.dao;

import java.util.List;

import pers.hy.public_rooms.bean.Hire;
import pers.hy.public_rooms.bean.Room;
import pers.hy.public_rooms.form.HireCountForm;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;

public interface HireDao {
	public List<Room> getHireList(HireQueryForm hireQueryForm);
	public Room updateHirePage(String hireUpdateId);
	public void updateHire(HireUpdateForm hireUpdateForm);
	public Hire getHireCount(HireCountForm hireCountForm);

}
