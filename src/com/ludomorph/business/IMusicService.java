package com.ludomorph.business;

import java.util.List;

import com.ludomorph.beans.web.FileMusicVO;

public interface IMusicService {

	List<String> getNamesMusics(int user_id);
	boolean exist(String name);
	void removeMusic(int user_id, String music_name, String realpath);
	void addMusic(int user_id, FileMusicVO fileMusicVO);
}
