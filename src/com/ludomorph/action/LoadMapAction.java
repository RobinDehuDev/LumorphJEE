package com.ludomorph.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.LevelVO;



public class LoadMapAction extends Action{

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		LevelVO map = new LevelVO();
		map.generateTest001();
		
		req.getSession().setAttribute(SessionConstantNames.EDITLEVELMAPDATA, map.getLevel());
		req.getSession().setAttribute(SessionConstantNames.EDITLEVELMAPNAME, map.getName());
		req.getSession().setAttribute(SessionConstantNames.EDITLEVELMAPWIDTH, map.getWidth());
		
		System.out.println(count(map.getLevel()));
		


		

		return mapping.findForward("success");
	}
	
	
	//test
	private int count(List<List<Character>> test){
		int r =0;
		for(int i = 0 ; i < test.size() ; i++){
			r+= test.get(i).size();
		}
		
		return r;
	}

}
