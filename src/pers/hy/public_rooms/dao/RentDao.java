package pers.hy.public_rooms.dao;

import pers.hy.public_rooms.bean.Rent;
import pers.hy.public_rooms.form.RentAddForm;
import pers.hy.public_rooms.form.RentLogsForm;
import pers.hy.public_rooms.form.RentQueryForm;
import java.util.List;
import pers.hy.public_rooms.form.RentUpdateForm;

public interface RentDao {
	public Rent addRent(RentAddForm rentAddForm);
	public List getRentList(RentQueryForm rentQueryForm);
	public void deleteRent(String[] rentSelect);
	public List getRentExpire();
	public void rentExpire(String[] rentSelect);
	public Rent updateRentPage(String rentUpdateId);
	public void updateRent(RentUpdateForm rentUpdateForm);
	public List getRentLogs(RentLogsForm rentLogsForm);
	public void deleteRentLogs(int[] rentLogsSelect);
	
}
