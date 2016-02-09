package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.UserService;



public class DeconnectionAction  extends Action{
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
	
		req.getSession().setAttribute("user_name", null);
		req.getSession().setAttribute("user_id", null);
		req.getSession().setAttribute("musics", null);
		
		return mapping.findForward(Constants.FORWARD_SUCCESS);
	}
	
}