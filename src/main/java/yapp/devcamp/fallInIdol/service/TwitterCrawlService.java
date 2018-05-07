package yapp.devcamp.fallInIdol.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.devcamp.fallInIdol.model.TwitterItem;




@Service
public class TwitterCrawlService {
	
	@Autowired
	GoogleTranslateService googleTranslateService;
	
		
	public List<TwitterItem> TwitterCrawling(String choice,String language) throws IOException {				
		String url = "";
				
		if (choice.equals("redvelvet")) {
			url = "https://twitter.com/RVsmtown?lang=ko";
		} else if (choice.equals("exo")) {
			url = "https://twitter.com/weareoneEXO?lang=ko";
		} else if (choice.equals("bts")) {
			url = "https://twitter.com/BTS_twt?lang=ko";
		} else {
			url = "https://twitter.com/jypetwice?lang=ko";
		}
		List<TwitterItem> twitUrls = new ArrayList<TwitterItem>();
		TwitterItem item;
		
				
		
		
		try{
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			
			Elements c = doc.select("div.content");
			if(c != null){
				for(Element el : c){
					Elements t = el.select("p.TweetTextSize.js-tweet-text.tweet-text");
					if(t.size() > 0){
						String content = t.first().text();
						String date = el.select("div.stream-item-header")
								.select("small.time")
								.select("a")
								.select("span")
								.attr("data-time-ms");
						String image=el.select("div.AdaptiveMedia-container")							
								.select("img[src~=(?i)\\.(png|jpe?g|gif)]")
								.attr("src").toString();
						
						
						String r_content=content.substring(0, content.indexOf("pic"));
						
						r_content=googleTranslateService.trnaslate(r_content);
						
						
						item=new TwitterItem(r_content,date,image);
						
												
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


