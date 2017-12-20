package com.renthouse.two.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renthouse.two.entity.District;

/**
 * A data access object (DAO) providing persistence and search support for
 * District entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.renthouse.two.entity.District
 * @author MyEclipse Persistence Tools
 */
public class DistrictDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DistrictDAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(District transientInstance) {
		log.debug("saving District instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(District persistentInstance) {
		log.debug("deleting District instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public District findById(java.lang.Integer id) {
		log.debug("getting District instance with id: " + id);
		try {
			District instance = (District) getSession().get(
					"com.renthouse.two.entity.District", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(District instance) {
		log.debug("finding District instance by example");
		try {
			List results = getSession()
					.createCriteria("com.renthouse.two.entity.District")
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
		log.debug("finding District instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from District as model where model."
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
		log.debug("finding all District instances");
		try {
			String queryString = "from District";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public District merge(District detachedInstance) {
		log.debug("merging District instance");
		try {
			District result = (District) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(District instance) {
		log.debug("attaching dirty District instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(District instance) {
		log.debug("attaching clean District instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}