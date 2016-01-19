package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MenuAction extends Action{
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		if(req.getParameter("page")!=null)
			req.getSession().setAttribute("page",req.getParameter("page").toString());
		
		if(req.getSession().getAttribute("page").toString().equals("6"))
			return mapping.findForward("loadLevel");
		
		return mapping.findForward(SessionConstantNames.FORWARD_SUCCESS);
	}

}
