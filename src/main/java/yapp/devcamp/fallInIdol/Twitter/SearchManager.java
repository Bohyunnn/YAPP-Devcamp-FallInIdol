package yapp.devcamp.fallInIdol.Twitter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import yapp.devcamp.fallInIdol.Twitter.event.TweetEvent;

public class SearchManager {
	private String[] keyWords;
	private float latest = 0;
	public SearchManager(String[] keyWords){
		this.keyWords = keyWords;
	}
	public void search(){
		String searchQuery = "";
		for(String toAdd : keyWords){
			searchQuery += toAdd.replace("#", "%23") + "%20";
		}
		searchQuery = searchQuery.substring(0, searchQuery.length() - 3);
		Connection con = Jsoup.connect("https://twitter.com/search?f=tweets&vertical=default&q=" + searchQuery + "&src=typd");
		float newest = latest;
		try{
			Document doc = con.get();
			
			Elements c = doc.select("div.content");
			if(c != null){
				for(Element el : c){
					Elements t = el.select("p.TweetTextSize.js-tweet-text.tweet-text");
					if(t.size() > 0){
						String content = t.first().text();
						long date = Long.parseLong(el.select("div.stream-item-header")
								.select("small.time")
								.select("a")
								.select("span")
								.attr("data-time-ms"));
						String username = el.select("div.stream-item-header")
								.select("a")
								.select("span.username.js-action-profile-name")
								.select("b")
								.text();
						String image=el.select("div.stream-item-header")
								.select("a")
								.select("img[src~=(?i)\\.(png|jpe?g|gif)]")
								.attr("src");
								
						if(date > newest){
							newest = date;
						}
						if(date > latest){
							Tweet m = new Tweet(content,date,username,image);
							TwitterBot.getEventManager().callEvent(new TweetEvent(m));
						}
					}
				}
			}
			latest = newest;
		}catch(Exception ex){
			System.out.println("Connection error...");
		}
	}
}