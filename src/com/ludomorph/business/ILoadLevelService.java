package com.ludomorph.business;

import java.util.List;

import com.ludomorph.beans.web.LevelVO;

public interface ILoadLevelService {
	
	List<LevelVO>getLevels(int id);
	
	void update(LevelVO level, List<LevelVO> list);

}
