package com.ludomorph.dao;

import java.util.List;

public interface ILudoMorphDAO {

	<T> void save(T obj);

	<T> void delete(T obj);

	<T> void update(T obj);
	
	<T> List<T> get(String table, List<String>columns, List<Object> args) ;
	
	<T> List<T> get(String table);

}
