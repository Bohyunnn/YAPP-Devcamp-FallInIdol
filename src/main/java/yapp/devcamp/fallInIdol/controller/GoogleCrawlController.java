package yapp.devcamp.fallInIdol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoogleCrawlController {
	
	@GetMapping("/home")
	public ModelAndView sendResult(HttpServletRequest request ) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		List<String> resultUrls = new ArrayList<String>();
		
		String choice = request.getParameter("choice");
		String select = request.getParameter("select");
		
		if (choice != null && select != null) {
			resultUrls = ImageCrawling(choice, select);
			mv.addObject("result", resultUrls);
			mv.setViewName("/home");
		}
		else if (choice != null && select == null) {
			resultUrls = firstCrawling(choice);
			mv.addObject("result", resultUrls);
			mv.setViewName("/home?choice="+choice+"#photo");
		}
	 
		mv.addObject("result", resultUrls);
		mv.addObject("choice", choice);
		mv.setViewName("/home");
		
		return mv;
	}
	
	public List<String> ImageCrawling(String choice, String select) throws IOException {
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
		
		if (choice.equals("redvelvet")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
			}
			else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			}
			else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			}
			else {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			}
		}
		else if (choice.equals("exo")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
			}
			else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			}
			else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			}
			else {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			}
		}
		else if (choice.equals("bts")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=bts%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjohMigp_PZAhVFabwKHbJ7BUUQsAQIJQ&biw=1138&bih=756&dpr=2";
			}
			else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			}
			else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			}
			else {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			}
		}
		else {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=twice%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwikzqezp_PZAhUJTLwKHfgqAMUQsAQIJQ";
			}
			else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=twice+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi3wuDWmdLZAhVExrwKHX1dDKkQsAQIJw";
			}
			else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=twice+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi3wuDWmdLZAhVExrwKHX1dDKkQsAQIJw";
			}
			else {
				url = "https://www.google.co.kr/search?q=twice+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi3wuDWmdLZAhVExrwKHX1dDKkQsAQIJw";
			}
		}
		
	
		List<String> resultUrls = new ArrayList<String>();
		int index = 0;
		
		try {
		    Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();
	
		    Elements elements = doc.select("div.rg_meta");
	
		    JSONObject jsonObject;
		    for (Element element : elements) {
		        if (element.childNodeSize() > 0) {
		            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());
		            if ((((String)jsonObject.get("ou")).indexOf("theqoo") > -1)) {
		            		System.out.println("제외된 url "+jsonObject.get("ou"));
		            		continue;
		            }
		            	resultUrls.add((String) jsonObject.get("ou"));
		        }
		    }
	
		    System.out.println("number of results: " + resultUrls.size());
	
		    for (String imageUrl : resultUrls) {
		    		System.out.println(index + "번: " +imageUrl);
		    }
	
		} catch (IOException | ParseException e) {
		    e.printStackTrace();
		}
		
		return resultUrls;
	}
	
	public List<String> firstCrawling(String choice) throws IOException {
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
		
		if (choice.equals("redvelvet")) {
			url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
		}
		else if (choice.equals("exo")) {
			url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
		}
		else if (choice.equals("bts")) {
			url = "https://www.google.co.kr/search?q=bts%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjohMigp_PZAhVFabwKHbJ7BUUQsAQIJQ&biw=1138&bih=756&dpr=2";
		}
		else {
			url = "https://www.google.co.kr/search?q=twice%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwikzqezp_PZAhUJTLwKHfgqAMUQsAQIJQ";
		}
		
	
		List<String> resultUrls = new ArrayList<String>();
	
		try {
		    Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();
	
		    Elements elements = doc.select("div.rg_meta");
		    	
		    int index = 0;
		    JSONObject jsonObject;
		    for (Element element : elements) {
		        if (element.childNodeSize() > 0) {
		            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString()); 
//		            if ((((String)jsonObject.get("ou")).indexOf("cdninstagram") > -1) 
//		            		|| (((String)jsonObject.get("ou")).indexOf("destinationkpop") > -1) || (((String)jsonObject.get("ou")).indexOf("theqoo") > -1) 
//		            		|| (((String)jsonObject.get("ou")).indexOf("theqoo") > -1) || (((String)jsonObject.get("ou")).indexOf("postfiles") > -1) 
//		            		|| (((String)jsonObject.get("ou")).indexOf("blogthumb") > -1) ) {
//		            		System.out.println("제외된 url "+jsonObject.get("ou"));
//		            		continue;
//		            }
		            if ((((String)jsonObject.get("ou")).indexOf("theqoo") > -1)) {
		            		System.out.println("제외된 url "+jsonObject.get("ou"));
		            		continue;
		            }
		            resultUrls.add((String) jsonObject.get("ou"));
		        }
		    }
	
		    System.out.println("number of results: " + resultUrls.size());
		    	
		    for (String imageUrl : resultUrls) {
		        System.out.println(index + "번: " +imageUrl);
		    }
	
		} catch (IOException | ParseException e) {
		    e.printStackTrace();
		}
		
		return resultUrls;
	}
// destinationkpop 에서 가져오는 사진은 엑박 남.
}
