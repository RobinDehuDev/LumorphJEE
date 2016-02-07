package com.ludomorph.dao;

import java.util.List;

public interface ILudoMorphDAO {

	<T> void save(T obj);

	<T> void delete(T obj);

	<T> void update(T obj);
	
	<T> List get(String table, List<String>columns, List<Object> args) ;

}
