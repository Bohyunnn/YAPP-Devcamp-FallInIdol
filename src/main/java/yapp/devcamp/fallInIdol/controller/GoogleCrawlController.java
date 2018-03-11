package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoogleCrawlController {
	
	@GetMapping("/home")
	public ModelAndView ImageCrawling() throws IOException {
		ModelAndView mv = new ModelAndView();
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
		
		List<String> resultUrls = new ArrayList<String>();
	
		try {
		    Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();
	
		    Elements elements = doc.select("div.rg_meta");
	
		    JSONObject jsonObject;
		    for (Element element : elements) {
		        if (element.childNodeSize() > 0) {
		            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());
		            resultUrls.add((String) jsonObject.get("ou"));
		        }
		    }
	
		    System.out.println("number of results: " + resultUrls.size());
	
		    for (String imageUrl : resultUrls) {
		        System.out.println(imageUrl);
		    }
		    mv.addObject("result", resultUrls);
		    mv.setViewName("/home");
	
		} catch (IOException | ParseException e) {
		    e.printStackTrace();
		}
		
		return mv;
	}
// destinationkpop 에서 가져오는 사진은 엑박 남.
}
