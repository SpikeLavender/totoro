package com.lagou.edu.dao;

import com.lagou.edu.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 一个符合SpringDataJpa要求的Dao层接口需要继承 JpaRepository 和 JpaSpecificationExecutor
 * JpaRepository<操作的实体类类型, 主键类型>
 *     封装了基本的CRUD操作
 *
 * JpaSpecificationExecutor<操作的实体类类型>
 *     封装了复杂的查询（分页、排序等）
 */
public interface ResumeDao extends JpaRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {

	@Query("from Resume where id = ?1 and name = ?2")
	List<Resume> findByJPQL(Long id, String name);


	/**
	 * 使用原生SQL语句查询，需要将nativeQuery属性设置为true, 默认为false(jpql)
	 * @param name
	 * @param address
	 * @return
	 */
	@Query(value = "select * from tb_resume where name like ?1 and address like ?2", nativeQuery = true)
	List<Resume> findBySQL(String name, String address);

	/**
	 * 方法命名规则查询
	 * 按照name模糊查询(like)
	 * 方法名以findBy开头
	 *          - 属性名（首字母大写）
	 *              - 查询方式（模糊查询、等价查询）, 如果不屑查询方式, 默认等价查询
	 */
	List<Resume> findByNameLike(String name);

	/**
	 * 方法命名规则查询
	 * 按照name模糊查询(like)
	 * 方法名以findBy开头
	 *          - 属性名（首字母大写）
	 *              - 查询方式（模糊查询、等价查询）, 如果不屑查询方式, 默认等价查询
	 */
	List<Resume> findByNameLikeAndAddress(String name, String address);

}
