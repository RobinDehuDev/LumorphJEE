package com.ludomorph.beans.web;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class FileMusicVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	
	private FormFile myFileMusic;

    public void setMyFileMusic(FormFile myFileMusic) {
        this.myFileMusic = myFileMusic;
    }

    public FormFile getMyFileMusic() {
        return myFileMusic;
    }
    
    
}