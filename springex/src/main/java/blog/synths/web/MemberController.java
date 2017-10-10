package blog.synths.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.synths.web.service.Member;
import blog.synths.web.service.MemberDao;
import blog.synths.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/getMember") //'getMember'だと呼び出すと
	public String getMember(Model model) {
		Member member = memberDao.selectByNo(1);
		model.addAttribute("member", member);
		return "getMember";
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMember() {
		System.out.println("[MemberController.java / addMemeber Method] : insert form");
		return "addMember";
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMemeber(MemberRequest memberRequest) {
		System.out.println("[MemberController.java / addMemeber Method] : insert proccess");
		System.out.println("addMember Param memberRequest : " + memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // = response.sendRedirect("/memberList");
	}
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("[MemberController.java / memberList Method]");
		return "memberList";
	}
}
