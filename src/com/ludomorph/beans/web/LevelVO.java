package com.ludomorph.beans.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class LevelVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private List<LevelLineVO> level;
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
	public LevelVO(List<LevelLineVO> level, String name, int width) {
		super();
		this.level = level;
		this.name = name;
		this.width = width;
	}
	
	public LevelVO(String name) {
		super();
		this.name = name;
	}



	/**
	 *  generate first Map Test
	 */
	public void generateTest001(){
		name = "DevTest001";
		width = 10;
		level = new ArrayList<LevelLineVO>();
		List<Integer> line = new ArrayList<Integer>();
		for(int j = 0 ; j < 10 ; j++){
			line.add(0);
		}
		for(int i = 0 ; i < 5 ; i++){
			level.add(new LevelLineVO(line));
		}
	}

	/**
	 * @return the level
	 */
	public List<LevelLineVO> getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(List<LevelLineVO> level) {
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
	
	public String toString(){
		String r = "";
		for(LevelLineVO l : level){
			for(Integer i : l){
				r+=i;
			}
			r+="\n";
		}
		return r;
	}
	
	

}
