/**
 * 
 */
package com.renthouse.two.service;

import java.util.List;

import com.renthouse.two.entity.District;

/**
 * @author verseboys
 *
 */
public interface DistrictService {
	
	/**
	 * 查找所有街区
	 * @return
	 */
	public List<District> findAll();

}
