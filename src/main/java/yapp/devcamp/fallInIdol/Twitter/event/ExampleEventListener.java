package yapp.devcamp.fallInIdol.Twitter.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import yapp.devcamp.fallInIdol.Twitter.Tweet;

public class ExampleEventListener {
	static List<String> listTest=new ArrayList<String>();
	@EventHandler
	public void onTweet(TweetEvent e){
		ModelAndView mv = new ModelAndView();

		Tweet t = e.getTweet();
		System.out.println("username : "+t.getPoster() + "\ndate : " + t.getFormatedDate() + "\ncontent :  " + t.getContent() + "\nimage : "+t.getImage());
		
		
		listTest.add(t.getImage());
		
		
	}
	public static List<String> getList() {
		
		return listTest;
	}
}