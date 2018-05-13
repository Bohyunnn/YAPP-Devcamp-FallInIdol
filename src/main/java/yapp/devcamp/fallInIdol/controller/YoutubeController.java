package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.model.YouTubeItem;
import yapp.devcamp.fallInIdol.service.YouTubeApiService;

@EnableAutoConfiguration
@Controller
public class YoutubeController {
	@Autowired
	YouTubeApiService youtubeService;
	
	@RequestMapping("/youtube")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();
		String choice = request.getParameter("choice"); 
		String select = request.getParameter("select");
		String menu = request.getParameter("menu");
		
		int max = Integer.parseInt(items);
		
		List<YouTubeItem> youtuberesult;
		
		if (menu != null) {
			if (menu.equals("youtube")) {
				if (choice != null && select != null) {
					youtuberesult = youtubeService.youTubeSearch(choice, select, max);
					mv.addObject("youtube", youtuberesult);
					mv.setViewName("/youtube");
				}
				if (choice != null && select == null)  {
					youtuberesult = youtubeService.youTubeSearch(choice, max);
					mv.addObject("youtube", youtuberesult);
					mv.setViewName("/youtube");
					
				}
			}
		}
		else {
			youtuberesult = youtubeService.youTubeSearch(choice, max);
			mv.addObject("youtube", youtuberesult);
		}
		mv.addObject("choice", choice);
		mv.addObject("select", select);
		return mv;
	}
	
		
}
