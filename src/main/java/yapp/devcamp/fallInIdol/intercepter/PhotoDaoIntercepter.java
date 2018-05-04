package yapp.devcamp.fallInIdol.intercepter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;
import yapp.devcamp.fallInIdol.dao.ExoPhotoDao;
import yapp.devcamp.fallInIdol.dao.RevelPhotoDao;
import yapp.devcamp.fallInIdol.dao.TwicePhotoDao;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;

@Component
public class PhotoDaoIntercepter implements HandlerInterceptor {

	@Autowired
	BtsPhotoDao btsPhotoDao;
	
	@Autowired
	ExoPhotoDao exoPhotoDao;
	
	@Autowired
	RevelPhotoDao revelPhotoDao;
	
	@Autowired
	TwicePhotoDao twicePhotoDao;
	
	List<String> resultUrls = new ArrayList<String>();
	
	@Autowired
	GoogleCrawlService googleCrawlService;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String choice = request.getParameter("choice");
		if (choice.equals("bts")) {
			btsPhotoDao.deletePhoto();
			resultUrls = googleCrawlService.ImageCrawling("bts");
			btsPhotoDao.insertPhoto(resultUrls);
		}
		else if (choice.equals("redvelvet")) {
			revelPhotoDao.deletePhoto();
			resultUrls = googleCrawlService.ImageCrawling("redvelvet");
			revelPhotoDao.insertPhoto(resultUrls);
		}
		else if (choice.equals("exo")) {
			exoPhotoDao.deletePhoto();
			resultUrls = googleCrawlService.ImageCrawling("exo");
			exoPhotoDao.insertPhoto(resultUrls);
		}
		else {
			twicePhotoDao.deletePhoto();
			resultUrls = googleCrawlService.ImageCrawling("twice");
			twicePhotoDao.insertPhoto(resultUrls);
		}
		return false;
	}

}
