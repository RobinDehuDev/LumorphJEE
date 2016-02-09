package com.ludomorph.business;

import java.util.ArrayList;
import java.util.List;

import com.ludomorph.beans.data.LevelDO;
import com.ludomorph.beans.web.LevelVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class LoadLevelService implements ILoadLevelService {

	private static LoadLevelService instance = null;
	private static String tableLevel = "LevelDO";
	
	

	private LoadLevelService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return instance of LudomMorphDAO
	 */

	public static LoadLevelService getInstance() {

		if (instance == null) {
			instance = new LoadLevelService();
		}

		return instance;
	}

	@Override
	public List<LevelVO> getLevels(int id) {
		ILudoMorphDAO dao = LudoMorphDAO.getInstance();
		
		List<String> columns = new ArrayList<String>();
		columns.add("user_id");
		List<String> args = new ArrayList<String>();
		args.add(id+"");
		
		
		
		List<LevelDO> listRaw = dao.<LevelDO>get(tableLevel);
		
		
		reduce(listRaw, id);
		
		List<LevelVO> list = new ArrayList<LevelVO>();
		
	
		for(LevelDO level : listRaw){
			list.add(toVO(level));
		}
		
		
		
		return list;
	}
	
	private LevelVO toVO(LevelDO level){
		List<Character> oneLine = new ArrayList<Character>();
		List<List<Character>> map = new ArrayList<List<Character>>();
		int Separator = level.getValue().indexOf('@');
		int width = Integer.parseInt(level.getValue().substring(0, Separator));
		int height;
		String data = level.getValue().substring(Separator+1);
		
		String qtt = "";
		char value;
		
		for(int i = 0 ; i < data.length() ; i++){
			
			
			
			value = data.charAt(i);
			if(value < 'A'){
				// cas ou on lit un chiffre
				qtt = qtt+value;
			} else {
				for(int j = 0 ; j < Integer.parseInt(qtt) ; j++){
					oneLine.add(value);
				}
				qtt = "";
			}			
		}
		
		height = oneLine.size()/width;
		
		for(int i = 0; i < height ; i++){
			
			
			
			map.add(oneLine.subList(i*width, i*width+width));
		}
		
		System.out.println("height : "+height);
		
		LevelVO levelVo = new LevelVO(map, level.getName(), width, height, level.getId());
		
		
		
		return levelVo;
	}
	
	private void reduce(List<LevelDO> listRaw, int id){
		List<LevelDO> list = new ArrayList<>();
		for(LevelDO level : listRaw){
			if(level.getUser().getId() == id)
				list.add(level);
		}
		
		listRaw = list;
	}

	@Override
	public void update(LevelVO level, List<LevelVO> list) {
		for(LevelVO l : list){
			if(l.getId() == level.getId()){
				level.setLevel(l.getLevel());
				level.setName(l.getName());
				level.setWidth(l.getWidth());
				level.setHeight(l.getHeight());
				System.out.println("loaded Height : "+level.getHeight());
			}
		}
		
	}
}
