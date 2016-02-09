package com.ludomorph.beans.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class BackgroundVO extends ActionForm{
	
	private FormFile file;
	private String path;
	
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setPath(String path){
		this.path=path;
	}

	
	public BackgroundVO(){
		super();
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
	   HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		
		return errors;
		
		
		
	}

}
