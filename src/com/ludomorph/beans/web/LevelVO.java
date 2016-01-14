package com.ludomorph.beans.web;

import java.util.ArrayList;
import java.util.List;

public class LevelVO {
	private List<List<Character>> level;
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
	public LevelVO(List<List<Character>> level, String name, int width) {
		super();
		this.level = level;
		this.name = name;
		this.width = width;
	}



	/**
	 *  generate first Map Test
	 */
	public void generateTest001(){
		name = "DevTest001";
		width = 10;
		level = new ArrayList<List<Character>>();
		List<Character> line = new ArrayList<Character>();
		for(int i = 0 ; i < 5 ; i++){			
			for(int j = 0 ; j < 10 ; j++){
				line.add('0');
			}
			
			level.add(new ArrayList<Character>(line));
			line.clear();
		}
	}

	/**
	 * @return the level
	 */
	public List<List<Character>> getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(List<List<Character>> level) {
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
