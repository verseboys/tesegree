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

	//page����
	//fabuҳ�����ݼ�����(�޸ģ�����)
	//	private House house;
	private List<Street> streetlist;
	private List<District> districtlist;
	private List<Type> typelist;
	//	private Users users;
	//	private Type type;  //ԭ�����ص�
	//	private Street street;
	//	private House houses;
	StreetService streetService=new StreetServiceImpl() ;
	DistrictService districtService=new DistrictServiceImpl() ;
	TypeService typeService=new TypeServiceImpl() ;
	HouseService houseService=new HouseServiceImpl();       //�Ƿ�д�����������棿

	//�û���ҳ�б�
	private List<House> houseslistcom;
//	private List<House> houselist;//ԭ�޷�ҳ����
	private Page<House> houselist;
	
	private HouseCondition con;
	//	private List<Street> streetlist;
	//	private List<Type> typelist;

	//��ҳ����
	private Page<House> housePage;

	//��ҳ���ݼ��ط���
	//�û���ҳ�б�

	/**
	 * ����Ա������ҳ
	 * @return
	 */
	public String manager() {
//		HouseDAO houseDAO=new HouseDAO();      //		ActionContext ac=ActionContext.getContext();	
		//		Map request=(Map)ac.get("request");//		request.put("houseslist", houseslist);
//		houselist=houseDAO.findAll();      //List<House>��ʱǰ�治Ӧ�ü����ͣ�������Ϊ���±���
		if (housePage==null) {   
			housePage=new Page<House>();
		}
		houselist=houseService.findpage(con, housePage);
		return "ma_success";
	}

	/**
	 * ��ͨ�û��б�
	 * @return
	 */
	public String common() {
		if (housePage==null) {                                           //	ActionContext ac=ActionContext.getContext();
			housePage=new Page<House>();//ʲô��ʶ��//		Map request=(Map)ac.get("request");
		}                                                                                  //		request.put("houseslistcom", houseslistcom);	
		//		houseslistcom =houseService.findAll(con);             //List<House>��ʱǰ�治Ӧ�ü����ͣ�������Ϊ���±���
		//���ӷ�ҳ��
		housePage= houseService.findpage(con, housePage);
		streetlist=streetService.findAll();
		typelist=typeService.findAll();
		return "co_success";
	}

	//��ҳ���ݼ��ط���

	/**
	 * ����ҳ�����ݼ���
	 * @return
	 */
	public String fabu() {
		if (house!=null) {
			HouseService houseService=new HouseServiceImpl() ;
			house=houseService.findById(house.getId());                 //�˴���������ʵ����д��������ֵ���ǣ���
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

	//fabuҳ�����ݼ�����
	/**
	 * House����ҳ��
	 * @return
	 */
	public String details() {      //	��private  House house;����
		HouseService houseService = new HouseServiceImpl();
		house=houseService.findById(house.getId());
		return "success";
	}

	//House����ҳ��
	/**
	 * �������ⷿ��Ϣ��ת
	 * @return
	 */
	public String Releainfo() {
		return "releainfopage";
	}
	//�������ⷿ��Ϣ��ת
	//page����

	/**
	 * �޸ķ�����Ϣ
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
	 * ɾ��������Ϣ
	 * @return
	 */
	public String delet() {
		houseService.deletHouse(house);
		return "deletsuccess";
	}
	/**
	 * ����������Ϣ
	 * @return
	 */
	public String relea() {
		house.setStreet(street);//		House house=new House();���ձ���ֵ������Ͳ�Ӧ������new�Ķ���
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
