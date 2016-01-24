package com.ludomorph.business;


import com.ludomorph.beans.web.LevelSaveVO;
import com.ludomorph.beans.web.LevelVO;

public interface ISaveLevelService {
	
	void save(LevelSaveVO level, String user, LevelVO oldLevel);

}
