package pers.hy.public_rooms.service;

import pers.hy.public_rooms.form.RepairAddForm;
import pers.hy.public_rooms.form.RepairQueryForm;

public interface RepairManage {
	public String getRepairList(RepairQueryForm repairQueryForm);
	public String addRepair(RepairAddForm repairAddForm);
	public String deleteRepair(int[] repairSelect);

}
