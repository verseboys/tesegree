package com.renthouse.two.entity;

/**
 * 
 */

import java.util.List;

/**
 * @author verseboys
 *
 */
public class Page<T> {
//	public static final int pageSize1=5;
	
	//��ҳ��
//	private long totalPageCount;
	//ҳ���С����ÿҳ��ʾ��¼��
	private int pageSize=5;
	//��¼����
	private long totalCount=0L;
	//��ǰҳ��ҳ��
	private Integer cuurrPage=1;
	//ÿҳ���ż���
	private List<T> houseList;


//	public Integer getTotalPageCount() {
//		return totalPageCount;
//	}
//	public void setTotalPageCount(Integer totalPageCount) {
//		this.totalPageCount = totalPageCount;
//	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		//���������
				if (pageSize>0) {
					this.pageSize = pageSize;
				}
	}
	/**
	 * @param totalCount the totalCount to set
	 */
//	public void setTotalCount(long totalCount) {
//		this.totalCount = totalCount;
//	}
//	public Integer getTotalCount() {
//		return totalCount;
//	}
	
	
	
	
	public long getTotalPageCount( ) {
//		if(totalCount>0){
//			this.totalCount = totalCount;
			//������ҳ��
//		}
//		totalPageCount=  (this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1));
//	return totalPageCount;
		
		return this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);
	}
	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	public Integer getCuurrPage() {
		return cuurrPage;
	}
	public void setCuurrPage(Integer cuurrPage) {
		//���������
		if (cuurrPage>0) {
			this.cuurrPage = cuurrPage;
		}	
	}
	/**
	 * @return the houseList
	 */
	public List<T> getHouseList() {
		return houseList;
	}
	/**
	 * @param houseList the houseList to set
	 */
	public void setHouseList(List<T> houseList) {
		this.houseList = houseList;
	}

}
