package yapp.devcamp.fallInIdol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;
import yapp.devcamp.fallInIdol.service.GoogleCrawlService;

@Component
public class Timer {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private AtomicInteger loopCounter = new AtomicInteger();
	
	@Autowired
	BtsPhotoDao photoDao;
	
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
	public void tick() throws InterruptedException, IOException {
		watch.stop();
		logger.info(watch.prettyPrint());
		String taskName = taskNamePrefix + "-" + String.valueOf(loopCounter.getAndIncrement());
		photoDao.deletePhoto();
		resultUrls = googleCrawlService.ImageCrawling("bts");
		photoDao.insertPhoto(resultUrls);
		watch.start();
	}
	
	@Bean
	public StopWatch watch() {
		return new StopWatch();
	}
}
