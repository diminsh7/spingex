package blog.synths.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import blog.synths.web.service.Pizza;
import blog.synths.web.service.PizzaDao;

@RestController // View를 리턴하는 것이 아닌 JSON 문자열을 리턴할 컨트롤러
public class PizzaController {

	@Autowired
	private PizzaDao pdao;

	@RequestMapping(value = "/pizzaPieChart", method = RequestMethod.GET)
	public List<Pizza> pizzaPieChart() {// ArrayList는 객체타입이지만 @RestController가 알아서 JSON 문자열로 변환, 리턴한다.
		System.out.println("[PizzaController.java] pizzaPieChart Method Access");
		List<Pizza> plist = pdao.selectAll();
		return plist;
	}
}
