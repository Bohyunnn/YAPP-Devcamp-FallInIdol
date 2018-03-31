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

import yapp.devcamp.fallInIdol.model.YouTubeItem;
import yapp.devcamp.fallInIdol.service.CarouselImageService;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;
import yapp.devcamp.fallInIdol.service.YouTubeApiService;

@EnableAutoConfiguration
@Controller
public class HomeController {

	@Autowired
	YouTubeApiService youtubeService;

	@Autowired
	GoogleCrawlService googleCrawlService;

	@Autowired
	CarouselImageService carouselImageService;

	@GetMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request,
			@RequestParam(value = "items", required = false, defaultValue = "26") String items) throws IOException {
		ModelAndView mv = new ModelAndView();

		List<String> resultUrls = new ArrayList<String>();

		String choice = request.getParameter("choice");
		String select = request.getParameter("select");

		int max = Integer.parseInt(items);

		// mainCarousel 지정
		List<String> mainPhoto = new ArrayList<String>();
		mainPhoto = carouselImageService.getCarouselImage(choice);

		List<YouTubeItem> youtuberesult = youtubeService.youTubeSearch(choice, max);

		if (choice != null && select != null) {

			youtuberesult = youtubeService.youTubeSearch(choice, select, max);
			mv.addObject("youtube", youtuberesult);

			resultUrls = googleCrawlService.ImageCrawling(choice, select);
			mv.addObject("result", resultUrls);

			mv.setViewName("/home");

		} else if (choice != null && select == null) {
			youtuberesult = youtubeService.youTubeSearch(choice, max);
			mv.addObject("youtube", youtuberesult);

			resultUrls = googleCrawlService.firstCrawling(choice);
			mv.addObject("result", resultUrls);

			mv.setViewName("/home?choice=" + choice);
		}
		
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
		for (int i = 0; i < 3; i++) {
			System.out.println(choicelist.get(i));
		}
		mv.addObject("choicelist", choicelist);
		mv.addObject("mainPhoto", mainPhoto);
		mv.addObject("youtube", youtuberesult);
		mv.addObject("result", resultUrls);
		mv.addObject("choice", choice);
		mv.setViewName("/home");

		return mv;
	}

}