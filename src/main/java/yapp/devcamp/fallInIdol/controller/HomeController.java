package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;
import yapp.devcamp.fallInIdol.dao.ExoPhotoDao;
import yapp.devcamp.fallInIdol.dao.RevelPhotoDao;
import yapp.devcamp.fallInIdol.dao.TwicePhotoDao;
import yapp.devcamp.fallInIdol.model.AlbumItem;
import yapp.devcamp.fallInIdol.model.CalendarItem;
import yapp.devcamp.fallInIdol.model.GooglePhotoItem;
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
	AlbumCrawlService albumCrawlService;


	@Autowired
	BtsPhotoDao btsPhotoDao;

	@Autowired
	ExoPhotoDao exoPhotoDao;

	@Autowired
	RevelPhotoDao revelPhotoDao;

	@Autowired
	TwicePhotoDao twicePhotoDao;


	List<String> mainPhoto;

	List<CalendarItem> calendarList ;
	List<AlbumItem> albumList;

	List<TwitterItem> twitList;

	List<String> resultUrls;

	List<GooglePhotoItem> list = new ArrayList<GooglePhotoItem> ();
	
	
	@ModelAttribute("result") 
	public List<GooglePhotoItem> crawlingPhoto(@ModelAttribute("choice") String choice ) {
		 
		if (choice.equals("bts")) {
			list = btsPhotoDao.selectPhoto();	
		}
		else if (choice.equals("redvelvet")) {
			list = revelPhotoDao.selectPhoto();
		}
		else if (choice.equals("exo")) {
			list = exoPhotoDao.selectPhoto();
		}
		else {
			list = twicePhotoDao.selectPhoto();
		}

		for(Iterator<GooglePhotoItem> it = list.iterator() ; it.hasNext() ; )
		{
			String value = it.next().getUrl();

			if(value == null)
			{
				it.remove();
			}
		}

		return list;
	}
	
	@RequestMapping("/photoNoOption")
	public ModelAndView photoResponse(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("choice") String choice,
			@RequestParam("language") String lang)  {
		System.out.println("photo2 choice = " + choice);
		ModelAndView mv = new ModelAndView();

		mv.addObject("listNum", list.size());
		mv.addObject("choice", choice);
		mv.setViewName("/photo");
		mv.addObject("photo", "photo");
		setCookie(request,response);
		return mv;
	}


	
	@RequestMapping("/photo")
	public ModelAndView photoResponse(HttpServletRequest request,HttpServletResponse response,@RequestParam("language") String lang,
			@ModelAttribute("choice") String choice,@RequestParam("select") String select) throws IOException, JSONException  {
		System.out.println("photo3 choice = " + choice);
		ModelAndView mv = new ModelAndView();

		resultUrls = new ArrayList<String>();
		int num = 0;
		int i = 1;
		if (choice.equals("bts")) {
			if (select.equals("paparazzi")) {
				list = btsPhotoDao.paparazzi_url_Photo();
			} else if (select.equals("official")) {
				list = btsPhotoDao.official_url_Photo();
			} else if (select.equals("pictorial")) {
				list = btsPhotoDao.pictorial_url_Photo();
			} else if (select.equals("uhd")) {
				list = btsPhotoDao.uhd_url_Photo();
			} else {
				list = btsPhotoDao.airport_url_Photo();
			}

			for (GooglePhotoItem imageUrl : list) {
				if (imageUrl.getUrl() != null) {
					num = i;
					break;
				}
				i++;
			}
			if (num == 0) {
				resultUrls = googleCrawlService.ImageCrawling(choice, select);
				if (select.equals("paparazzi")) {
					btsPhotoDao.insert_paparazzi_Photo(resultUrls);
					list = btsPhotoDao.paparazzi_url_Photo();
				} else if (select.equals("official")) {
					btsPhotoDao.insert_official_Photo(resultUrls);
					list = btsPhotoDao.official_url_Photo();
				} else if (select.equals("pictorial")) {
					btsPhotoDao.insert_pictorial_Photo(resultUrls);
					list = btsPhotoDao.pictorial_url_Photo();
				} else if (select.equals("uhd")) {
					btsPhotoDao.insert_uhd_Photo(resultUrls);
					list = btsPhotoDao.uhd_url_Photo();
				} else {
					btsPhotoDao.insert_airport_Photo(resultUrls);
					list = btsPhotoDao.airport_url_Photo();
				}
			}	
		}
		else if (choice.equals("redvelvet")) {
			if (select.equals("paparazzi")) {
				list = revelPhotoDao.paparazzi_url_Photo();
			} else if (select.equals("official")) {
				list = revelPhotoDao.official_url_Photo();
			} else if (select.equals("pictorial")) {
				list = revelPhotoDao.pictorial_url_Photo();
			} else if (select.equals("uhd")) {
				list = revelPhotoDao.uhd_url_Photo();
			} else {
				list = revelPhotoDao.airport_url_Photo();
			}

			i = 1;
			for (GooglePhotoItem imageUrl : list) {
				if (imageUrl.getUrl() != null) {
					num = i;
					break;
				}
				i++;
			}
			if (num == 0) {
				resultUrls = googleCrawlService.ImageCrawling(choice, select);
				if (select.equals("paparazzi")) {
					revelPhotoDao.insert_paparazzi_Photo(resultUrls);
					list = revelPhotoDao.paparazzi_url_Photo();
				} else if (select.equals("official")) {
					revelPhotoDao.insert_official_Photo(resultUrls);
					list = revelPhotoDao.official_url_Photo();
				} else if (select.equals("pictorial")) {
					revelPhotoDao.insert_pictorial_Photo(resultUrls);
					list = revelPhotoDao.pictorial_url_Photo();
				} else if (select.equals("uhd")) {
					revelPhotoDao.insert_uhd_Photo(resultUrls);
					list = revelPhotoDao.uhd_url_Photo();
				} else {
					revelPhotoDao.insert_airport_Photo(resultUrls);
					list = revelPhotoDao.airport_url_Photo();
				}
			}	
		}
		else if (choice.equals("exo")) {
			if (select.equals("paparazzi")) {
				list = exoPhotoDao.paparazzi_url_Photo();
			} else if (select.equals("official")) {
				list = exoPhotoDao.official_url_Photo();
			} else if (select.equals("pictorial")) {
				list = exoPhotoDao.pictorial_url_Photo();
			} else if (select.equals("uhd")) {
				list = exoPhotoDao.uhd_url_Photo();
			} else {
				list = exoPhotoDao.airport_url_Photo();
			}

			i = 1;
			for (GooglePhotoItem imageUrl : list) {
				if (imageUrl.getUrl() != null) {
					num = i;
					break;
				}
				i++;
			}
			if (num == 0) {
				resultUrls = googleCrawlService.ImageCrawling(choice, select);
				if (select.equals("paparazzi")) {
					exoPhotoDao.insert_paparazzi_Photo(resultUrls);
					list = exoPhotoDao.paparazzi_url_Photo();
				} else if (select.equals("official")) {
					exoPhotoDao.insert_official_Photo(resultUrls);
					list = exoPhotoDao.official_url_Photo();
				} else if (select.equals("pictorial")) {
					exoPhotoDao.insert_pictorial_Photo(resultUrls);
					list = exoPhotoDao.pictorial_url_Photo();
				} else if (select.equals("uhd")) {
					exoPhotoDao.insert_uhd_Photo(resultUrls);
					list = exoPhotoDao.uhd_url_Photo();
				} else {
					exoPhotoDao.insert_airport_Photo(resultUrls);
					list = exoPhotoDao.airport_url_Photo();
				}
			}	
		}
		else {
			if (select.equals("paparazzi")) {
				list = twicePhotoDao.paparazzi_url_Photo();
			} else if (select.equals("official")) {
				list = twicePhotoDao.official_url_Photo();
			} else if (select.equals("pictorial")) {
				list = twicePhotoDao.pictorial_url_Photo();
			} else if (select.equals("uhd")) {
				list = twicePhotoDao.uhd_url_Photo();
			} else {
				list = twicePhotoDao.airport_url_Photo();
			}

			i = 1;
			for (GooglePhotoItem imageUrl : list) {
				if (imageUrl.getUrl() != null) {
					num = i;
					break;
				}
				i++;
			}
			if (num == 0) {
				resultUrls = googleCrawlService.ImageCrawling(choice, select);
				if (select.equals("paparazzi")) {
					twicePhotoDao.insert_paparazzi_Photo(resultUrls);
					list = twicePhotoDao.paparazzi_url_Photo();
				} else if (select.equals("official")) {
					twicePhotoDao.insert_official_Photo(resultUrls);
					list = twicePhotoDao.official_url_Photo();
				} else if (select.equals("pictorial")) {
					twicePhotoDao.insert_pictorial_Photo(resultUrls);
					list = twicePhotoDao.pictorial_url_Photo();
				} else if (select.equals("uhd")) {
					twicePhotoDao.insert_uhd_Photo(resultUrls);
					list = twicePhotoDao.uhd_url_Photo();
				} else {
					twicePhotoDao.insert_airport_Photo(resultUrls);
					list = twicePhotoDao.airport_url_Photo();
				}
			}	
		}
		for(Iterator<GooglePhotoItem> it = list.iterator() ; it.hasNext() ; )
		{
			String value = it.next().getUrl();

			if(value == null)
			{
				it.remove();
			}
		}

		mv.addObject("result", list);
		mv.addObject("listNum", list.size());
		mv.addObject("choice", choice);
		mv.addObject("select", select);
		mv.addObject("photo", "photo");
		
		setCookie(request,response);

		return mv;
	}

	@ModelAttribute("calendarList") 
	public List<CalendarItem> scheduleService(@ModelAttribute("choice") String choice) throws IOException {
		System.out.println("schedule choice = " + choice);
		calendarList = googleCalendarService.CalendarCrawling(choice);

		//		for(CalendarItem content : calendarList) {
		//			System.out.println(content.getContent());
		//		}
		return calendarList;
	}

	@ModelAttribute("languagelist")
	public List<String> languageList() {
		List<String> languagelist = new ArrayList<String>(); //공통속성 
		
		languagelist.add("한국어");
		languagelist.add("ENGLISH");		
		languagelist.add("日本語");
		languagelist.add("简体中文");
		languagelist.add("繁體中文");
		languagelist.add("ภาษาไทย");
		languagelist.add("русский");
		
	
		return languagelist;
	}

	@ModelAttribute("mainPhoto")
	public List<String> mainPhotoList(@ModelAttribute("choice") String choice) {
		System.out.println("mainphoto choice = " + choice);
		mainPhoto = new ArrayList<String>();
		mainPhoto = carouselImageService.getCarouselImage(choice); //공통속성 
		Collections.shuffle(mainPhoto); 

		return mainPhoto;
	}

	@RequestMapping("/twitter")
	public ModelAndView twitterResponse(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("choice") String choice,@RequestParam("language") String lang) throws IOException  {
		System.out.println("twitter choice = " + choice);
		System.out.println("twitter language = " + lang);
		ModelAndView mv = new ModelAndView();

		
		twitList = twitterCrawlService.TwitterCrawling(choice,lang);
		mv.addObject("twit_result", twitList);
		mv.setViewName("/twitter");
		
		mv.addObject("choice", choice);
		mv.addObject("lang", lang);
		mv.setViewName("/twitter");
		setCookie(request,response);
		return mv;
	}

	
	@RequestMapping("/feed")
	public ModelAndView feedResponse(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("choice") String choice,@RequestParam("language") String lang,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException  {
		System.out.println("feed choice = " + choice);
		ModelAndView mv = new ModelAndView();
		
		
		List<YouTubeItem> youtuberesult;
		int max = Integer.parseInt(items);
		youtuberesult = youtubeService.youTubeSearch(choice, max);
		mv.addObject("youtube", youtuberesult);
		
		twitList = twitterCrawlService.TwitterCrawling(choice,lang);
		mv.addObject("twit_result", twitList);
		
		
		mv.addObject("listNum", list.size());
		mv.addObject("photo", "photo");
		mv.addObject("choice", choice);
		mv.addObject("lang", lang);
		mv.setViewName("/feed");
		setCookie(request,response);
		return mv;
	}
	
	@RequestMapping("/youtube")
	public ModelAndView youtubeResponse(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("choice") String choice,@RequestParam("language") String lang,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException  {
		String select = request.getParameter("select");
		
		System.out.println("youtube choice = " + choice);
		System.out.println("youtube select = " + select);
		
		ModelAndView mv = new ModelAndView();
		
		
		List<YouTubeItem> youtuberesult;
		int max = Integer.parseInt(items);
		
		
			
		if (choice != null && select != null) {
			youtuberesult = youtubeService.youTubeSearch(choice, select, max);
			mv.addObject("youtube", youtuberesult);
			mv.setViewName("/youtube");
		}
		else if (choice != null && select == null)  {
			youtuberesult = youtubeService.youTubeSearch(choice, max);
			mv.addObject("youtube", youtuberesult);
			mv.setViewName("/youtube");
		}
			
			
		mv.addObject("lang", lang);
		mv.addObject("choice", choice);
		mv.addObject("select", select);

		setCookie(request,response);
		
		return mv;
	}
	
	
	
	
	@RequestMapping("/profile")
	public ModelAndView sendResult(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("choice") String choice,@RequestParam("language") String lang,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();

		albumList =new ArrayList<AlbumItem>();

		albumList = albumCrawlService.AlbumCrawling(choice);
		mv.addObject("album_result", albumList);

		
		mv.setViewName("/profile");
		
		mv.addObject("lang", lang);
		mv.addObject("choice", choice);

		setCookie(request,response);
		
		return mv;
	}
	
	
	public void setCookie(HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie = new Cookie("star", getURL(request));
	    //1년으로 설정
		cookie.setMaxAge(365*24*60*60);
		cookie.setPath("/");
	    response.addCookie(cookie);
	}
	
	public String getURL(HttpServletRequest request)
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