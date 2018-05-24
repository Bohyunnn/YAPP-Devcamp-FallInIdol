package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
public class CookieController {
	
	@RequestMapping(value = "/")
	public String cookie(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String key = null;
		
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {        	
        	for(int i=0; i<cookies.length; i++){                       
        		if(cookies[i].getName().equals("cookieS")){            
        			key=cookies[i].getValue();                        
        		}
        	}
          
        } 
        
        if(key==null) {
        	return "index";
        }
        else {
        	
        	if(key.contains("youtube")) {
        		key=key.replace("youtube", "feed");
	      	  }
	      	  else if(key.contains("twitter")) {	
	      		key=key.replace("twitter", "feed");
	      	  }
	      	  else if(key.contains("photo")) {
	      		key=key.replace("photo", "feed");
	      	  }
	      	  else {
	      		key=key.replace("profile", "feed");
	      	  }
	      	 
        	return "redirect:"+key;
        	
        }
	}

}
 