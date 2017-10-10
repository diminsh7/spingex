package blog.synths.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.synths.web.MemberRequest;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	public int addMember(MemberRequest memberRequest) {
		//MemberRequest Type --> Member Type
		Member member = new Member();
		member.setMemberId(memberRequest.getMemberId());
		member.setMemberPw(memberRequest.getMemberPw());
		member.setMemberName(memberRequest.getMemberName());
		return memberDao.insertMember(member);	
	}
}
