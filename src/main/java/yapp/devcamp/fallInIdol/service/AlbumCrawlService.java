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

import yapp.devcamp.fallInIdol.model.AlbumItem;
import yapp.devcamp.fallInIdol.model.TwitterItem;


@Service
public class AlbumCrawlService {
	
	List<AlbumItem> AlbumList = new ArrayList<AlbumItem>();
	AlbumItem item;
	
	public List<AlbumItem> AlbumCrawling(String choice) throws IOException {				
		String url = "https://twitter.com/RVsmtown?lang=ko";
				
		if (choice.equals("redvelvet")) {
			url = "http://music.naver.com/artist/album.nhn?artistId=343255";
		} else if (choice.equals("exo")) {
			url = "http://music.naver.com/artist/album.nhn?artistId=272211";
		} else if (choice.equals("bts")) {
			url = "http://music.naver.com/artist/album.nhn?artistId=143179&page=1";
		} else {
			url = "http://music.naver.com/artist/album.nhn?artistId=460475";
		}
		
		
		Connection con = Jsoup.connect(url);
		
		try{
			Document doc = con.get();
			
			//Elements c = doc.select("div.text table tbody tr td");
			Elements c = doc.select("div.thmb_cover");
			if(c != null){
				for(Element el : c){
						String content=el
							.select("p.detail")
							.select("strong.tit").text();
						
						String image=el
							.select("img[src]")
							.attr("abs:src");
						
						String date=el.select("span.date").text();
							
											
						item=new AlbumItem(content,image,date);
						AlbumList.add(item);
						
					
				}
			}
		}catch(Exception ex){
			System.out.println("Connection error...");
		}		
		
		return AlbumList;
	}
		
	
}


