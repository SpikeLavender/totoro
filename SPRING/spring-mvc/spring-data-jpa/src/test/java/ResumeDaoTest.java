import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ResumeDaoTest {


	//要测试IOC哪个对象注入即可
	@Autowired
	private ResumeDao resumeDao;


	/**
	 * dao层接口调用，分成两块
	 * 1、基础的增删改查
	 * 2、专门针对查询的详细分析使用
	 */
	@Test
	public void testFindById() {
		//早期的版本 dao.findOne(id);
		/**
		 * Hibernate: 
		 * select 
		 *      resume0_.id as id1_0_0_, 
		 *      resume0_.address as address2_0_0_, 
		 *      resume0_.name as name3_0_0_, 
		 *      resume0_.phone as phone4_0_0_ 
		 * from tb_resume resume0_ where resume0_.id=?
		 */
		Optional<Resume> optional = resumeDao.findById(1L);
		Resume resume = optional.get();
		System.out.println(resume);

	}
	
	@Test
	public void testFindOneExist() {
		Resume resume = new Resume();
		resume.setId(1L);
		Example<Resume> example = Example.of(resume);
		Optional<Resume> one = resumeDao.findOne(example);
		if (one.isPresent()) {
			Resume resume1 = one.get();
			System.out.println(resume1);
		}
	}

	@Test
	public void testFindOneNot() {
		Resume resume = new Resume();
		resume.setId(1L);
		resume.setName("张");
		Example<Resume> example = Example.of(resume);
		Optional<Resume> one = resumeDao.findOne(example);
		if (one.isPresent()) {
			Resume resume1 = one.get();
			System.out.println(resume1);
		}
	}

	@Test
	/**
	 * 新增和更新都使用save方法，通过传入的对象的主键有无来区分
	 * 没有主键信息那就是新增
	 * 有主键信息就是更新
	 */
	public void testSaveOfInsert() {
		Resume resume = new Resume();
		resume.setName("赵六");
		resume.setAddress("成都");
		resume.setPhone("13200000000");
		Resume save = resumeDao.save(resume);
		System.out.println(save);
	}

	@Test
	public void testSaveOfUpdate() {
		Resume resume = new Resume();
		resume.setId(4L);
		resume.setName("赵六六");
		resume.setAddress("成都");
		resume.setPhone("13200000000");
		Resume save = resumeDao.save(resume);
		System.out.println(save);
	}

	@Test
	public void testDelete() {
		resumeDao.deleteById(5L);
	}

	@Test
	public void testFindAll() {
		List<Resume> list = resumeDao.findAll();
		for (Resume resume : list) {
			System.out.println(resume);
		}
	}


	/**
	 * ======================针对查询的使用进行分析=========================
	 * 方式一: 调用继承的接口中的方法     findOne(), findById()
	 * 方式二: 引入jpql(jpa查询语言)语句进行查询
	 *        (jpql 语句类似于sql，只不过sql操作的是数据表和字段，jpql操作的是对象和属性，
	 *        比如 from Resume where id=xxx)
	 *
	 * 方式三: 引入原生的SQL语句
	 * 方式四: 可以在接口中自定义方法, 而且不必引入jpql或者sql语句, 这种方式叫做方法命名规则查询
	 *          也就是说如果定义的接口方法名是按照一定规则形成的，那么框架就能够理解我们的意图
	 */
	@Test
	public void testFindByJPQL() {
		List<Resume> list = resumeDao.findByJPQL(1L, "张三");
		for (Resume resume : list) {
			System.out.println(resume);
		}
	}

	@Test
	public void testFindBySQL() {
		List<Resume> list = resumeDao.findBySQL("李%", "上海%");
		for (Resume resume : list) {
			System.out.println(resume);
		}
	}

	@Test
	public void testFindByNameLike() {
		List<Resume> list = resumeDao.findByNameLike("李%");
		for (Resume resume : list) {
			System.out.println(resume);
		}
	}


	@Test
	public void testFindByNameLikeAndAddress() {
		List<Resume> list = resumeDao.findByNameLikeAndAddress("李%", "上海");
		for (Resume resume : list) {
			System.out.println(resume);
		}
	}
}
