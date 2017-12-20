/**
 * 
 */
package com.renthouse.two.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.renthouse.two.dao.HouseDAO;
import com.renthouse.two.dao.impl.UsersDAOImpl;
import com.renthouse.two.entity.House;
import com.renthouse.two.entity.HouseCondition;
import com.renthouse.two.entity.Page;
import com.renthouse.two.entity.Users;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.HouseService;

/**
 * @author verseboys
 *
 */
public class HouseServiceImpl implements HouseService {



	HouseDAO houseDAO=new HouseDAO();


	/**
	 * 删除房屋元素
	 */
	public void deletHouse(House house) {
		Transaction tx=null;
		try {
			tx=houseDAO.getSession().beginTransaction();

			house=houseDAO.findById(house.getId());
			houseDAO.delete(house);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}


	/**
	 * 更新元素
	 */
	public void modifyHouse(House house) {
		Transaction tx=null;

		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();


			new HouseDAO().merge(house);


			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}


	@Override
	public List<House> findAll() {
		Transaction tx=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//			House house=new HouseDAO().findById(id);
			//			new HouseDAO().delete(house);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return null;
	}


	@Override
	public House findById(Integer id) {
		Transaction tx=null;
		House house=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			house=new HouseDAO().findById(id);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return house;
	}


	@Override
	public Integer addHouse(House house) {
		Transaction tx=null;
		Integer num=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			houseDAO.save(house);

			tx.commit();
			num=0;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
				num=1;
			}
		}
		return num;
	}


	@Override
	public List<House> findAll(HouseCondition con) {
		// TODO Auto-generated method stub
		return houseDAO.findAllList(con);
	}

/**
 * 带搜索加分页
 */
	@Override
	public Page<House> findpage(HouseCondition con,Page<House> page) {
		page=houseDAO.findAllpage(con, page);
		return page ;
	}

/**
 * 无搜索分页管理主页
 */
	@Override
	public Page<House> findAllpageNosear(Page<House> page) {
		page=houseDAO.findAllpageNosear(page);
		return page;
	}

}
