package com.ludomorph.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ludomorph.util.HibernateUtils;

public class LudoMorphDAO implements ILudoMorphDAO{

	
	private static LudoMorphDAO instance = null;

	private LudoMorphDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return instance of LudomMorphDAO
	 */
	
	public static LudoMorphDAO getInstance(Class<?> type) {
		
		if (instance == null) {
			instance = new LudoMorphDAO();			
		}

		return instance;
	}

	@Override
	public <T> void save(T obj) {
		final Session s = HibernateUtils.getSession();
		// Début de la transaction
		final Transaction t = s.beginTransaction();

		// Enregistrement de l'event
		s.save(obj);
		// Fin de la transaction
		t.commit();
		// Fermeture de la session Hibernate
		s.close();
		
	}

	@Override
	public <T> void delete(T obj) {
		final Session s = HibernateUtils.getSession();
		// Début de la transaction
		final Transaction t = s.beginTransaction();

		// Enregistrement de l'event
		s.delete(obj);
		// Fin de la transaction
		t.commit();
		// Fermeture de la session Hibernate
		s.close();
		
	}

	@Override
	public <T> List<T> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void update(T obj) {
		final Session s = HibernateUtils.getSession();
		// Début de la transaction
		final Transaction t = s.beginTransaction();

		// Enregistrement de l'event
		s.update(obj);
		// Fin de la transaction
		t.commit();
		// Fermeture de la session Hibernate
		s.close();
		
	}

}
