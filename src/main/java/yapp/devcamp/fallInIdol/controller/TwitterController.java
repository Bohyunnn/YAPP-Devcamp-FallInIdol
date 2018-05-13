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

import yapp.devcamp.fallInIdol.model.TwitterItem;
import yapp.devcamp.fallInIdol.service.TwitterCrawlService;

@EnableAutoConfiguration
@Controller
public class TwitterController {
	@Autowired
	TwitterCrawlService twitterCrawlService;

	List<TwitterItem> twitUrls;
	List<String> twitterImage;

	@RequestMapping("/twitter")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();

		String choice = request.getParameter("choice"); 
		String menu = request.getParameter("menu");

		if (menu != null) {
			if (menu.equals("twitter")) {
				twitUrls = twitterCrawlService.TwitterCrawling(choice);
				mv.addObject("twit_result", twitUrls);
				mv.setViewName("/twitter");
			}
		}
		else {
			twitUrls = twitterCrawlService.TwitterCrawling(choice);
			mv.addObject("twit_result", twitUrls);
		}
		mv.addObject("choice", choice);
		mv.addObject("twit_result", twitUrls);
		return mv;
	}
}
