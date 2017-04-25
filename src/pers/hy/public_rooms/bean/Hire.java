package pers.hy.public_rooms.bean;

import java.util.List;

public class Hire {
	private List<RentLogs> rentHires;
	private List<Repair> repairHires;
	private String income;
	private String outcome;
	private String sum;
	
	public void setRentHires(List<RentLogs> rentHires){
		this.rentHires=rentHires;
	}

	public List<RentLogs> getRentHires(){
		return this.rentHires;
	}
	
	public List<Repair> getRepairHires(){
		return this.repairHires;
	}

	public void setRepairHires(List<Repair> repairHires){
		this.repairHires=repairHires;
	}
	
	public void setIncome(String income){
		this.income=income;
	}
	
	public String getIncome(){
		return this.income;
	}
	
	public void setOutcome(String outcome){
		this.outcome=outcome;
	}
	
	public String getOutcome(){
		return this.outcome;
	}
	
	public void setSum(String sum){
		this.sum=sum;
	}
	
	public String getSum(){
		return this.sum;
	}
	
}
