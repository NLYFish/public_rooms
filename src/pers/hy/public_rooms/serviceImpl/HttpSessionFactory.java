package pers.hy.public_rooms.serviceImpl;

import com.opensymphony.xwork2.ActionContext;

public class HttpSessionFactory {

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
}
