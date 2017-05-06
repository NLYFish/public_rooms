package pers.hy.public_rooms.action;

public class MessageAndNotice {

    private String message;
    private String notice=null;
    
    public void setNotice(String notice){
		this.notice=notice;
	}
	
	public String getNotice(){
		return this.notice;
	}
    
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	
	public String messageDo(){
		
		setMessage("通知.txt");
		return "success";
	}
	
	public String noticeDo(){
		
		if(notice==null){
			return "input";
		}else{
			try{
	    		setNotice(new String(notice.getBytes("ISO-8859-1"),"UTF-8"));
	    		return "success";
	    	}catch(Exception e){
	    		return "input";
	    	}
			
		}
		
	}
}
