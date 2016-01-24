package com.ludomorph.beans.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class LevelVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private List<List<Character>> level;
	private String name;
	private int width;
	private int id;

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

	public LevelVO(String name) {
		super();
		this.name = name;
	}

	/**
	 * generate first Map Test
	 */
	public void generateTest001() {
		name = "DevTest001";
		width = 5;
		level = new ArrayList<List<Character>>();
		List<Character> line = new ArrayList<Character>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < width; j++) {
				line.add('A');
			}
			level.add(new ArrayList<Character>(line));
			line.clear();
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the level
	 */
	public List<List<Character>> getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
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
	 * @param name
	 *            the name to set
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
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		int length = 0;
		if (level.size() > 0 && width > 0)
			length = level.size() / width;
		return length;
	}

	public String toString() {
		String r = ""+width;
		for (List<Character> l : level) {
			for (Character c : l) {
				r += c;
			}
		}

		return r;
	}

}
