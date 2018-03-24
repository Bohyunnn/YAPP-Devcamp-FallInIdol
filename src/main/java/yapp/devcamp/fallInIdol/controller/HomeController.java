package yapp.devcamp.fallInIdol.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = "/Rest", method = RequestMethod.GET)

	public String homecontroller() {
		// 크롤링을 해서 
		// 가공을 해서 (마동석 전체 다 말고 우리 서비스에 필요한 로직)
		return "hello rest";
	}

}
