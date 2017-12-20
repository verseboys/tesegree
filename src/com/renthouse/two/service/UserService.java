/**
 * 
 */
package com.renthouse.two.service;

import java.util.List;

import com.renthouse.two.entity.Users;

/**
 * @author verseboys
 *
 */
public interface UserService {


	public void addNewUser(Users users);

	/**
	 * ɾ��Ԫ��
	 */
	public void deletUser(Integer id);


	/**
	 * ����Ԫ��
	 */
	public void modifyHouse();
	
	/**
	 * ����������
	 * @param name
	 * @return
	 */
	public List findByName(Object name);
}
