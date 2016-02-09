package com.ludomorph.business;

import java.util.ArrayList;
import java.util.List;

import com.ludomorph.beans.data.LevelDO;
import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.LevelSaveVO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class SaveLevelService implements ISaveLevelService {

	private static SaveLevelService instance = null;
	
	private static String tableUser = "UserDO";
	private static String tableLevel = "LevelDO";

	private SaveLevelService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return instance of LudomMorphDAO
	 */

	public static SaveLevelService getInstance() {

		if (instance == null) {
			instance = new SaveLevelService();
		}

		return instance;
	}

	@Override
	public void save(LevelSaveVO level, String user, LevelVO oldLevel) {
		
		boolean same = refresh(level, oldLevel);
		ILudoMorphDAO dao = LudoMorphDAO.getInstance();
		LevelDO leveldo;
		leveldo = toDO(level, user, same);
		if(same){
			dao.<LevelDO> update(leveldo);
		}else{
			dao.<LevelDO> save(leveldo);
		}
		

	}

	private LevelDO toDO(LevelSaveVO level, String user, boolean same) {
		String simple = level.getWidth()+"@"+simplify(level.getData());
		
		ILudoMorphDAO dao = LudoMorphDAO.getInstance();
		
		List<String> columns = new ArrayList<String>();
		columns.add("name");
		List<Object> args = new ArrayList<Object>();
		args.add(user);
		UserDO userdo = (UserDO) (dao.<UserDO>get(tableUser, columns, args)).get(0);
		
		LevelDO leveldo = new LevelDO(level.getName(), simple, userdo);
		
		if(same){
			leveldo.setId(level.getId());
		}

		return leveldo;

	}
	
	
	private String simplify(String complex) {
		String simple = "";
		int cpt = 1;
		char c = complex.charAt(0);
		for (int i = 1; i < complex.length(); i++) {
			if (complex.charAt(i) == c) {
				cpt++;
			} else {
				simple += cpt + "" + c;
				c = complex.charAt(i);
				cpt = 1;
			}
		}
		simple += cpt + "" + c;
		return simple;
	}
	
	private boolean refresh(LevelSaveVO level, LevelVO oldLevel){
		boolean same = level.getName().equals(oldLevel.getName());
		
		if(!same)
			oldLevel.setName(level.getName()); 
		
		List<List<Character>> map = new ArrayList<List<Character>>();
		int height = level.getData().length()/level.getWidth();
		List<Character> line = new ArrayList<Character>();
		
		for(int i = 0; i < height ; i++){
			for(int j = 0 ; j < level.getWidth() ; j++){
				line.add(level.getData().charAt(i*level.getWidth()+j));
			}
			map.add(new ArrayList<Character>(line));
			line.clear();
				
		}
		
		oldLevel.setLevel(map);
		
		return same;
	}

}
