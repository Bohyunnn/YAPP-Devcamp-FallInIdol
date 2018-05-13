package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.model.AlbumItem;
import yapp.devcamp.fallInIdol.service.AlbumCrawlService;

@EnableAutoConfiguration
@Controller
public class ProfileController {
	@Autowired
	AlbumCrawlService albumCrawlService;
	
	List<AlbumItem> albumList;
	
	@RequestMapping("/profile")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		albumList =new ArrayList<AlbumItem>();
		String choice = request.getParameter("choice"); 
		String menu = request.getParameter("menu");
		
		if (menu != null) {
			if (menu.equals("profile")) {
				albumList = albumCrawlService.AlbumCrawling(choice);
		        mv.addObject("album_result", albumList);
				
				mv.setViewName("/profile");
			}
		}
		
		mv.addObject("choice", choice);
		return mv;
	}
}
