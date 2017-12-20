package com.renthouse.two.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renthouse.two.dao.BaseHibernateDAO;
import com.renthouse.two.dao.StreetDAO;
import com.renthouse.two.entity.Street;

/**
 * A data access object (DAO) providing persistence and search support for
 * Street entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.renthouse.two.entity.Street
 * @author MyEclipse Persistence Tools
 */
public class StreetDAOImpl extends BaseHibernateDAO implements StreetDAO{
	private static final Logger log = LoggerFactory.getLogger(StreetDAOImpl.class);
	// property constants
	public static final String NAME = "name";

	public void save(Street transientInstance) {
		log.debug("saving Street instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Street persistentInstance) {
		log.debug("deleting Street instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Street findById(java.lang.Integer id) {
		log.debug("getting Street instance with id: " + id);
		try {
			Street instance = (Street) getSession().get(
					"com.renthouse.two.entity.Street", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Street instance) {
		log.debug("finding Street instance by example");
		try {
			List results = getSession()
					.createCriteria("com.renthouse.two.entity.Street")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Street instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Street as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Street instances");
		try {
			String queryString = "from Street";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Street merge(Street detachedInstance) {
		log.debug("merging Street instance");
		try {
			Street result = (Street) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Street instance) {
		log.debug("attaching dirty Street instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Street instance) {
		log.debug("attaching clean Street instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}