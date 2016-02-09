package com.ludomorph.beans.web;

import org.apache.struts.action.ActionForm;

public class EditSizeVO extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;

	public EditSizeVO() {
		// TODO Auto-generated constructor stub
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
	
	
}
