package yapp.devcamp.fallInIdol.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = "/Rest", method = RequestMethod.GET)
	public String homecontroller() {
		return "hello rest";
	}

}
