package com.ludomorph.beans.web;

public class TypeVO {
	private char value;
	private String name;

	public TypeVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param id
	 * @param name
	 */
	public TypeVO(char value, String name) {
		super();
		this.value = value;
		this.name = name;
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
	
	

}
