package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.model.AlbumItem;
import yapp.devcamp.fallInIdol.model.CalendarItem;
import yapp.devcamp.fallInIdol.model.TwitterItem;
import yapp.devcamp.fallInIdol.model.YouTubeItem;
import yapp.devcamp.fallInIdol.service.CarouselImageService;
import yapp.devcamp.fallInIdol.service.GoogleCalendarService;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;
import yapp.devcamp.fallInIdol.service.GoogleTranslateService;
import yapp.devcamp.fallInIdol.service.TwitterCrawlService;
import yapp.devcamp.fallInIdol.service.YouTubeApiService;
import yapp.devcamp.fallInIdol.service.AlbumCrawlService;

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
	
	@Autowired
	AlbumCrawlService AlbumCrawlService;
	
	
	
	
	@GetMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		List<String> resultUrls = new ArrayList<String>();
		List<String> mainPhoto = new ArrayList<String>();
		List<TwitterItem> twitList =new ArrayList<TwitterItem>();
		List<CalendarItem> calendarList =new ArrayList<CalendarItem>();	
		List<AlbumItem> albumList=new ArrayList<AlbumItem>();	

		String choice = request.getParameter("choice");
		String language = request.getParameter("language");
		String select = request.getParameter("select");
		String menu = request.getParameter("menu");
		
		int max = Integer.parseInt(items);

		// mainCarousel 지정
		
		mainPhoto = carouselImageService.getCarouselImage(choice);

		List<YouTubeItem> youtuberesult = youtubeService.youTubeSearch(choice, max);

		
		if (menu != null) {
			if(menu.equals("feed")) {
				if (choice != null && select != null) {
					youtuberesult = youtubeService.youTubeSearch(choice, select, max);
					mv.addObject("youtube", youtuberesult);					
					twitList = twitterCrawlService.TwitterCrawling(choice,language);
					mv.addObject("twit_result", twitList);
					resultUrls = googleCrawlService.ImageCrawling(choice, select);
					mv.addObject("result", resultUrls);
					mv.setViewName("/feed");
				}
				if (choice != null && select == null)  {
					youtuberesult = youtubeService.youTubeSearch(choice, max);
					mv.addObject("youtube", youtuberesult);
					twitList = twitterCrawlService.TwitterCrawling(choice,language);
					mv.addObject("twit_result", twitList);
					resultUrls = googleCrawlService.firstCrawling(choice);
					mv.addObject("result", resultUrls);
					mv.setViewName("/feed");
					
				}
				
			}
			
			else if (menu.equals("profile")) {
				if (choice != null && select != null) {
					albumList = AlbumCrawlService.AlbumCrawling(choice);;
					mv.addObject("album_result", albumList);
					mv.setViewName("/profile");
				}
				if (choice != null && select == null)  {
					albumList = AlbumCrawlService.AlbumCrawling(choice);
					mv.addObject("album_result", albumList);
					mv.setViewName("/profile");
					
				}
			}
			else if (menu.equals("twitter")) {				
				if (choice != null && select != null) {				
						twitList = twitterCrawlService.TwitterCrawling(choice,language);
						mv.addObject("twit_result", twitList);
						mv.setViewName("/twitter");					
					
				}
				else if (choice != null && select == null)  {			
					
						twitList = twitterCrawlService.TwitterCrawling(choice,language);
						mv.addObject("twit_result", twitList);
						mv.setViewName("/twitter");
					
				}
				
			}
			else if (menu.equals("youtube")) {
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
			
		}
		else {
				youtuberesult = youtubeService.youTubeSearch(choice, max);
				mv.addObject("youtube", youtuberesult);
				
				resultUrls = googleCrawlService.firstCrawling(choice);
				mv.addObject("result", resultUrls);
				
				
		}
		calendarList = googleCalendarService.CalendarCrawling(choice);
		mv.addObject("calendar_result", calendarList);
		
		
		System.out.println("@@@@@@@@@@@@@"+getURL(request));

	    Cookie newCookie = new Cookie("testCookie", getURL(request));
	    newCookie.setMaxAge(24 * 60 * 60);
	    newCookie.setPath("/");
	    response.addCookie(newCookie);
		
		
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
		
		
		List<String> languagelist= new ArrayList<String>();
		languagelist.add("english");
		languagelist.add("chinese");
		languagelist.add("japanese");
	
				
		
		mv.addObject("choicelist", choicelist);
		mv.addObject("languagelist", languagelist);
		mv.addObject("mainPhoto", mainPhoto);
		
		mv.addObject("choice", choice);
		mv.addObject("language", language);
		
		mv.addObject("msg", "test method msg");

		return mv;
	}

	//현재의 url 경로를 가져오는 함수	
	public static String getURL(HttpServletRequest request)
	  {
	    Enumeration<?> param = request.getParameterNames();

	    StringBuffer strParam = new StringBuffer();
	    StringBuffer strURL = new StringBuffer();

	    if (param.hasMoreElements())
	    {
	      strParam.append("?");
	    }

	    while (param.hasMoreElements())
	    {
	      String name = (String) param.nextElement();
	      String value = request.getParameter(name);

	      strParam.append(name + "=" + value);

	      if (param.hasMoreElements())
	      {
	        strParam.append("&");
	      }
	  }

	  strURL.append(request.getRequestURI());
	  strURL.append(strParam);

	  return strURL.toString();
	}
	
}

