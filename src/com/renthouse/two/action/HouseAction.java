/**
 * 
 */
package com.renthouse.two.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.renthouse.two.dao.HouseDAO;
import com.renthouse.two.entity.District;
import com.renthouse.two.entity.House;
import com.renthouse.two.entity.HouseCondition;
import com.renthouse.two.entity.Page;
import com.renthouse.two.entity.Street;
import com.renthouse.two.entity.Type;
import com.renthouse.two.entity.Users;
import com.renthouse.two.service.DistrictService;
import com.renthouse.two.service.HouseService;
import com.renthouse.two.service.StreetService;
import com.renthouse.two.service.TypeService;
import com.renthouse.two.service.impl.DistrictServiceImpl;
import com.renthouse.two.service.impl.HouseServiceImpl;
import com.renthouse.two.service.impl.StreetServiceImpl;
import com.renthouse.two.service.impl.TypeServiceImpl;

/**
 * @author verseboys
 *
 */
public class HouseAction extends ActionSupport {
	private Users users;
	private Type type;
	private Street street;
	private District district;
	private  House house;

	//page数据
	//fabu页面数据加载类(修改，新增)
	//	private House house;
	private List<Street> streetlist;
	private List<District> districtlist;
	private List<Type> typelist;
	//	private Users users;
	//	private Type type;  //原数据重叠
	//	private Street street;
	//	private House houses;
	StreetService streetService=new StreetServiceImpl() ;
	DistrictService districtService=new DistrictServiceImpl() ;
	TypeService typeService=new TypeServiceImpl() ;
	HouseService houseService=new HouseServiceImpl();       //是否写到类属性里面？

	//用户主页列表
	private List<House> houseslistcom;
//	private List<House> houselist;//原无分页遍历
	private Page<House> houselist;
	
	private HouseCondition con;
	//	private List<Street> streetlist;
	//	private List<Type> typelist;

	//分页属性
	private Page<House> housePage;

	//主页数据加载方法
	//用户主页列表

	/**
	 * 管理员管理主页
	 * @return
	 */
	public String manager() {
//		HouseDAO houseDAO=new HouseDAO();      //		ActionContext ac=ActionContext.getContext();	
		//		Map request=(Map)ac.get("request");//		request.put("houseslist", houseslist);
//		houselist=houseDAO.findAll();      //List<House>此时前面不应该加类型，加类型为，新变量
		if (housePage==null) {   
			housePage=new Page<House>();
		}
		houselist=houseService.findpage(con, housePage);
		return "ma_success";
	}

	/**
	 * 普通用户列表
	 * @return
	 */
	public String common() {
		if (housePage==null) {                                           //	ActionContext ac=ActionContext.getContext();
			housePage=new Page<House>();//什么意识？//		Map request=(Map)ac.get("request");
		}                                                                                  //		request.put("houseslistcom", houseslistcom);	
		//		houseslistcom =houseService.findAll(con);             //List<House>此时前面不应该加类型，加类型为，新变量
		//增加分页后
		housePage= houseService.findpage(con, housePage);
		streetlist=streetService.findAll();
		typelist=typeService.findAll();
		return "co_success";
	}

	//主页数据加载方法

	/**
	 * 发布页面数据加载
	 * @return
	 */
	public String fabu() {
		if (house!=null) {
			HouseService houseService=new HouseServiceImpl() ;
			house=houseService.findById(house.getId());                 //此处可重名，实现重写，数据增值覆盖！！
			streetlist=streetService.findAll();
			districtlist=districtService.findAll();
			typelist=typeService.findAll();
			return "tomodify";
		} else {
			streetlist=streetService.findAll();
			districtlist=districtService.findAll();
			typelist=typeService.findAll();
			return "toadd";
		}
	}

	//fabu页面数据加载类
	/**
	 * House详情页面
	 * @return
	 */
	public String details() {      //	与private  House house;公用
		HouseService houseService = new HouseServiceImpl();
		house=houseService.findById(house.getId());
		return "success";
	}

	//House详情页面
	/**
	 * 发布新租房信息跳转
	 * @return
	 */
	public String Releainfo() {
		return "releainfopage";
	}
	//发布新租房信息跳转
	//page数据

	/**
	 * 修改房屋信息
	 * @return
	 */
	public String modify() {
		house.setStreet(street);
		house.setType(type);
		house.setUsers(users);
		houseService.modifyHouse(house);
		return "success";
	}

	/**
	 * 删除房屋信息
	 * @return
	 */
	public String delet() {
		houseService.deletHouse(house);
		return "deletsuccess";
	}
	/**
	 * 发布房屋信息
	 * @return
	 */
	public String relea() {
		house.setStreet(street);//		House house=new House();接收表单的值，该类就不应该有新new的对象。
		house.setType(type);
		house.setUsers(users);
		Integer num=houseService.addHouse(house);
		if (num!=1) {
			return "add_success";
		} else {
			return "add_error";
		}
	}

	/**
	 * @return the house
	 */
	public House getHouse() {
		return house;
	}
	/**
	 * @param house the house to set
	 */
	public void setHouse(House house) {
		this.house = house;
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
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * @return the streetlist
	 */
	public List<Street> getStreetlist() {
		return streetlist;
	}

	/**
	 * @param streetlist the streetlist to set
	 */
	public void setStreetlist(List<Street> streetlist) {
		this.streetlist = streetlist;
	}

	/**
	 * @return the districtlist
	 */
	public List<District> getDistrictlist() {
		return districtlist;
	}

	/**
	 * @param districtlist the districtlist to set
	 */
	public void setDistrictlist(List<District> districtlist) {
		this.districtlist = districtlist;
	}

	/**
	 * @return the typelist
	 */
	public List<Type> getTypelist() {
		return typelist;
	}

	/**
	 * @param typelist the typelist to set
	 */
	public void setTypelist(List<Type> typelist) {
		this.typelist = typelist;
	}

	/**
	 * @return the houseslistcom
	 */
	public List<House> getHouseslistcom() {
		return houseslistcom;
	}

	/**
	 * @param houseslistcom the houseslistcom to set
	 */
	public void setHouseslistcom(List<House> houseslistcom) {
		this.houseslistcom = houseslistcom;
	}



	/**
	 * @return the con
	 */
	public HouseCondition getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(HouseCondition con) {
		this.con = con;
	}

	/**
	 * @return the housePage
	 */
	public Page<House> getHousePage() {
		return housePage;
	}

	/**
	 * @param housePage the housePage to set
	 */
	public void setHousePage(Page<House> housePage) {
		this.housePage = housePage;
	}

	/**
	 * @return the houselist
	 */
	public Page<House> getHouselist() {
		return houselist;
	}

	/**
	 * @param houselist the houselist to set
	 */
	public void setHouselist(Page<House> houselist) {
		this.houselist = houselist;
	}

}
