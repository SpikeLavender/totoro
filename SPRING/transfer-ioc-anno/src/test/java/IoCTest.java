
import com.hetengjiao.SpringConfig;
import com.hetengjiao.dao.AccountDao;
import com.hetengjiao.dao.impl.JdbcAccountDaoImpl;
import com.hetengjiao.pojo.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;

public class IoCTest {

	@Test
	@Autowired
	public void testIoC() throws SQLException {
		// 通过classpath下的xml文件启动容器（xml模式SE应用下推荐）
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SpringConfig.class);
		//不推荐使用
		//ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件系统的绝对路径");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao);

		AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao");
		System.out.println(accountDao1);

		Account account = accountDao.queryAccountByCardNo("100");
		System.out.println(account);

	}
}
