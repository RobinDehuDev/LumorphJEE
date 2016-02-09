package com.ludomorph.business;

import java.util.ArrayList;
import java.util.List;

import com.ludomorph.beans.web.EditSizeVO;
import com.ludomorph.beans.web.LevelVO;

public class EditSizeService implements IEditSizeService {
	
	private char vide = 'A'; 

	private static EditSizeService instance = null;
	
	

	private EditSizeService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return instance of LudomMorphDAO
	 */

	public static EditSizeService getInstance() {

		if (instance == null) {
			instance = new EditSizeService();
		}

		return instance;
	}
	@Override
	public void update(EditSizeVO size, LevelVO level) {
		
		List<List<Character>> newMap = new ArrayList<List<Character>>();
		List<List<Character>> oldMap = level.getLevel();
		List<Character> line = new ArrayList<Character>();
		
		for(int i = 0 ; i < oldMap.size() && i < size.getHeight(); i++){
			for(int j = 0 ; j < level.getWidth() && j < size.getWidth() ; j++){
				line.add(oldMap.get(i).get(j));
			}
			for(int j = level.getWidth() ; j < size.getWidth(); j++){
				line.add(vide);
			}
			newMap.add(new ArrayList<Character>(line));
			line.clear();
		}
		line = getLine(size.getWidth());
		for(int i = level.getHeight() ; i < size.getHeight(); i++){
			newMap.add(line);
		}
		
		
		
		
		
		level.setHeight(size.getHeight());
		level.setWidth(size.getWidth());
		level.setLevel(newMap);
		
		
	}
	
	private List<Character> getLine(int size){
		List<Character> list = new ArrayList<Character>();
		
		for(int i = 0 ; i < size ; i++){
			list.add(vide);
		}
		return list;
	}

}
