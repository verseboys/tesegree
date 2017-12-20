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
	 * 删除元素
	 */
	public void deletUser(Integer id);


	/**
	 * 更新元素
	 */
	public void modifyHouse();
	
	/**
	 * 根据名字找
	 * @param name
	 * @return
	 */
	public List findByName(Object name);
}
