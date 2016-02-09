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
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.IMusicService;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.MusicService;
import com.ludomorph.business.UserService;

public class RemoveMusicAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		IMusicService musicService = MusicService.getInstance();
		
		int user_id = (int) req.getSession().getAttribute("user_id");
		int index = Integer.parseInt(req.getParameter("index").toString()); 
		
		String music_name = ((List<String>) req.getSession().getAttribute("musics")).get(index);
		System.out.println("Remove action done");
		musicService.removeMusic(user_id, music_name, req.getSession().getServletContext().getRealPath("/"));
		req.getSession().setAttribute("musics", musicService.getNamesMusics(user_id));
		
		return mapping.findForward("success");

	}
}