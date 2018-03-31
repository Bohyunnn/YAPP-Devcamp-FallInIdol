package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.model.CalendarItem;
import yapp.devcamp.fallInIdol.model.TwitterItem;
import yapp.devcamp.fallInIdol.model.YouTubeItem;
import yapp.devcamp.fallInIdol.service.CarouselImageService;
import yapp.devcamp.fallInIdol.service.GoogleCalendarService;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;
import yapp.devcamp.fallInIdol.service.GoogleTranslateService;
import yapp.devcamp.fallInIdol.service.TwitterCrawlService;
import yapp.devcamp.fallInIdol.service.YouTubeApiService;

@EnableAutoConfiguration
@Controller
public class HomeController {

	@Autowired
	YouTubeApiService youtubeService;

	@Autowired
	GoogleCrawlService googleCrawlService;

	@Autowired
	TwitterCrawlService twitterCrawlService;
	
	@Autowired
	CarouselImageService carouselImageService;
	
	@Autowired
	GoogleTranslateService googleTranslateService;
	
	@Autowired
	GoogleCalendarService googleCalendarService;
	
	List<String> resultUrls = new ArrayList<String>();
	List<String> mainPhoto = new ArrayList<String>();
	List<TwitterItem> twitUrls =new ArrayList<TwitterItem>();
	List<CalendarItem> calendarList =new ArrayList<CalendarItem>();
	
	List<String> twitterImage=new ArrayList<String>();
	
	@GetMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();


		String choice = request.getParameter("choice");
		String select = request.getParameter("select");

		int max = Integer.parseInt(items);

		// mainCarousel 지정
		
		mainPhoto = carouselImageService.getCarouselImage(choice);

		List<YouTubeItem> youtuberesult = youtubeService.youTubeSearch(choice, max);

		
		
		if (choice != null && select != null) {

			youtuberesult = youtubeService.youTubeSearch(choice, select, max);
			mv.addObject("youtube", youtuberesult);

			resultUrls = googleCrawlService.ImageCrawling(choice, select);
			mv.addObject("result", resultUrls);
			
			twitUrls = twitterCrawlService.TwitterCrawling(choice);
			mv.addObject("twit_result", twitUrls);

			calendarList = googleCalendarService.CalendarCrawling(choice);
			mv.addObject("calendar_result", calendarList);
			
			mv.setViewName("/home");

		} else if (choice != null && select == null) {
			
			youtuberesult = youtubeService.youTubeSearch(choice, max);
			mv.addObject("youtube", youtuberesult);

			resultUrls = googleCrawlService.firstCrawling(choice);
			mv.addObject("result", resultUrls);
			
			twitUrls = twitterCrawlService.TwitterCrawling(choice);
			mv.addObject("twit_result", twitUrls);
			
			calendarList = googleCalendarService.CalendarCrawling(choice);
			mv.addObject("calendar_result", calendarList);

			mv.setViewName("/home?choice=" + choice);
		}
		
		/*
		for(int i=0;i<twitUrls.size();i++){
			System.out.println("*****"+twitUrls.get(i).getContent());
			System.out.println("-----"+googleTranslateService.trnaslate(twitUrls.get(i).getContent()));
			//System.out.println("*****"+twitUrls.get(i).getDate());
			//System.out.println("*****"+twitUrls.get(i).getImage());
		}
		*/
		for(int i=0;i<twitUrls.size();i++){
			//System.out.println("*****"+twitUrls.get(i).getContent());
			//System.out.println("-----"+googleTranslateService.trnaslate(twitUrls.get(i).getContent()));
			twitterImage.add(twitUrls.get(i).getImage());
			//System.out.println("*****"+twitUrls.get(i).getDate());
			//System.out.println("*****"+twitUrls.get(i).getImage());
		}
		
		
		
		mv.addObject("mainPhoto", mainPhoto);
		mv.addObject("youtube", youtuberesult);
		mv.addObject("result", resultUrls);
		mv.addObject("twit_result", twitterImage);
		mv.addObject("choice", choice);
		
		mv.setViewName("/home");

		return mv;
	}

}