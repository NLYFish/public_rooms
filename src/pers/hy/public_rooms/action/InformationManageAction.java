package pers.hy.public_rooms.action;

import pers.hy.public_rooms.service.InformationManage;

public class InformationManageAction {
	
    private String information;
    
    private InformationManage informationManage;
    
    public void setInformationManage(InformationManage informationManage){
    	this.informationManage=informationManage;
    }
	
	public void setInformation(String information){
		this.information=information;
	}
	
	public String getInformation(){
		return this.information;
	}

	
	
	public String getInformationManageDo(){
		return informationManage.getInformationManage();
	}
	
	
	public String setInformationDo(){
		return informationManage.setInformation(information);
    }
}
