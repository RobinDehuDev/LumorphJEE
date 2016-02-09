package com.ludomorph.business;

import java.util.List;

import com.ludomorph.beans.web.FileMusicVO;

public interface IMusicService {

	List<String> getNamesMusics(int user_id);
	boolean exist(int user_id,String name);
	void removeMusic(int user_id, String music_name, String pathContext);
	void addMusic(int user_id, FileMusicVO fileMusicVO,String pathContext);
}
