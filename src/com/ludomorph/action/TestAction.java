package com.ludomorph.action;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.LevelLineVO;
import com.ludomorph.beans.web.LevelVO;




public class TestAction extends Action{

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		
		LevelVO level = new LevelVO();
		level.generateTest001();
		
		req.getSession().setAttribute("testList", level);
		
		
		


		

		return mapping.findForward("success");
	}
	
	
	
	
	

}
