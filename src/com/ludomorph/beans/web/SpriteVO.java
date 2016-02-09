package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class SpriteVO extends ActionForm{
	
	private FormFile file;
	
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	
	public SpriteVO(){
		super();
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
	   HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		int height=0;
		int width=0;
	
		try{
		java.awt.Image image = javax.imageio.ImageIO.read( file.getInputStream() );
		  ImageIcon obs = new ImageIcon(image);
		// Then get image dimensions
		height = obs.getIconHeight();
		width = obs.getIconWidth();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(width!=150 || height!=150)
		errors.add("dimension_not_right", new ActionMessage("errors.dimension", "dimension"));
		
		return errors;	
	}

}
