package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class CharacterVO extends ActionForm {

	private FormFile idle;
	private FormFile move1;
	private FormFile move2;
	private FormFile jump;

	/**
	 * @return the idle
	 */
	public FormFile getIdle() {
		return idle;
	}

	/**
	 * @param idle
	 *            the idle to set
	 */
	public void setIdle(FormFile idle) {
		this.idle = idle;
	}

	/**
	 * @return the move1
	 */
	public FormFile getMove1() {
		return move1;
	}

	/**
	 * @param move1
	 *            the move1 to set
	 */
	public void setMove1(FormFile move1) {
		this.move1 = move1;
	}

	/**
	 * @return the move2
	 */
	public FormFile getMove2() {
		return move2;
	}

	/**
	 * @param move2
	 *            the move2 to set
	 */
	public void setMove2(FormFile move2) {
		this.move2 = move2;
	}

	/**
	 * @return the jump
	 */
	public FormFile getJump() {
		return jump;
	}

	/**
	 * @param jump
	 *            the jump to set
	 */
	public void setJump(FormFile jump) {
		this.jump = jump;
	}

	public CharacterVO() {
		super();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		try {

			int height_idle = 0;
			int width_idle = 0;
			int height_move1 = 0;
			int width_move1 = 0;
			int height_move2 = 0;
			int width_move2 = 0;
			int height_jump = 0;
			int width_jump = 0;

			java.awt.Image image_idle = javax.imageio.ImageIO.read(idle.getInputStream());
			java.awt.Image image_move1 = javax.imageio.ImageIO.read(move1.getInputStream());
			java.awt.Image image_move2 = javax.imageio.ImageIO.read(move2.getInputStream());
			java.awt.Image image_jump = javax.imageio.ImageIO.read(jump.getInputStream());

			ImageIcon obs_idle = new ImageIcon(image_idle);
			ImageIcon obs_move1 = new ImageIcon(image_move1);
			ImageIcon obs_move2 = new ImageIcon(image_move2);
			ImageIcon obs_jump = new ImageIcon(image_jump);
			// Then get image dimensions
			height_idle = obs_idle.getIconHeight();
			width_idle = obs_idle.getIconWidth();
			height_move1 = obs_move1.getIconHeight();
			width_move1 = obs_move1.getIconWidth();
			height_move2 = obs_move2.getIconHeight();
			width_move2 = obs_move2.getIconWidth();
			height_jump = obs_jump.getIconHeight();
			width_jump = obs_jump.getIconWidth();

			if (height_idle != 150 || width_idle != 150 || height_move1 != 150 || width_move1 != 150
					|| height_move2 != 150 || width_move2 != 150 || height_jump != 150 || width_jump != 150)
				errors.add("dimension_not_right", new ActionMessage("errors.dimension", "dimension"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return errors;
	}

}
