package blog.synths.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoradController {
	@RequestMapping(value = "/boardAdd", method = RequestMethod.GET)
	public String boardAdd() {
		//System.out.println("boardAdd 폼 요청");
		return "boardAdd";
	}
}