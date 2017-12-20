/**
 * 
 */
package com.renthouse.two.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.renthouse.two.entity.Street;

/**
 * @author verseboys
 *
 */
public interface StreetDAO  {
	
	
	public void save(Street transientInstance) ;
	public void delete(Street persistentInstance) ;

	public Street findById(java.lang.Integer id) ;

	public List findByExample(Street instance) ;

	public List findByProperty(String propertyName, Object value);
	public List findByName(Object name) ;

	public List findAll() ;

	public Street merge(Street detachedInstance);

	public void attachDirty(Street instance);

	public void attachClean(Street instance);

}
