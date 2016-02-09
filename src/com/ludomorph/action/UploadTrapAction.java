package com.ludomorph.action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.ludomorph.beans.web.SpriteVO;
import com.ludomorph.business.ISpriteService;
import com.ludomorph.business.SpriteService;

public class UploadTrapAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {

		SpriteVO uploadForm = (SpriteVO) form;
		ISpriteService service = SpriteService.getInstance();

		String filePath = req.getSession().getServletContext().getRealPath("/");
		int id_user = (int) req.getSession().getAttribute("user_id");

		service.uploadTrap(id_user, uploadForm, filePath);

		return mapping.findForward("success");

	}

}
