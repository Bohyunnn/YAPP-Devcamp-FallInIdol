package yapp.devcamp.fallInIdol.controller;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;
import yapp.devcamp.fallInIdol.model.GooglePhotoItem;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;

@RestController
@EnableAutoConfiguration
public class GooglePhotoController {
	
	@Autowired
	GoogleCrawlService googleCrawlService;
	
	List<String> resultUrls = new ArrayList<String>();
	
	List<GooglePhotoItem> list = new ArrayList<GooglePhotoItem> ();
	
	@Autowired
	BtsPhotoDao btsPhotoDao;
	
	@RequestMapping("/google")
	public ModelAndView list() throws IOException {
//		resultUrls = googleCrawlService.firstCrawling("bts");
//		photoDao.insertPhoto(resultUrls);
		ModelAndView mv = new ModelAndView();
		list = btsPhotoDao.selectPhoto();
		mv.addObject("list", list);
		mv.setViewName("googlePhoto");
		return mv;
	}
}
