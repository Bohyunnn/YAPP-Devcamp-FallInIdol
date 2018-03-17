package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yapp.devcamp.fallInIdol.Twitter.TwitterBot;


@Controller
public class MainController {

	@RequestMapping(value="/")
	public String home() throws IOException{
		//TwitterBot.twit();
		return "home";
	}


}
