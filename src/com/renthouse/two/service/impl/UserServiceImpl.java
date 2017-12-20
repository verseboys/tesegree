/**
 * 
 */
package com.renthouse.two.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.renthouse.two.dao.UsersDAO;
import com.renthouse.two.dao.impl.UsersDAOImpl;
import com.renthouse.two.entity.Users;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.UserService;



/**
 * @author verseboys
 *
 */
public class UserServiceImpl implements UserService {

	
	//ע��
	private UsersDAOImpl usersDAO;
	
	
//	UsersDAO usersDAO = new UsersDAOImpl();
	

	//����
	public void addNewUser(Users users) {
		Transaction tx=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();//ҵ��㹤����ķ������б�Ҫ��


			usersDAO.save(users);

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}
/**
 * 
 * @param id
 * @return
 */
	public Users findById_get(Serializable id) {

		Users users=null;
		Transaction tx=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();




			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return users;
	}




	//��ѯȫ��
	@SuppressWarnings("unchecked")
	public List<Users> findAllUser() {
		Transaction tx=null;
		List<Users>  userList=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			
			userList=usersDAO.findAll();
			
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return userList;
	}


	@SuppressWarnings("unchecked")
	public List<Users> findAllUser2() {
		Transaction tx=null;
		List<Users>  userList2=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			
		    userList2=usersDAO.findAll();//δ����springǰ
//			userList2=usersDAO.findAll();//����ע������usersDAO
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return userList2;
	}



	/**
	 * ɾ��Ԫ��
	 */
	public void deletUser(Integer id) {
		Transaction tx=null;

		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			
			

			Users users=usersDAO.findById(id);
			
			

			new UsersDAOImpl().delete(users);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}


	/**
	 * ����Ԫ��
	 */
	public void modifyHouse() {
		Transaction tx=null;

		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();


			

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}

	/**
	 * �ڶ��ָ��·���
	 */
	public void modifyUserTwo(Users users) {
		Transaction tx=null;

		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();


			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
	}
	/**
	 * 
	 */
	@Override
	public List findByName(Object name) {
		Transaction tx=null;
		List<Users> userList=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();

			 userList=usersDAO.findByName(name);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx!=null) {
				tx.rollback();
			}
		}
		return userList;
	}

	/**
	 * @return the usersDAO
	 */
	public UsersDAOImpl getUsersDAO() {
		return usersDAO;
	}
	/**
	 * @param usersDAO the usersDAO to set
	 */
	public void setUsersDAO(UsersDAOImpl usersDAO) {
		this.usersDAO = usersDAO;
	}
	
}