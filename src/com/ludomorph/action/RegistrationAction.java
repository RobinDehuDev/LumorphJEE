package com.ludomorph.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.ludomorph.beans.web.BackgroundVO;
import com.ludomorph.beans.web.CharacterVO;
import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.FileMusicVO;
import com.ludomorph.beans.web.SpriteVO;
import com.ludomorph.beans.web.UploadFile;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.business.IMusicService;
import com.ludomorph.business.ISpriteService;
import com.ludomorph.business.IUserService;
import com.ludomorph.business.MusicService;
import com.ludomorph.business.SpriteService;
import com.ludomorph.business.UserService;

public class RegistrationAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		String messageResult;

		UserVO registration = (UserVO) form;
		
		IUserService registrationService = UserService.getInstance();
		IMusicService musicService = MusicService.getInstance();
		ISpriteService spriteService = SpriteService.getInstance();
		
		if (registrationService.exist(registration.getName())==false) {
			registrationService.register(registration);
			
			//init de la musique pour une nouvelle inscription
			FileMusicVO fileMusicVO = new FileMusicVO();
			fileMusicVO.setMyFileMusic(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/musics/Default_music.mp3")));
			musicService.addMusic(registrationService.getUser(registration.getName()).getId(),fileMusicVO,req.getSession().getServletContext().getRealPath("/"));	
			
			//init du background pour une nouvelle inscription
			BackgroundVO spriteVO_background = new BackgroundVO();
			spriteVO_background.setFile(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/background.png")));
			spriteService.uploadBackground(registrationService.getUser(registration.getName()).getId(),spriteVO_background,req.getSession().getServletContext().getRealPath("/"));	
			
			//init du piege pour une nouvelle inscription
			SpriteVO spriteVO_trap = new SpriteVO();
			spriteVO_trap.setFile(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/trap.png")));
			spriteService.uploadTrap(registrationService.getUser(registration.getName()).getId(),spriteVO_trap,req.getSession().getServletContext().getRealPath("/"));	
			
			//init de l'ennemi pour une nouvelle inscription
			SpriteVO spriteVO_enemy = new SpriteVO();
			spriteVO_enemy.setFile(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/enemy.png")));
			spriteService.uploadEnnemy(registrationService.getUser(registration.getName()).getId(),spriteVO_enemy,req.getSession().getServletContext().getRealPath("/"));	
			
			//init du hero pour une nouvelle inscription
			CharacterVO spriteVO_character = new CharacterVO();
			spriteVO_character.setIdle(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/idle.png")));
			spriteVO_character.setJump(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/jump.png")));
			spriteVO_character.setMove1(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/move1.png")));
			spriteVO_character.setMove2(new UploadFile(new File(req.getSession().getServletContext().getRealPath("/")+"ressources/sprite/move2.png")));
			spriteService.uploadCharacter(registrationService.getUser(registration.getName()).getId(),spriteVO_character,req.getSession().getServletContext().getRealPath("/"));	
			
			
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