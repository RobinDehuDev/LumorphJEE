package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
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
    
    @Override
	public ActionErrors validate(ActionMapping mapping,
	   HttpServletRequest request) {
		
	    final ActionErrors errors = new ActionErrors();
	    
	    //must take a file
	    if( getMyFileMusic().getFileSize()== 0){
	       errors.add("",
	    	new ActionMessage("file.music.err.file.required"));
	    }

	    //only allow mp3 to upload
	    if(!"audio/mp3".equals(getMyFileMusic().getContentType())){
	        errors.add("",
	    	 new ActionMessage("file.music.err.only"));
	    }
	    
        //file size cant larger than 10Mo
	    System.out.println(getMyFileMusic().getFileSize());
	    if(getMyFileMusic().getFileSize() > 83886080){ //10Mo
	       errors.add("", new ActionMessage("file.music.err.size.limit", 83886080));
	    }
	    
		return errors;

	}
    
}