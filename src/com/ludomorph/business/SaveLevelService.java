package com.ludomorph.business;

import java.util.List;

import com.ludomorph.beans.data.LevelDO;
import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.LevelLineVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class SaveLevelService implements ISaveLevelService{

	public SaveLevelService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(LevelVO level, String user) {
		LevelDO leveldo = toDO(level, user);
		ILudoMorphDAO dao = LudoMorphDAO.getInstance();
		
		dao.<LevelDO>save(leveldo);
		
	}
	
	private LevelDO toDO(LevelVO level, String user){
		String map = level.getWidth()+".";
		map += simplifyLevel(level.getLevel());
		UserDO userDO = new UserDO();
		userDO.setName(user);
		LevelDO leveldo = new LevelDO(level.getName(), map, userDO);
		
		return leveldo;
		
	}
	
	private String simplifyLevel(List<LevelLineVO> list){
		String map = "";
		int counter = 0, A = (int)'A';
		char currentChar =(char)(A+list.get(0).get(0)), selected;
		
		for(LevelLineVO line : list){
			for(int i : line){
				selected = (char)(A+i);
				if(selected == currentChar){
					counter++;
				} else {
					map+=counter+=currentChar;
					currentChar= selected;
					counter = 1;
				}
				
				
			}
		}
		
		map+=counter+=currentChar;
		
		
		
		return map;
	}


}
