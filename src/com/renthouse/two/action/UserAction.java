/**
 * 
 */
package com.renthouse.two.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;













import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.renthouse.two.dao.impl.UsersDAOImpl;
import com.renthouse.two.entity.Users;
import com.renthouse.two.service.UserService;
import com.renthouse.two.service.impl.UserServiceImpl;



/**
 * @author verseboys
 *
 */
public class UserAction extends ActionSupport {

	private String nextDispose;
	private String repassword;
//	private Short id;
//	private String name;
//	private String password;  //不需要逐个去写属性了！！！！！！
//	private String telephone;
//	private String username;
//	private String isadmin;
//	private Set houses = new HashSet(0);
	private Users users;
	
	
	
	

	
	private UserService userService;/*=new UserServiceImpl();*/
	
	
	//pag数据
	/**
	 * 进入登录页面
	 * @return
	 */
	public String loginpage() {
		return "loginpage";
	}
	/**
	 * 注册加载页
	 * @return
	 */
	public String regsteredpage() {
		return "regsteredpage";
	}
	//pag数据

/**
 * 用户登录
 * @return
 * @throws IOException
 */
	@SuppressWarnings("unchecked")
	public String login() throws IOException  {
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=ac.getSession();
		PrintWriter out =ServletActionContext.getResponse().getWriter();
		
		List<Users> userslists=null;
		userslists = userService.findByName(users.getName());
		Users usersfbn=userslists.get(0);
		if (usersfbn.getPassword().equals(users.getPassword())) {
			session.put("users", usersfbn);                                                  //数据库找到的对象值
			if (usersfbn.getIsadmin().equals("管理员")) {
				nextDispose="managerpage";
			} else {
				nextDispose="commonpage";
			}                       //			out.println("<script type='text/javascript'> alert('你已经注册成功了，赶快登录吧！');location.href='../Home.jsp';</script>");
			return "success";
		} else {
			return "error";
		}
	}

/**
 * 注册用户
 * @return
 */
	public String regster() {
//		Users users=new Users();                 //不需要新new的users，因为是表单提交过来的
//		users.setName(name);
//		users.setPassword(password);            //无需再通过set（表单自动提交，并写入）
//		users.setTelephone(telephone);
//		users.setUsername(username);
//		users.setIsadmin(isadmin);
		if (users.getPassword().equals(repassword)) {
			
			userService.addNewUser(users);
			return "reg_success";
		} else {
			return "reg_error";
		}
	}
	/**
	 * @return the nextDispose
	 */
	public String getNextDispose() {
		return nextDispose;
	}
	/**
	 * @param nextDispose the nextDispose to set
	 */
	public void setNextDispose(String nextDispose) {
		this.nextDispose = nextDispose;
	}
	/**
	 * @return the repassword
	 */
	public String getRepassword() {
		return repassword;
	}
	/**
	 * @param repassword the repassword to set
	 */
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	/**
	 * @return the houses
	 */
//	public Set getHouses() {
//		return houses;
//	}
//	/**
//	 * @param houses the houses to set
//	 */
//	public void setHouses(Set houses) {
//		this.houses = houses;
//	}
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
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
