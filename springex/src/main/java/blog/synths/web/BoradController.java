package blog.synths.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.synths.web.service.Board;
import blog.synths.web.service.BoardDao;

@Controller
public class BoradController {
	
	 @Autowired
	 private BoardDao boardDao;

	@RequestMapping(value = "/boardAdd", method = RequestMethod.POST)
	public String boardAdd(Board board) {
		System.out.println(board);
		boardDao.insertBoard(board);
		return "redirect:/boardList"; // 글입력후 "/boardList"로 리다이렉트(재요청)
	}

	// 입력페이지 요청
	@RequestMapping(value = "/boardAdd", method = RequestMethod.GET)
	public String boardAdd() {
		System.out.println("boardAdd 폼 요청");
		return "boardAdd";
	}
}