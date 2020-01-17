import com.lagou.edu.pojo.Account;
import com.lagou.edu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application*.xml"})
public class MyBatisSpringTest {

	//希望测试ioc容器中的那个对象，注入即可
	@Autowired
	private AccountService accountService;

	@Test
	public void testMyBatisSpring() throws Exception {

		List<Account> accounts = accountService.queryAccountList();
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
}
