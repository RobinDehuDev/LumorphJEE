package com.ludomorph.business;

import com.ludomorph.beans.web.BackgroundVO;
import com.ludomorph.beans.web.CharacterVO;
import com.ludomorph.beans.web.SpriteVO;

public interface ISpriteService {
	
	String getTrap(int id);
	void uploadTrap(int id,SpriteVO sprite, String path);
	void uploadEnnemy(int id,SpriteVO sprite, String path);
	void uploadCharacter(int id,CharacterVO sprite, String path);
	void uploadBackground(int id, BackgroundVO sprite, String path);
	
}
