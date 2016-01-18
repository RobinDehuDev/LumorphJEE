package com.ludomorph.dao;

import com.ludomorph.beans.data.LevelDO;
import com.ludomorph.beans.data.MusicDO;
import com.ludomorph.beans.data.SpriteDO;
import com.ludomorph.beans.data.TypeDO;
import com.ludomorph.beans.data.UserDO;

public class testDAO {

	public testDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ILudoMorphDAO dao = LudoMorphDAO.getInstance();
		UserDO user = new UserDO("Robin","DEHU","email@email.com");
		TypeDO type = new TypeDO("player");
		SpriteDO sprite = new SpriteDO(type, "un chemin", user);
		MusicDO music = new MusicDO("ma musique", "chemin", user);
		LevelDO level = new LevelDO("test01", "000", user);
		
	
		dao.<SpriteDO>save(sprite);
		//dao.<MusicDO>save(music);
		//dao.<LevelDO>save(level);
		

	}

}
