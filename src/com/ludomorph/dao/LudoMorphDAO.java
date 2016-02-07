package com.ludomorph.dao;


import java.util.List;

import org.hibernate.Query;
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
	
	public static LudoMorphDAO getInstance() {
		
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

	@Override
	public <T> List get(String table, List<String>columns, List<Object> args) {
		// TODO Auto-generated method stub
		Session s = HibernateUtils.getSession();
		// Début de la transaction
		Transaction tx = s.beginTransaction();
		
		// Création de la requête
		String request = "from " + table + " where ";
		for(int i=0; i<columns.size();i++)
		{
				request += columns.get(i) + "=:" + columns.get(i);
				
				if(i!=columns.size()-1)
					request += " and ";
		}
		Query q = s.createQuery(request);
		
		for(int i=0; i<args.size();i++)
		{
			q.setParameter(columns.get(i), args.get(i));
		}
		
		// Récupération de la liste des résultats
		List list = q.list();

		return list;
	}

}
