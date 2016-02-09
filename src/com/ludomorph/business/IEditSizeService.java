package com.ludomorph.business;

import com.ludomorph.beans.web.EditSizeVO;
import com.ludomorph.beans.web.LevelVO;

public interface IEditSizeService {
	
	void update(EditSizeVO size, LevelVO level);

}
