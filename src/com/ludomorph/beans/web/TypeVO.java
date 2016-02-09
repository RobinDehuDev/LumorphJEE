package com.ludomorph.beans.web;

public class TypeVO {
	private char value;
	private String name;
	private String cssClass;

	public TypeVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param id
	 * @param name
	 */
	public TypeVO(char value, String name, String cssClass) {
		super();
		this.value = value;
		this.name = name;
		this.cssClass = cssClass;
	}



	/**
	 * @return the id
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param id the id to set
	 */
	public void setValue(char value) {
		this.value = value;
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
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}



	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	

}
