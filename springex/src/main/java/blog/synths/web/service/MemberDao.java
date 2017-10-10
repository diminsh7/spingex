package blog.synths.web.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	private final String NS = "blog.synths.web.service.MemberMapper.";
	
	@Autowired //'='の代わり
	SqlSessionTemplate sqlSession;
	
	public Member selectByNo(int memberNo) {
		return sqlSession.selectOne(NS + "selectByNo", memberNo);
	}
	public int insertMember(Member member) {
		return sqlSession.insert(NS + "insertMember", member);
	}
	public List<Member> selectAllMember(){
		return sqlSession.selectList(NS + "selectAllMember");
	}
}
