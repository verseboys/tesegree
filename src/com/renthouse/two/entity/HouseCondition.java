/**
 * 
 */
package com.renthouse.two.entity;

/**
 * @author verseboys
 *
 */
public class HouseCondition {
  private String title;
	private Double price;
	private Street street;
	private Type type;
	private Integer floorage;
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the street
	 */
	public Street getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(Street street) {
		this.street = street;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the floorage
	 */
	public Integer getFloorage() {
		return floorage;
	}
	/**
	 * @param floorage the floorage to set
	 */
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
