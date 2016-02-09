package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.EditSizeVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.business.EditSizeService;
import com.ludomorph.business.IEditSizeService;

public class EditSizeAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		EditSizeVO size = (EditSizeVO) form;

		LevelVO level = (LevelVO) req.getSession().getAttribute(Constants.EDIT_LEVEL_DATA);

		IEditSizeService editService = EditSizeService.getInstance();

		editService.update(size, level);

		req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, level);

		return mapping.findForward("success");
	}

}
