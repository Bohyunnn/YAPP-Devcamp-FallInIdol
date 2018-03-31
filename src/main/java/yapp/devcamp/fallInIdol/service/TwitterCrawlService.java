package yapp.devcamp.fallInIdol.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


import yapp.devcamp.fallInIdol.model.TwitterItem;


@Service
public class TwitterCrawlService {
	
	List<TwitterItem> twitUrls = new ArrayList<TwitterItem>();
	TwitterItem item;
	
	public List<TwitterItem> TwitterCrawling(String choice) throws IOException {				
		String url = "https://twitter.com/RVsmtown?lang=ko";
				
		if (choice.equals("redvelvet")) {
			url = "https://twitter.com/RVsmtown?lang=ko";
		} else if (choice.equals("exo")) {
			url = "https://twitter.com/weareoneEXO?lang=ko";
		} else if (choice.equals("bts")) {
			url = "https://twitter.com/BTS_twt?lang=ko";
		} else {
			url = "https://twitter.com/jypetwice?lang=ko";
		}
		
		
		Connection con = Jsoup.connect(url);
		
		try{
			Document doc = con.get();
			
			Elements c = doc.select("div.content");
			if(c != null){
				for(Element el : c){
					Elements t = el.select("p.TweetTextSize.js-tweet-text.tweet-text");
					if(t.size() > 0){
						String content = t.first().text();
						String date =el.select("div.stream-item-header")
								.select("small.time")
								.select("a")
								.select("span")
								.attr("data-time-ms");
					
						
						String image=el.select("div.AdaptiveMediaOuterContainer")
								.select("img[src]")
								.attr("abs:src");
						
						
						
						
						item=new TwitterItem(content,date,image);
						
												
						twitUrls.add(item);
					}
				}
			}
		}catch(Exception ex){
			System.out.println("Connection error...");
		}		
		
		return twitUrls;
	}
		
	
}


