package pers.hy.public_rooms.serviceImpl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class Factory {

	public static String getHttpSession(String name) {
		ActionContext ctx = ActionContext.getContext();
		if (ctx.getSession().get(name) == null) {
			return null;
		} else {
			return (String) ctx.getSession().get(name);
		}
	}
	
	public static void setHttpSession(String name,Object value){
		ActionContext ctx=ActionContext.getContext();
		ctx.getSession().put(name,value); 
	}
	
	public static void removeHttpSession(String name){
		ActionContext ctx=ActionContext.getContext();
	    ctx.getSession().remove(name);
	}
	
	public static void setHttpRequest(String name,Object value){
		ActionContext ctx=ActionContext.getContext();
		ctx.put(name,value); 
	}
	
	public static boolean getValidation(List<String> l){
		boolean b=true;
		for(int i=0;i<l.size();i++){
			if(l.get(i).equals("")){
				b=false;
			}
		}
		return b;
	}
}
