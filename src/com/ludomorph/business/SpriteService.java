package com.ludomorph.business;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;















import org.apache.struts.upload.FormFile;

import com.ludomorph.beans.data.SpriteDO;
import com.ludomorph.beans.data.TypeDO;
import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.BackgroundVO;
import com.ludomorph.beans.web.CharacterVO;
import com.ludomorph.beans.web.SpriteVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class SpriteService implements ISpriteService{
	
	private List<String> columns = new ArrayList<String>();
	private List<Object> args = new ArrayList<Object>();
	private String table = "SpriteDO";
	private ILudoMorphDAO dao = LudoMorphDAO.getInstance();
	
	private static SpriteService instance = null;
	
	public static SpriteService getInstance() {
		
		if (instance == null) {
			instance = new SpriteService();
		}
	
		return instance;
	}
	
	private SpriteService(){
		super();
	}
	
	@Override
	public String getTrap(int id) {
		
		clearColumnsArgs();
		UserDO userDO = UserService.getInstance().getUser(id);
		
		String result = new String();
		
		columns.add("user_id");
		args.add(userDO);
		
		List<?> list = dao.get(table, columns, args);
		
		if(!list.isEmpty())
	
				result=((SpriteDO)list.get(0)).getPath();

		return result;
	}
	
	private void clearColumnsArgs()
	{
		columns.clear();
		args.clear();
	}

	@Override
	public void uploadTrap(int id, SpriteVO sprite,String path) {
		// TODO Auto-generated method stub
		
		
		clearColumnsArgs();

		FormFile fileInput = sprite.getFile();
		
		File folder = new File(path+"/ressources/sprite/" + id +"/trap/");
		    if(!folder.exists()){
		    	folder.mkdirs();
		    }
		File file = new File(path+"/ressources/sprite/" + id + "/trap/"+"trap.png");
		FileOutputStream os = null;
		InputStream is = null;

		int count;
		byte buf[] = new byte[4096];
		
		try {
			os = new FileOutputStream(file);
			is = new BufferedInputStream(fileInput.getInputStream());
			
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

	}

	@Override
	public void uploadEnnemy(int id, SpriteVO sprite,String path) {
		// TODO Auto-generated method stub
		
		
		clearColumnsArgs();

		FormFile fileInput = sprite.getFile();
		
		File folder = new File(path+"/ressources/sprite/" + id +"/ennemy");
		    if(!folder.exists()){
		    	folder.mkdirs();
		    }
		File file = new File(path+"/ressources/sprite/" + id + "/ennemy/"+"ennemy.png");
		FileOutputStream os = null;
		InputStream is = null;

		int count;
		byte buf[] = new byte[4096];
		
		try {
			os = new FileOutputStream(file);
			is = new BufferedInputStream(fileInput.getInputStream());
			
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

		
	}

	@Override
	public void uploadCharacter(int id, CharacterVO sprite, String path) {
		
	
	
			clearColumnsArgs();

			FormFile fileInput_idle = sprite.getIdle();
			FormFile fileInput_move1 = sprite.getMove1();
			FormFile fileInput_move2 = sprite.getMove2();
			FormFile fileInput_jump = sprite.getJump();
			
			File folder = new File(path+"/ressources/sprite/" + id +"/character");
			    if(!folder.exists()){
			    	folder.mkdirs();
			    }
			    
			File file_idle = new File(path+"/ressources/sprite/" + id + "/character/"+"Idle.png");
			File file_move1 = new File(path+"/ressources/sprite/" + id + "/character/"+"Move1.png");
			File file_move2 = new File(path+"/ressources/sprite/" + id + "/character/"+"Move2.png");
			File file_jump = new File(path+"/ressources/sprite/" + id + "/character/"+"Jump.png");
			
			
			FileOutputStream os = null;
			InputStream is = null;

			int count;
			byte buf[] = new byte[4096];
			
			try {
				os = new FileOutputStream(file_idle);
				is = new BufferedInputStream(fileInput_idle.getInputStream());
				
				while ((count = is.read(buf)) > -1) {
					os.write(buf, 0, count);
				}
				
				os = new FileOutputStream(file_move1);
				is = new BufferedInputStream(fileInput_move1.getInputStream());
				
				while ((count = is.read(buf)) > -1) {
					os.write(buf, 0, count);
				}
				
				os = new FileOutputStream(file_move2);
				is = new BufferedInputStream(fileInput_move2.getInputStream());
				
				while ((count = is.read(buf)) > -1) {
					os.write(buf, 0, count);
				}
				
				os = new FileOutputStream(file_jump);
				is = new BufferedInputStream(fileInput_jump.getInputStream());
				
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

			
}

	@Override
	public void uploadBackground(int id, BackgroundVO sprite,String path) {
		// TODO Auto-generated method stub
		
		
		clearColumnsArgs();

		FormFile fileInput = sprite.getFile();
		
		File folder = new File(path+"/ressources/sprite/" + id +"/background");
		    if(!folder.exists()){
		    	folder.mkdirs();
		    }
		File file = new File(path+"/ressources/sprite/" + id + "/background/"+"background.png");
		FileOutputStream os = null;
		InputStream is = null;

		int count;
		byte buf[] = new byte[4096];
		
		try {
			os = new FileOutputStream(file);
			is = new BufferedInputStream(fileInput.getInputStream());
			
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

		
	}


}
