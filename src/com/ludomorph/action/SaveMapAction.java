package com.ludomorph.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.LevelSaveVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.beans.web.TypeVO;
import com.ludomorph.business.ISaveLevelService;
import com.ludomorph.business.SaveLevelService;

public class SaveMapAction extends Action{

	public SaveMapAction() {
		// TODO Auto-generated constructor stub
	}
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		LevelSaveVO level = (LevelSaveVO) form;
		
		LevelVO oldLevel = (LevelVO) req.getSession().getAttribute(Constants.EDIT_LEVEL_DATA);
		if(oldLevel == null){
			oldLevel = new LevelVO();
			oldLevel.generateTest001();
			
			req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, oldLevel);
		}
		
		List<TypeVO> types = new ArrayList<TypeVO>();
		types.add(new TypeVO('A',"vide"));
		types.add(new TypeVO('B',"départ"));
		types.add(new TypeVO('C',"arrivée"));
		types.add(new TypeVO('D',"plateform"));
		types.add(new TypeVO('E',"mechant"));
		types.add(new TypeVO('F',"piege"));
		
		req.getSession().setAttribute(Constants.EDIT_LEVEL_OBJECT, types);
		
		if(level.isToSave()){
			ISaveLevelService service = SaveLevelService.getInstance();
			service.save(level, "robin", oldLevel);
			req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, oldLevel);
		}
		
		
		
		return mapping.findForward(Constants.FORWARD_SUCCESS);
	}

}
