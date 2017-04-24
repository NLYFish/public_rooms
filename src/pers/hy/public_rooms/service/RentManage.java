package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.RentAddForm;
import pers.hy.public_rooms.form.RentLogsForm;
import pers.hy.public_rooms.form.RentQueryForm;
import pers.hy.public_rooms.form.RentUpdateForm;

public interface RentManage {

	public String addRent(RentAddForm rentAddForm);
	public String getRentList(RentQueryForm rentQueryForm);
	public String getRentExpire();
	public String deleteRent(String[] rentSelect);
	public String rentExpire(String[] rentSelect);
	public String updateRentPage(String rentUpdateId);
	public String updateRent(RentUpdateForm rentUpdateForm);
	public String getRentLogs(RentLogsForm rentLogsForm);
	public String deleteRentLogs(int[] rentLogsSelect);
	
	
}
