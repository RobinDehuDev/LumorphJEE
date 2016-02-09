package com.ludomorph.beans.web;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LevelSaveVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String data;
	private String name;
	private int height;
	private int width;
	private int id;

	public LevelSaveVO() {
		super();
		data = "BC";
		name ="name";
		width = 1;
	}
	
	
	
	/**
	 * @param level
	 * @param name
	 * @param width
	 */
	public LevelSaveVO(String data, String name, int width) {
		super();
		this.data = data;
		this.name = name;
		this.width = width;
	}



	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}



	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}



	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}



	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}	
	
	



	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();
		if (StringUtils.isEmpty(this.getName())) {
			errors.add("", new ActionMessage("errors.mandatory", "Nom du Niveau"));
		}
		if (this.getWidth() <= 0){
			errors.add("", new ActionMessage("errors.mandatory", "Largeur"));
		}
		if(!StringUtils.contains(this.getData(), 'B')){
			errors.add("", new ActionMessage("errors.mandatory", "départ"));
		}
		if(!StringUtils.contains(this.getData(), 'C')){
			errors.add("", new ActionMessage("errors.mandatory", "départ"));
		}
		return errors;
	}

}

