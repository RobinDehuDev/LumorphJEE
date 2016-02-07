package com.ludomorph.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.UserVO;
import com.ludomorph.dao.ILudoMorphDAO;
import com.ludomorph.dao.LudoMorphDAO;

public class UserService implements IUserService {

	private static UserService instance = null;
	
	private List<String> columns = new ArrayList<String>();
	private List<Object> args = new ArrayList<Object>();
	private String table = "UserDO";
	private ILudoMorphDAO dao = LudoMorphDAO.getInstance();
	
	private UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static UserService getInstance() {
	
		if (instance == null) {
			instance = new UserService();
		}
	
		return instance;
	}

	private void clearColumnsArgs()
	{
		columns.clear();
		args.clear();
	}

	public UserDO getUser(int id) {
		
		clearColumnsArgs();
		UserDO userDO = null;
		
		columns.add("id");
		args.add(id);
		
		List<?> list = dao.get(table, columns, args);
		
		if(!list.isEmpty())
			userDO = (UserDO)(list.get(0));
		
		return userDO;
	}

	private UserDO toDO(UserVO userVO){
		UserDO userDO = new UserDO();
		userDO.setName(userVO.getName());
		userDO.setEmail(userVO.getEmail());
		userDO.setPassword(userVO.getPassword());
		
		return userDO;
	}

	private UserVO toVO(UserDO userDO){
		UserVO userVO = new UserVO();
		userVO.setId(userDO.getId());
		userVO.setName(userDO.getName());
		userVO.setEmail(userDO.getEmail());
		userVO.setPassword(userDO.getPassword());
		
		return userVO;
	}

	@Override
	public boolean exist(String name) {
		
		boolean res = true;

		clearColumnsArgs();
		
		columns.add("name");
		args.add(name);

		List<?> list = dao.get(table, columns, args);
		System.out.println("Test liste : "+list.toString());
		
		if(list.isEmpty())
			res=false;
		else
			res=true;
		System.out.println(res);
		return res;
	}

	@Override
	public void register(UserVO registration) {
	
		
		UserDO userDO = toDO(registration);
		dao.save(userDO);
	}
	
	@Override
	public UserVO connection(ConnectionVO connection) {
		
		clearColumnsArgs();
		UserVO userVO = null;
		
		columns.add("name");
		args.add(connection.getName());
		
		columns.add("password");
		args.add(connection.getPassword());
		
		List<?> list = dao.get(table, columns, args);
		
		if(!list.isEmpty())
			userVO = toVO((UserDO)(list.get(0)));
		
		return userVO;
	}

}
