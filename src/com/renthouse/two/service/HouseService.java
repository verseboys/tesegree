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
 * 删除房屋信息
 * @param id
 */
	public void deletHouse(House house);
	
/**
 * 修改房屋信息
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
	 * 增加房屋发布信息
	 * @return
	 */
	public Integer addHouse(House house) ;
	
	/**
	 * 搜索
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
