package yapp.devcamp.fallInIdol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yapp.devcamp.fallInIdol.model.YouTubeItem;
import yapp.devcamp.fallInIdol.service.YouTubeApiService;


@EnableAutoConfiguration
@RestController
public class YoutubeController {

	@Autowired
	YouTubeApiService service;
	
	@RequestMapping(value="/youtube")
	public String youtube() {
		return "youtube";
	}
	
	/* http://localhost:8080/youtube-search?search="bts" 
	 * 
	 */
	@RequestMapping(value = { "/youtube-search" }, method = RequestMethod.GET)
	public @ResponseBody List<YouTubeItem> searchYouTube(@RequestParam(value = "search", required = true) String search,
			@RequestParam(value = "items", required = false, defaultValue = "25") String items) {

		int max = Integer.parseInt(items);
		List<YouTubeItem> result = service.youTubeSearch(search, max);
		return result;
	}
}
