package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	List<String> resultUrls;
	List<String> mainPhoto;

	List<CalendarItem> calendarList ;
	List<AlbumItem> albumList;
	
	List<TwitterItem> twitUrls;
	List<String> twitterImage;
	
	List<GooglePhotoItem> list = new ArrayList<GooglePhotoItem> ();

	@ModelAttribute("names")
	public List<String> memberName(@RequestParam("choice") String choice) {
		List<String> names = new ArrayList<String> ();
		if (choice.equals("bts")) {
			names.add("BTS");
			names.add("V");
			names.add("SUGAR");
			names.add("JIN");
			names.add("JIMIN");
			names.add("JUNGKOOK");
			names.add("RM");
			names.add("J-HOPE");
		}
		else if (choice.equals("redvelvet")) {
			names.add("REDVELVET");
			names.add("JOY");
			names.add("IRENE");
			names.add("WENDY");
			names.add("SEULGI");
			names.add("YERI");
		}
		return names;
	}
	
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
	
	@GetMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		resultUrls = new ArrayList<String>();
		mainPhoto = new ArrayList<String>();
		calendarList = new ArrayList<CalendarItem>();
		albumList =new ArrayList<AlbumItem>();
		twitUrls =new ArrayList<TwitterItem>();
		twitterImage=new ArrayList<String>();
		
		String choice = request.getParameter("choice");
		String select = request.getParameter("select");
		String menu = request.getParameter("menu");
		
		int max = Integer.parseInt(items);

		// mainCarousel 지정
		
		mainPhoto = carouselImageService.getCarouselImage(choice);

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
			if (menu.equals("photo")) {
				if (choice != null && select != null) {
					if (choice.equals("bts")) {
						list = btsPhotoDao.select1_url_Photo();
					
						GooglePhotoItem imageUrl = list.get(0);
						if (imageUrl.getUrl() == null) {
							resultUrls = googleCrawlService.ImageCrawling(choice, select);
							btsPhotoDao.insert_select1_Photo(resultUrls);
							list =  btsPhotoDao.select1_url_Photo();
						}	
					}
					else if (choice.equals("redvelvet")) {
						list = btsPhotoDao.select1_url_Photo();
						
						GooglePhotoItem imageUrl = list.get(0);
						if (imageUrl.getUrl() == null) {
							resultUrls = googleCrawlService.ImageCrawling(choice, select);
							btsPhotoDao.insert_select1_Photo(resultUrls);
							list =  btsPhotoDao.select1_url_Photo();
						}	
					}
					else if (choice.equals("exo")) {
						list = btsPhotoDao.select1_url_Photo();
						
						GooglePhotoItem imageUrl = list.get(0);
						if (imageUrl.getUrl() == null) {
							resultUrls = googleCrawlService.ImageCrawling(choice, select);
							btsPhotoDao.insert_select1_Photo(resultUrls);
							list =  btsPhotoDao.select1_url_Photo();
						}	
					}
					else {
						list = btsPhotoDao.select1_url_Photo();
						
						GooglePhotoItem imageUrl = list.get(0);
						if (imageUrl.getUrl() == null) {
							resultUrls = googleCrawlService.ImageCrawling(choice, select);
							btsPhotoDao.insert_select1_Photo(resultUrls);
							list =  btsPhotoDao.select1_url_Photo();
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
					mv.setViewName("/photo");
				}
				if (choice != null && select == null) {
					mv.addObject("listNum", list.size());
					mv.setViewName("/photo");
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
//			twitterImage.add(twitUrls.get(i).getImage());
			//System.out.println("*****"+twitUrls.get(i).getDate());
			//System.out.println("*****"+twitUrls.get(i).getImage());
		}
		
		mv.addObject("choicelist", choicelist);
		mv.addObject("mainPhoto", mainPhoto);
		mv.addObject("choice", choice);
		mv.addObject("twit_result", twitUrls);


		return mv;
	}

}