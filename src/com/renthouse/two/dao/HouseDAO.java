package com.renthouse.two.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renthouse.two.entity.House;
import com.renthouse.two.entity.HouseCondition;
import com.renthouse.two.entity.Page;

/**
 * A data access object (DAO) providing persistence and search support for House
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.renthouse.two.entity.House
 * @author MyEclipse Persistence Tools
 */
public class HouseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(HouseDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String PRICE = "price";
	public static final String FLOORAGE = "floorage";
	public static final String CONTACT = "contact";

	public void save(House transientInstance) {
		log.debug("saving House instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(House persistentInstance) {
		log.debug("deleting House instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public House findById(java.lang.Integer id) {
		log.debug("getting House instance with id: " + id);
		try {
			House instance = (House) getSession().get(
					"com.renthouse.two.entity.House", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(House instance) {
		log.debug("finding House instance by example");
		try {
			List results = getSession()
					.createCriteria("com.renthouse.two.entity.House")
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
		log.debug("finding House instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from House as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByFloorage(Object floorage) {
		return findByProperty(FLOORAGE, floorage);
	}

	public List findByContact(Object contact) {
		return findByProperty(CONTACT, contact);
	}

	public List findAll() {
		log.debug("finding all House instances");
		try {
			String queryString = "from House";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * (������DAO)���޷�ҳ��
	 * ͬʱ��ʾȫ��
	 * @param con
	 * @return
	 */
	public List findAllList(HouseCondition con) {

		log.debug("finding all House instances");
		try {
			StringBuilder queryString=new StringBuilder("from House as h where 1=1 ");
			Query queryObject;
			if (con!=null) {
				if (con.getTitle()!=null) {
					queryString.append("and h.title like '%"+con.getTitle()+"%' ");  //��ʽ
				}
				if (con.getPrice()!=null) {                                        //where 1=1�����ã�
					if (con.getPrice()==1) {
						queryString.append("and h.price<1000 ");
					} else  if (con.getPrice()==2) {
						queryString.append("and h.price>=1000 and h.price<3000 ");//ÿһ�仰����ӿո񣬲�Ȼ����ƴ��һ��
					} else {
						queryString.append("and h.price>=3000 ");
					}
				}
				if (con.getStreet()!=null&&con.getStreet().getId()!=null) {          //id�ж�
					queryString.append("and h.street =:street ");
				}
				if (con.getType()!=null&&con.getType().getId()!=null) {            //id�ж�
					queryString.append("and h.type =:type ");
				}
				if (con.getFloorage()!=null) {
					if (con.getFloorage()==1) {
						queryString.append("and h.floorage<80 ");
					} else if (con.getFloorage()==2) {
						queryString.append("and h.floorage>=80 and h.floorage<500 ");
					} else {
						queryString.append("and h.floorage>=500 ");
					}
				}

				queryObject = getSession().createQuery(queryString.toString()).setProperties(con);
			}else {
				queryObject = getSession().createQuery(queryString.toString());
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * ��ҳ�Ӳ�ѯ�ķ���
	 * @param con
	 * @return
	 */
	public Page<House> findAllpage(HouseCondition con,Page<House> page) {

		log.debug("finding all House instances");
		//���ռ�¼��
		long count;

		try {
			StringBuilder queryString=new StringBuilder("from House as h where 1=1 ");
			Query queryObject;
			if (con!=null) {
				if (con.getTitle()!=null) {
					queryString.append("and h.title like '%"+con.getTitle()+"%' ");  //��ʽ
				}
				if (con.getPrice()!=null) {                                        //where 1=1�����ã�
					if (con.getPrice()==1) {
						queryString.append("and h.price<1000 ");
					} else  if (con.getPrice()==2) {
						queryString.append("and h.price>=1000 and h.price<3000 ");//ÿһ�仰����ӿո񣬲�Ȼ����ƴ��һ��
					} else {
						queryString.append("and h.price>=3000 ");
					}
				}
				if (con.getStreet()!=null&&con.getStreet().getId()!=null) {          //id�ж�
					queryString.append("and h.street =:street ");
				}
				if (con.getType()!=null&&con.getType().getId()!=null) {            //id�ж�
					queryString.append("and h.type =:type ");
				}
				if (con.getFloorage()!=null) {
					if (con.getFloorage()==1) {
						queryString.append("and h.floorage<80 ");
					} else if (con.getFloorage()==2) {
						queryString.append("and h.floorage>=80 and h.floorage<500 ");
					} else {
						queryString.append("and h.floorage>=500 ");
					}
				}
				count=(Long) getSession().createQuery("select count(id)"+queryString.toString()).setProperties(con).uniqueResult();

				int pagNo=(int) (count%page.getPageSize()==0?count/page.getPageSize():count/page.getPageSize()+1);
				if (pagNo<page.getCuurrPage()) {
					page.setCuurrPage(pagNo);
				}

				int  first=(page.getCuurrPage()-1)*page.getPageSize();
				queryObject = getSession().createQuery(queryString.toString()).setProperties(con)
						.setFirstResult(first).setMaxResults(page.getPageSize());
			}else {


				int  first=(page.getCuurrPage()-1)*page.getPageSize();
				queryObject = getSession().createQuery(queryString.toString())
						.setFirstResult(first).setMaxResults(page.getPageSize());
				count=(Long) getSession().createQuery("select count(id)"+queryString.toString()).uniqueResult();
				//�ñ��������
			}
			List<House> list=queryObject.list();
			page.setHouseList(list);
			page.setTotalCount(count);
			return page;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * ����������ҳ��δ����
	 * @param con
	 * @param page
	 * @return
	 */
	public Page<House> findAllpageNosear(Page<House> page) {

		log.debug("finding all House instances");
		//���ռ�¼��
		long count;
		try {
			StringBuilder queryString=new StringBuilder("from House as h where 1=1 ");
			Query queryObject;
			count=(Long) getSession().createQuery("select count(id)"+queryString.toString()).uniqueResult();
			int pagNo=(int) (count%page.getPageSize()==0?count/page.getPageSize():count/page.getPageSize()+1);
			if (pagNo<page.getCuurrPage()) {
				page.setCuurrPage(pagNo);
			}
			int  first=(page.getCuurrPage()-1)*page.getPageSize();
			queryObject = getSession().createQuery(queryString.toString())
					.setFirstResult(first).setMaxResults(page.getPageSize());
			List<House> list=queryObject.list();		 //�ñ��������
			page.setHouseList(list);
			page.setTotalCount(count);
			return page;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param detachedInstance
	 * @return
	 */
	public House merge(House detachedInstance) {
		log.debug("merging House instance");
		try {
			House result = (House) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * ���»򱣴棨�����ݿ��еģ�����̬--���£�
	 * �����ݿ�û�еģ�˲ʱ����ʱ״̬--����?
	 * @param instance
	 */
	public void attachDirty(House instance) {
		log.debug("attaching dirty House instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(House instance) {
		log.debug("attaching clean House instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}