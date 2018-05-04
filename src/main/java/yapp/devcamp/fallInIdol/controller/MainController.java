package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
public class MainController {
	
	@RequestMapping(value = "/")
	public String home() throws IOException {
		// TwitterBot.twit();
		return "index";
	}

}
 