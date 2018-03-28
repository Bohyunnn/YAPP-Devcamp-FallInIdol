package yapp.devcamp.fallInIdol.service;

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
import org.springframework.stereotype.Service;

@Service
public class GoogleCrawlService {

	public List<String> ImageCrawling(String choice, String select) throws IOException {

		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";

		if (choice.equals("redvelvet")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			} else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			} else {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			}
		} else if (choice.equals("exo")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			}
		} else if (choice.equals("bts")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=bts%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjohMigp_PZAhVFabwKHbJ7BUUQsAQIJQ&biw=1138&bih=756&dpr=2";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else if (select.equals("broad")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			}
		}

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

			// System.out.println("number of results: " + resultUrls.size());

			// for (String imageUrl : resultUrls) {
			// System.out.println(imageUrl);
			// }

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
		} else if (choice.equals("exo")) {
			url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
		} else if (choice.equals("bts")) {
			url = "https://www.google.co.kr/search?q=bts%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjohMigp_PZAhVFabwKHbJ7BUUQsAQIJQ&biw=1138&bih=756&dpr=2";
		} else {
			url = "https://www.google.co.kr/search?q=twice%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwikzqezp_PZAhUJTLwKHfgqAMUQsAQIJQ";
		}

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

			// System.out.println("number of results: " + resultUrls.size());

			// for (String imageUrl : resultUrls) {
			// System.out.println(imageUrl);
			// }

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return resultUrls;
	}
	// destinationkpop 에서 가져오는 사진은 엑박 남.
}
