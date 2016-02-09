package com.ludomorph.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.FileMusicVO;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.IMusicService;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.MusicService;
import com.ludomorph.business.UserService;

public class AddMusicAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		FileMusicVO fileMusicVO = (FileMusicVO)form;
		
		IMusicService musicService = MusicService.getInstance();
		int user_id = (int) req.getSession().getAttribute("user_id");
		String messageResult="success";
		
		if (musicService.exist(user_id,fileMusicVO.getMyFileMusic().getFileName())==false) {
			musicService.addMusic(user_id,fileMusicVO,req.getSession().getServletContext().getRealPath("/"));	
			req.getSession().setAttribute("musics", musicService.getNamesMusics(user_id));
		} else {
			final ActionErrors errors = new ActionErrors();
			errors.add("mon", new ActionMessage("errors.exist"));
			saveErrors(req, errors);
		}

		return mapping.findForward(messageResult);
	}
}