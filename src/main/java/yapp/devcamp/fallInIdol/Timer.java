package yapp.devcamp.fallInIdol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestParam;

import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;
import yapp.devcamp.fallInIdol.dao.ExoPhotoDao;
import yapp.devcamp.fallInIdol.dao.RevelPhotoDao;
import yapp.devcamp.fallInIdol.dao.TwicePhotoDao;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;

@Component
public class Timer {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private AtomicInteger loopCounter = new AtomicInteger();
	
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
	private StopWatch watch;
	
	@Value("${spring.task.name}")
	private String taskNamePrefix;
	
	@Autowired
	GoogleCrawlService googleCrawlService;
	
	@PostConstruct
	public void init() {
		watch.start();
	}
	
	@Scheduled(fixedDelayString = "${spring.task.fixedDelay}")
	public void tick() throws InterruptedException, IOException, JSONException {
		watch.stop();
		logger.info(watch.prettyPrint());
		String taskName = taskNamePrefix + "-" + String.valueOf(loopCounter.getAndIncrement());
		
//		btsPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("bts");
		btsPhotoDao.insertPhoto(resultUrls);
		
//		exoPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("exo");
		exoPhotoDao.insertPhoto(resultUrls);
		
//		revelPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("redvelvet");
		revelPhotoDao.insertPhoto(resultUrls);
		
//		twicePhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("twice");
		twicePhotoDao.insertPhoto(resultUrls);
		
		watch.start();
	}
	
	//매일 12시에 db 내용 삭제하고 다시 삽입함.
	@Scheduled(cron = "0 0 12 * * *")
	public void taskPerDay() throws InterruptedException, IOException, JSONException {
		watch.stop();
		logger.info(watch.prettyPrint());
		String taskName = taskNamePrefix + "-" + String.valueOf(loopCounter.getAndIncrement());
		
		btsPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("bts");
		btsPhotoDao.insertPhoto(resultUrls);
		
		exoPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("exo");
		exoPhotoDao.insertPhoto(resultUrls);
		
		revelPhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("redvelvet");
		revelPhotoDao.insertPhoto(resultUrls);
		
		twicePhotoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("twice");
		twicePhotoDao.insertPhoto(resultUrls);
		
		watch.start();
	}
	
	@Bean
	public StopWatch watch() {
		return new StopWatch();
	}
}
