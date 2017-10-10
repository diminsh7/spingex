package blog.synths.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	//Login Page 出力
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	//Login 処理
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Member member, HttpSession session) { //parameterでHttpSessionを貰う
		Member loginMember = memberDao.loginMember(member);
		if(loginMember == null) {
			return "redirect:/login";
		} else {
			//sessionにLogin情報を入れる。
			session.setAttribute("loginMember", loginMember);
			return "redirect:/loginOnly";
		}
	}
	
	//会員専用ページ
	@RequestMapping(value="loginOnly")
	public String loginOnly(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/login";
		}
		return "loginOnly";
	}
	
	@RequestMapping("/getMember")
	//'getMember'だと呼び出すと
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
	public String memberList(Model model) {
		System.out.println("[MemberController.java / memberList Method]");
		List<Member> mlist = memberDao.selectAllMember();
		model.addAttribute("mlist", mlist);
		return "memberList";
	}
	
}
