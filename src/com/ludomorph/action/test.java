package com.ludomorph.action;

import java.util.ArrayList;
import java.util.List;

import com.ludomorph.beans.web.LevelLineVO;
import com.ludomorph.beans.web.LevelVO;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<LevelLineVO> map = new ArrayList<LevelLineVO>();
		
		for(int i = 0 ; i < 10 ; i++)
			list.add(0);
		
		for(int j = 0 ; j < 10 ; j++){
			map.add(new LevelLineVO(list));
		}
		
		String r = "";
		for(LevelLineVO l : map){
			for(Integer i : l){
				r+=i;
			}
			r+="\n";
		}
		
		//System.out.println(r);
		
		LevelVO level = new LevelVO();
		level.generateTest001();
		System.out.println("map : ");
		System.out.println(level);

	}

}
