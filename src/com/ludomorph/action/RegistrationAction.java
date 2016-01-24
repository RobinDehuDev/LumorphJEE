package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.UserService;

public class RegistrationAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		String messageResult;

		UserVO registration = (UserVO) form;
		
		IUserService registrationService = UserService.getInstance();
		
		
		if (registrationService.exist(registration.getName())==false) {
			registrationService.register(registration);
			messageResult = "registrationDone";
		} else {
			final ActionErrors errors = new ActionErrors();
			errors.add("mon", new ActionMessage("errors.exist"));
			saveErrors(req, errors);
			messageResult = "registrationFail";
		}
		return mapping.findForward(messageResult);

	}
}