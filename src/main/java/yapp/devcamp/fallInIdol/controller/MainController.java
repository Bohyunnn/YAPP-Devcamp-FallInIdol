package yapp.devcamp.fallInIdol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	@GetMapping("/index")
	public String index(){
		return "index";
	}
}
