package blog.synths.web.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaDao {
	private final String NS = "blog.synths.web.service.PizzaMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Pizza> selectAll(){
		System.out.println("[PizzaDao.java] selectAll Method Access");
		return sqlSessionTemplate.selectList(NS + "selectAll");
	}
}