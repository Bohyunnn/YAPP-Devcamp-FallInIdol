package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Component
public class MainController {
	

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request,HttpServletResponse response) {
		
        	return "index";
        

	}

}
 