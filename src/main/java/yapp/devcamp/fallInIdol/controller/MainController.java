package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {

	@RequestMapping(value="/")
	public String home() throws IOException{
		//TwitterBot.twit();
		return "index";
	}

//	@RequestMapping(value="/")
//	public String home() throws IOException{
//		//TwitterBot.twit();
//		return "home";
//	}

}
