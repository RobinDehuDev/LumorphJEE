package com.ludomorph.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.LevelSaveVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.business.ILoadLevelService;
import com.ludomorph.business.ISaveLevelService;
import com.ludomorph.business.LoadLevelService;
import com.ludomorph.business.SaveLevelService;

public class SaveMapAction extends Action{

	public SaveMapAction() {
		// TODO Auto-generated constructor stub
	}
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		LevelSaveVO level = (LevelSaveVO) form;
		
		LevelVO oldLevel = (LevelVO) req.getSession().getAttribute(Constants.EDIT_LEVEL_DATA);
		
		
		
		ISaveLevelService service = SaveLevelService.getInstance();
		String user = (String) req.getSession().getAttribute("user_name");
		int userID = (int) req.getSession().getAttribute("user_id");
		service.save(level, user, oldLevel);
		req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, oldLevel);
		
		ILoadLevelService levelService = LoadLevelService.getInstance();

		List<LevelVO> userList = levelService.getLevels(userID);

		req.getSession().setAttribute(Constants.EDIT_LEVEL_LIST, userList);
		
		
		
		
		return mapping.findForward(Constants.FORWARD_SUCCESS);
	}

}
