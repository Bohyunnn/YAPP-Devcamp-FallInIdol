package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	List<TwitterItem> twitUrls;
	List<String> twitterImage;


	//	@ModelAttribute("names")
	//	public List<String> memberName(@RequestParam("choice") String choice) {
	//		List<String> names = new ArrayList<String> ();
	//		if (choice.equals("bts")) {
	//			names.add("bts");
	//			names.add("v");
	//			names.add("sugar");
	//			names.add("jin");
	//			names.add("jimin");
	//			names.add("jungkook");
	//			names.add("rm");
	//			names.add("j-hope");
	//		}
	//		else if (choice.equals("redvelvet")) {
	//			names.add("redvelvet");
	//			names.add("joy");
	//			names.add("irene");
	//			names.add("wendy");
	//			names.add("seulgi");
	//			names.add("yeri");
	//		}
	//		else if (choice.equals("exo")) {
	//			names.add("exo");
	//			names.add("XIUMIN");
	//			names.add("LUHAN");
	//			names.add("KRIS");
	//			names.add("LAY");
	//			names.add("SUHO");
	//			names.add("BAEKHYUN");
	//			names.add("CHANYEOL");
	//			names.add("CHEN");
	//			names.add("D.O.");
	//			names.add("TAO");
	//			names.add("KAI");
	//			names.add("SEHUN");
	//		}
	//		else {
	//			names.add("twice");
	//			names.add("momo");
	//			names.add("nayeon");
	//			names.add("dahyun");
	//			names.add("Tzuyu");
	//			names.add("mina");
	//			names.add("jungyeon");
	//			names.add("sana");
	//			names.add("jihyo");
	//			names.add("chaeyong");
	//		}
	//		return names;
	//	}

	List<String> resultUrls;

	List<GooglePhotoItem> list = new ArrayList<GooglePhotoItem> ();

	@ModelAttribute("result") 
	public List<GooglePhotoItem> crawlingPhoto(@RequestParam("choice") String choice) {


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
	public ModelAndView photoResponse(@RequestParam("choice") String choice)  {
		ModelAndView mv = new ModelAndView();

		mv.addObject("listNum", list.size());
		mv.addObject("choice", choice);
		mv.setViewName("/photo");

		return mv;
	}

	@RequestMapping("/photo")
	public ModelAndView photoResponse(@RequestParam("choice") String choice, @RequestParam("select") String select) throws IOException, JSONException  {
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

		return mv;
	}

	@ModelAttribute("calendarList") 
	public List<CalendarItem> scheduleService(@RequestParam("choice") String choice) throws IOException {
		calendarList = googleCalendarService.CalendarCrawling(choice);

		//		for(CalendarItem content : calendarList) {
		//			System.out.println(content.getContent());
		//		}
		return calendarList;
	}

	@ModelAttribute("language")
	public List<String> languageList() {
		List<String> language = new ArrayList<String>(); //공통속성 
		language.add("ENGLISH");
		language.add("中文");
		language.add("日本語");
		language.add("한국어");

		return language;
	}

	@ModelAttribute("mainPhoto")
	public List<String> languageList(@RequestParam("choice") String choice) {
		mainPhoto = new ArrayList<String>();
		mainPhoto = carouselImageService.getCarouselImage(choice); //공통속성 
		Collections.shuffle(mainPhoto); 

		return mainPhoto;
	}



	@RequestMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();

		albumList =new ArrayList<AlbumItem>();
		twitUrls =new ArrayList<TwitterItem>();
		twitterImage=new ArrayList<String>();

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
			else if (menu.equals("twitter")) {
				twitUrls = twitterCrawlService.TwitterCrawling(choice);
				mv.addObject("twit_result", twitUrls);
				mv.setViewName("/twitter");
			}
			else if (menu.equals("profile")) {
				albumList = albumCrawlService.AlbumCrawling(choice);
				mv.addObject("album_result", albumList);

				mv.setViewName("/profile");
			}
		}
		else {
			youtuberesult = youtubeService.youTubeSearch(choice, max);
			mv.addObject("youtube", youtuberesult);
			twitUrls = twitterCrawlService.TwitterCrawling(choice);
			mv.addObject("twit_result", twitUrls);
		}

		//		List<String> choicelist = new ArrayList<String>();
		//		choicelist.add("bts");
		//		choicelist.add("redvelvet");
		//		choicelist.add("exo");
		//		choicelist.add("twice");
		//		if (choice.equals( "redvelvet") ) {
		//			choicelist.remove(1);
		//		}
		//		else if(choice.equals("bts")) {
		//			choicelist.remove(0);
		//		}
		//		else if(choice.equals( "exo")) {
		//			choicelist.remove(2);
		//		}
		//		else{
		//			choicelist.remove(3);
		//		}


		//		List<String> language = new ArrayList<String>(); //공통속성 
		//		language.add("ENGLISH");
		//		language.add("中文");
		//		language.add("日本語");
		//		language.add("한국어");
		//		
		//
		//		mv.addObject("language", language);
		//		mv.addObject("mainPhoto", mainPhoto);
		mv.addObject("choice", choice);
		mv.addObject("select", select);
		mv.addObject("twit_result", twitUrls);

		return mv;
	}

}