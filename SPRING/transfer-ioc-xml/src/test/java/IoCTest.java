import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.SQLException;

public class IoCTest {

	@Test
	public void testIoC() throws SQLException {
		// 通过classpath下的xml文件启动容器（xml模式SE应用下推荐）
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		//不推荐使用
		//ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件系统的绝对路径");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao);

		AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao1);

		Object connectionUtils = applicationContext.getBean("connectionUtilsStatic");
		System.out.println(connectionUtils);

		Object connectionUtilsInstance = applicationContext.getBean("connectionUtilsInstance");
		System.out.println(connectionUtilsInstance);

		Account account = accountDao.queryAccountByCardNo("100");
		System.out.println(account);

	}

	@Test
	public void testIoCDestroy() {
		// 通过classpath下的xml文件启动容器（xml模式SE应用下推荐）
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		//不推荐使用
		//ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件系统的绝对路径");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao);

		AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao1);

		Object connectionUtils = applicationContext.getBean("connectionUtilsStatic");
		System.out.println(connectionUtils);

		Object connectionUtilsInstance = applicationContext.getBean("connectionUtilsInstance");
		System.out.println(connectionUtilsInstance);
		applicationContext.close();

	}
}
