package com.ludomorph.business;

import com.ludomorph.beans.data.UserDO;
import com.ludomorph.beans.web.ConnectionVO;
import com.ludomorph.beans.web.UserVO;

public interface IUserService {

	boolean exist(String name);

	void register(UserVO registration);
	
	UserVO connection(ConnectionVO connection);
	
	UserDO getUser(int id);
	
	UserDO getUser(String name);
}
