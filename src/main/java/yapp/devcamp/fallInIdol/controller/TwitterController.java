package yapp.devcamp.fallInIdol.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.Twitter.TwitterBot;
import yapp.devcamp.fallInIdol.Twitter.event.EventManager;
import yapp.devcamp.fallInIdol.Twitter.event.ExampleEventListener;

@Controller
public class TwitterController {
	@RequestMapping(value="/twit")
	public ModelAndView Twitter() {
		TwitterBot.twit();
		 ModelAndView mv = new ModelAndView();
         
	        List<String> listTest = new ArrayList<String>();
	        //listTest=ExampleEventListener.getList();
	         
	       for(int i=0;i<ExampleEventListener.getList().size();i++) {
	    	   listTest.add(ExampleEventListener.getList().get(i));
	    	   System.out.println(listTest.get(i));
	       }
	         
	        mv.addObject("listTest",listTest);     
	        mv.addObject("ObjectTest","테스트입니다.");
	        mv.setViewName("/TwitSample");         
	        return mv;                


	}
	
}


