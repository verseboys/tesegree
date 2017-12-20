/**
 * 
 */
package renthousespring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.renthouse.two.dao.UsersDAO;
import com.renthouse.two.entity.Users;
import com.renthouse.two.factory.HibernateSessionFactory;
import com.renthouse.two.service.UserService;

/**
 * @author verseboys
 *
 */
public class Tyyt {

	public Tyyt() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testSpringFactory(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SessionFactory sessionFactory=(SessionFactory)ctx.getBean("sessionFactory");
	Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
	
	
	
	tx.commit();
	
	}
	
	@Test
	public void testSpringFactory1(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersDAO usersDAO=(UsersDAO)ctx.getBean("usersDAO");
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
//		Users users=new Users();
//		users.setName("2222");
//		users.setPassword("556654");
		List<Users> list=usersDAO.findAll();
		tx.commit();
		
		
	}
	
	@Test
	public void testSpringservice(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userSer=(UserService)ctx.getBean("UsersDAO");
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
//		Users users=new Users();
//        users.setId(1012);;
		
		userSer.deletUser(1012);
		 tx.commit();
	}
	
}
