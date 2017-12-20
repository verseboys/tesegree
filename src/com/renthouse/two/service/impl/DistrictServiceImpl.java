/**
 * 
 */
package com.renthouse.two.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.renthouse.two.dao.DistrictDAO;
import com.renthouse.two.dao.HouseDAO;
import com.renthouse.two.entity.District;
import com.renthouse.two.entity.House;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.DistrictService;

/**
 * @author verseboys
 *
 */
public class DistrictServiceImpl implements DistrictService{

	@Override
	public List<District> findAll() {
		Transaction tx=null;
		List<District>  districtlist=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			
			
			districtlist=new DistrictDAO().findAll();
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return districtlist;
	}

}
