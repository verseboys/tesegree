/**
 * 
 */
package com.renthouse.two.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.renthouse.two.dao.impl.StreetDAOImpl;
import com.renthouse.two.entity.Street;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.StreetService;

/**
 * @author verseboys
 *
 */
public class StreetServiceImpl implements StreetService{

	@Override
	public List<Street> findAll() {
		Transaction tx=null;
		List<Street>  streetlist=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			streetlist=new StreetDAOImpl().findAll();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return streetlist;
	}
	
}
