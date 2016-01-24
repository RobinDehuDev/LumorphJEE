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



public class ConnectionAction  extends Action{
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		String messageResult;
		ConnectionVO connection = (ConnectionVO) form;
		
		IUserService userService = UserService.getInstance();
		
		UserVO userVO = userService.connection(connection);
		
		if(userVO!=null){
			req.getSession().setAttribute("user", userVO);
		}
		
		return mapping.findForward(Constants.FORWARD_SUCCESS);
	}
	
}