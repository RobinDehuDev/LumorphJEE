package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SaveMapAction {

	public SaveMapAction() {
		// TODO Auto-generated constructor stub
	}
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		
		
		return mapping.findForward(SessionConstantNames.FORWARD_SUCCESS);
	}

}
