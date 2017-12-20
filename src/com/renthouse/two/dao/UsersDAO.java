/**
 * 
 */
package com.renthouse.two.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.renthouse.two.entity.Users;


/**
 * @author verseboys
 *
 */
public interface UsersDAO   {
	
	public void save(Users transientInstance) ;

	public void delete(Users persistentInstance) ;

	public Users findById(java.lang.Integer id) ;

	public List findByExample(Users instance) ;

	public List findByProperty(String propertyName, Object value);

	public List findByName(Object name);

	public List findByPassword(Object password) ;
	public List findByTelephone(Object telephone) ;

	public List findByUsername(Object username) ;

	public List findByIsadmin(Object isadmin) ;

	public List findAll();

	public Users merge(Users detachedInstance) ;

	public void attachDirty(Users instance);

	public void attachClean(Users instance);
}
