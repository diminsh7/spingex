package blog.synths.web.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired //'='の代わり
	SqlSessionTemplate sqlSession;
	public Member selectByNo(int memberNo) {
		return sqlSession.selectOne("blog.synths.web.service.MemberMapper.selectByNo", memberNo);
	}
}
