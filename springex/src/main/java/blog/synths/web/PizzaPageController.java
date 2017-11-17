package blog.synths.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PizzaPageController {
	
	@RequestMapping(value = "/pizzaPage", method = RequestMethod.GET)
	public String pizzaPage() {
		System.out.println("[PizzaPageController.java] pizzaPage Method Access");
		return "pieChart";
	}
}
