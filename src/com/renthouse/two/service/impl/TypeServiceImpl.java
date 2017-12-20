/**
 * 
 */
package com.renthouse.two.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.renthouse.two.dao.DistrictDAO;
import com.renthouse.two.dao.TypeDAO;
import com.renthouse.two.entity.District;
import com.renthouse.two.entity.Type;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.TypeService;

/**
 * @author verseboys
 *
 */
public class TypeServiceImpl implements TypeService{
	
//	private TypeDAO typeDAO;
	
//	TypeDAO typeDAO = new TypeDAOImpl();
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() {
		Transaction tx=null;
		List<Type>  typelist=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
//			typelist=new TypeDAO().findAll();Œ¥≈‰÷√spring
			
			typelist=new TypeDAO().findAll();//≈‰÷√spring 
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return typelist;
	}


}
