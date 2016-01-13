package com.javaquarium.dao;

import java.util.List;

public interface ILudoMorphDAO {

	<T> void save(T obj);

	<T> void delete(T obj);

	<T> List<T> get();

	<T> void update(T obj);

}
