package com.ludomorph.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.FileMusicVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.beans.web.TypeVO;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.ILoadLevelService;
import com.ludomorph.business.IMusicService;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.LoadLevelService;
import com.ludomorph.business.MusicService;
import com.ludomorph.business.UserService;



public class ConnectionAction  extends Action{
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		ConnectionVO connection = (ConnectionVO) form;
		IUserService userService = UserService.getInstance();
		IMusicService musicService = MusicService.getInstance();
		UserVO userVO = userService.connection(connection);
		
		if(userVO!=null){
			req.getSession().setAttribute("user_id", userVO.getId());
			req.getSession().setAttribute("user_name", userVO.getName());
			if(!musicService.getNamesMusics(userVO.getId()).isEmpty())
				req.getSession().setAttribute("musics", musicService.getNamesMusics(userVO.getId()));
			else
				req.getSession().setAttribute("musics",null);
			
			List<TypeVO> types = new ArrayList<TypeVO>();
			types.add(new TypeVO('A', "vide", "editCellA"));
			types.add(new TypeVO('B', "départ", "editCellB"));
			types.add(new TypeVO('C', "arrivée", "editCellC"));
			types.add(new TypeVO('D', "plateform", "editCellD"));
			types.add(new TypeVO('E', "mechant", "editCellE"));
			types.add(new TypeVO('F', "piege", "editCellF"));

			req.getSession().setAttribute(Constants.EDIT_LEVEL_OBJECT, types);

			LevelVO level = new LevelVO();
			level.generateTest001();

			req.getSession().setAttribute(Constants.EDIT_LEVEL_DATA, level);

			ILoadLevelService levelService = LoadLevelService.getInstance();

			List<LevelVO> userList = levelService.getLevels(userVO.getId());

			req.getSession().setAttribute(Constants.EDIT_LEVEL_LIST, userList);
		}
		
		return mapping.findForward(Constants.FORWARD_SUCCESS);
	}
	
}