package com.ludomorph.business;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.ludomorph.beans.data.MusicDO;
import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.FileMusicVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class MusicService implements IMusicService {

	private static MusicService instance = null;

	private List<String> columns = new ArrayList<String>();
	private List<Object> args = new ArrayList<Object>();
	private String table = "MusicDO";
	private ILudoMorphDAO dao = LudoMorphDAO.getInstance();

	private MusicService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static MusicService getInstance() {

		if (instance == null) {
			instance = new MusicService();
		}

		return instance;
	}

	private void clearColumnsArgs() {
		columns.clear();
		args.clear();
	}

	@Override
	public List<String> getNamesMusics(int user_id) {
		UserDO userDO = UserService.getInstance().getUser(user_id);
		clearColumnsArgs();
		List<String> list_result = new ArrayList<String>();

		columns.add("user_id");
		args.add(userDO);

		List<?> list = dao.get(table, columns, args);

		if (!list.isEmpty()) {
			for (Object music : list)
				list_result.add(((MusicDO) music).getName());
		}

		return list_result;
	}

	@Override
	public boolean exist(int user_id,String name) {

		boolean res = true;

		clearColumnsArgs();
		
		UserDO userDO = UserService.getInstance().getUser(user_id);
		columns.add("user_id");
		args.add(userDO);
		
		columns.add("name");
		args.add(name);

		List<?> list = dao.get(table, columns, args);
		// System.out.println("Test liste : "+list.toString());

		if (list.isEmpty())
			res = false;
		else
			res = true;
		System.out.println(res);
		return res;
	}

	@Override
	public void removeMusic(int user_id, String music_name, String pathContext) {
		UserDO userDO = UserService.getInstance().getUser(user_id);
		clearColumnsArgs();

		MusicDO musicDO = null;

		columns.add("user_id");
		args.add(userDO);

		columns.add("name");
		args.add(music_name);

		List<?> list = dao.get(table, columns, args);
		

		if (!list.isEmpty()) {
			musicDO = ((MusicDO) list.get(0));

			try {
				Files.delete(Paths.get(pathContext+"/ressources/musics/" + user_id + "/"+ music_name));
				dao.delete(musicDO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void addMusic(int user_id, FileMusicVO fileMusicVO,String pathContext) {
		// TODO Auto-generated method stub
		UserDO userDO = UserService.getInstance().getUser(user_id);
		clearColumnsArgs();

		MusicDO musicDO = new MusicDO(fileMusicVO.getMyFileMusic().getFileName(), "", userDO);

		FormFile fileInput = fileMusicVO.getMyFileMusic();
		File folder = new File(pathContext+"/ressources/musics/" + user_id +"/");
		    if(!folder.exists()){
		    	folder.mkdirs();
		    }
		File file = new File(pathContext+"/ressources/musics/" + user_id + "/"+fileInput.getFileName());
		FileOutputStream os = null;
		InputStream is = null;

		int count;
		byte buf[];
		
		try {
			os = new FileOutputStream(file);
			is = new BufferedInputStream(fileInput.getInputStream());
			buf = fileInput.getFileData();
			while ((count = is.read(buf)) > -1) {
				os.write(buf, 0, count);
			}
			is.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dao.save(musicDO);
	}

}
