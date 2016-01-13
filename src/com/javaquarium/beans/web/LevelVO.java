package com.javaquarium.beans.web;

public class LevelVO {
	private String level;
	private String name;
	private int width;

	public LevelVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param level
	 * @param name
	 * @param width
	 */
	public LevelVO(String level, String name, int width) {
		super();
		this.level = level;
		this.name = name;
		this.width = width;
	}



	/**
	 *  generate first Map Test
	 */
	public void generateTest001(){
		level = "DevTest001";
		width = 240;
		level = "";
		for(int i = 0 ; i < 135 ; i++){
			for(int j = 0 ; j < 240 ; j++)
				level += '0';
		}
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
