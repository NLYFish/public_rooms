package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.HireCountForm;
import pers.hy.public_rooms.form.HireQueryForm;
import pers.hy.public_rooms.form.HireUpdateForm;

public interface HireManage {
	public String getHireList(HireQueryForm hireQueryForm);
	public String updateHirePage(String hireUpdateId);
	public String updateHire(HireUpdateForm hireUpdateForm);
	public String getHireCount(HireCountForm hireCountForm);

}
