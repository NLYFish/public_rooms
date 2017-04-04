package pers.hy.public_rooms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction extends ActionSupport {

	public String execute(){
		ActionContext ctx=ActionContext.getContext();
		if(ctx.getSession().get("type")==null)
		{
			return "login";
		}else{
			
			if(ctx.getSession().get("type").equals("0")){
				return "adminIndex";
			}else if(ctx.getSession().get("type").equals("1")){
				return "userIndex";
			}else{
			    return "input";
			}
		}
	
	}
}
