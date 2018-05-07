package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String key = null;
		
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {        	
        	for(int i=0; i<cookies.length; i++){                       // 쿠키를 반복문으로 돌린다.
        		if(cookies[i].getName().equals("testCookie")){            // 쿠키의 이름이 id 일때
        			key=cookies[i].getValue();                        // 해당 쿠키의 값을 id 변수에 저장한다.
        		}
        	}
          
        }        
        if(key.equals("")) {
        	return "index";
        }
        else {
        	   return "redirect:"+key;
        	
        }
       
       
	}


}
