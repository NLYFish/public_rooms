package pers.hy.public_rooms.dao;

import java.util.List;

import pers.hy.public_rooms.bean.Repair;
import pers.hy.public_rooms.form.RepairAddForm;
import pers.hy.public_rooms.form.RepairQueryForm;

public interface RepairDao {
	
	public List<Repair> getRepairList(RepairQueryForm repairQueryForm);
	public Repair addRepair(RepairAddForm repairAddForm);
	public void deleteRepair(int[] repairSelect);

}
