package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DTO.*;


@Repository
public class NotesDAO {
	
	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional
	public void add(Notes note)
	{
		Session session = sessionfactory.openSession();
		try {
			Transaction tr = session.beginTransaction();
			session.save(note);
			tr.commit();
			session.close();
			}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			}
	}
	
	public List<Notes> display(){
			Session session  = sessionfactory.openSession();
			Query query = session.createQuery("from Notes");
			List li = new ArrayList<Notes>();
			li =  query.list();
			session.close();
			return li;
	}
	
	@Transactional
	public void delete(int id) {
		Session session = sessionfactory.openSession();
		
		Query query = session.createQuery("delete from Notes where id="+id);
		query.executeUpdate();
		
		session.close();
	}
	public Notes get(int id) {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Notes where id=:id");
		query.setParameter("id", id);
		return (Notes) query.uniqueResult();
	}
	
	@Transactional
	public void update(Notes note) {
		Session session = sessionfactory.openSession();
		try {
			Transaction tr= session.beginTransaction();
			session.saveOrUpdate(note);
			tr.commit();
			session.close();
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
			session.getTransaction().rollback();
		}
	}
}
