package com.ludomorph.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.beans.web.TypeVO;



public class LoadMapAction extends Action{

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		LevelVO map = new LevelVO();
		
		map.generateTest001();
		
		req.getSession().setAttribute(SessionConstantNames.EDITLEVELMAP, map);
		
		List<TypeVO> types = new ArrayList<TypeVO>();
		types.add(new TypeVO(0,"vide"));
		types.add(new TypeVO(1,"plateform"));
		types.add(new TypeVO(2,"départ"));
		types.add(new TypeVO(3,"arrivée"));
		types.add(new TypeVO(4,"mechant"));
		types.add(new TypeVO(5,"piege"));
		
		req.getSession().setAttribute(SessionConstantNames.EDITLEVELOBJECTDATA, types);
		
		


		

		return mapping.findForward("success");
	}
	
	
	
	
	

}
