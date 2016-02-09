package com.ludomorph.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.business.ILoadLevelService;
import com.ludomorph.business.LoadLevelService;

public class LoadMapAction extends Action {

	@SuppressWarnings("unchecked")
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		LevelVO level = (LevelVO) form;

		ILoadLevelService loadService = LoadLevelService.getInstance();

		loadService.update(level, (List<LevelVO>) req.getSession().getAttribute(Constants.EDIT_LEVEL_LIST));

		req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, level);
		
		System.out.println("loded height : "+ level.getHeight());

		return mapping.findForward("success");
	}

}
