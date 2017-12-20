/**
 * 
 */
package com.renthouse.two.service;

import java.util.List;

import com.renthouse.two.entity.House;
import com.renthouse.two.entity.HouseCondition;
import com.renthouse.two.entity.Page;

/**
 * @author verseboys
 *
 */
public interface HouseService {
/**
 * ɾ��������Ϣ
 * @param id
 */
	public void deletHouse(House house);
	
/**
 * �޸ķ�����Ϣ
 */
	public void modifyHouse(House house);
	
	/**
	 * 
	 * @return
	 */
	public List<House> findAll();
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public House findById(java.lang.Integer id) ;
	
	
	/**
	 * ���ӷ��ݷ�����Ϣ
	 * @return
	 */
	public Integer addHouse(House house) ;
	
	/**
	 * ����
	 * @param con
	 * @return
	 */
	public List<House> findAll(HouseCondition con);
	/**
	 * 
	 * @param con
	 * @return
	 */
	public Page<House> findpage(HouseCondition con,Page<House> page);
	
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public Page<House> findAllpageNosear(Page<House> page);
	
}
