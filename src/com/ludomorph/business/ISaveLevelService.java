package com.ludomorph.business;


import com.ludomorph.beans.web.LevelVO;

public interface ISaveLevelService {
	
	void save(LevelVO level, String user);

}
