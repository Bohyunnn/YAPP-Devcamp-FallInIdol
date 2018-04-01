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
		String menu = request.getParameter("menu");
		
		int max = Integer.parseInt(items);

		// mainCarousel 지정
		
		mainPhoto = carouselImageService.getCarouselImage(choice);

		List<YouTubeItem> youtuberesult = youtubeService.youTubeSearch(choice, max);
		
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
			else if (menu.equals("photo")) {
				if (choice != null && select != null) {
					resultUrls = googleCrawlService.ImageCrawling(choice, select);
					mv.addObject("result", resultUrls);
					mv.setViewName("/photo");
				}
				if (choice != null && select == null)  {
					resultUrls = googleCrawlService.firstCrawling(choice);
					mv.addObject("result", resultUrls);
					mv.setViewName("/photo");
				}
			}
			else if (menu.equals("twitter")) {
					twitUrls = twitterCrawlService.TwitterCrawling(choice);
					mv.addObject("twit_result", twitUrls);
					mv.setViewName("/twitter");
			}
		}
		else {
				youtuberesult = youtubeService.youTubeSearch(choice, max);
				mv.addObject("youtube", youtuberesult);
				twitUrls = twitterCrawlService.TwitterCrawling(choice);
				mv.addObject("twit_result", twitUrls);

				resultUrls = googleCrawlService.firstCrawling(choice);
				mv.addObject("result", resultUrls);
		}
		calendarList = googleCalendarService.CalendarCrawling(choice);
		mv.addObject("calendar_result", calendarList);
		
		
		List<String> choicelist = new ArrayList<String>();
		choicelist.add("bts");
		choicelist.add("redvelvet");
		choicelist.add("exo");
		choicelist.add("twice");
		if (choice.equals( "redvelvet") ) {
			choicelist.remove(1);
		}
		else if(choice.equals("bts")) {
			choicelist.remove(0);
		}
		else if(choice.equals( "exo")) {
			choicelist.remove(2);
		}
		else{
			choicelist.remove(3);
		}
		
		for(int i=0;i<twitUrls.size();i++){
			//System.out.println("*****"+twitUrls.get(i).getContent());
			//System.out.println("-----"+googleTranslateService.trnaslate(twitUrls.get(i).getContent()));
			twitterImage.add(twitUrls.get(i).getImage());
			//System.out.println("*****"+twitUrls.get(i).getDate());
			//System.out.println("*****"+twitUrls.get(i).getImage());
		}
		
		 for (CalendarItem imageUrl : calendarList) {
					 System.out.println(imageUrl.getContent());
					 }

		mv.addObject("choicelist", choicelist);
		mv.addObject("mainPhoto", mainPhoto);
//		mv.addObject("youtube", youtuberesult);
//		mv.addObject("result", resultUrls);
		mv.addObject("choice", choice);
		mv.addObject("twit_result", twitterImage);
//		mv.setViewName("/home");

		return mv;
	}

}