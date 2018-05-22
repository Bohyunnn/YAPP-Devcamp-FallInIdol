package yapp.devcamp.fallInIdol.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import yapp.devcamp.fallInIdol.FaceApi;
import yapp.devcamp.fallInIdol.dao.BtsPhotoDao;

@Service
public class GoogleCrawlService {
	FaceApi faceApi;
	
	public List<String> ImageCrawling(String choice, String select) throws IOException, JSONException {
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "";
		faceApi = new FaceApi();
		
		if (choice.equals("redvelvet")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=redvelvet%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiI_fLA-fLZAhUBoZQKHRHiBt0QsAQIJw";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			} else if (select.equals("official")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			} else if (select.equals("official")) {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			} else {
				url = "https://www.google.co.kr/search?q=redvelvet+pictorial&client=safari&sa=X&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjr3JmbmdLZAhVX6bwKHUU3Ar0QsAQIJw";
			}
		} else if (choice.equals("exo")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else if (select.equals("official")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else if (select.equals("official")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			}
		} else if (choice.equals("bts")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.com/search?q=bts+%EC%A7%81%EC%B0%8D+%2B%EB%B0%A9%ED%83%84%EC%86%8C%EB%85%84%EB%8B%A8&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjCgae8_PXaAhWBXLwKHcXeB30QsAQIJQ";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else if (select.equals("official")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else if (select.equals("uhd")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			}
		} else {
			if (select.equals("paparazzi")) {
				url = "https://www.google.com/search?q=twice+%EC%A7%81%EC%B0%8D+%2B%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4&client=safari&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwj449SY_vXaAhVCvLwKHUrsDA0QsAQIOw";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.com/search?q=twice+%ED%99%94%EB%B3%B4+%2B%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjD4qW7_vXaAhUDvrwKHRFEBhsQsAQIJQ";
			} else if (select.equals("official")) {
				url = "https://www.google.com/search?q=twice+broad+picture+%2B트와이스&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjV58j9_vXaAhWIEbwKHdi0A5YQsAQIJQ";
			} else if (select.equals("uhd")) {
				url = "https://www.google.com/search?q=twice+%EA%B3%A0%ED%99%94%EC%A7%88+%2B%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwid0I6L__XaAhVRNrwKHVJsCMsQsAQIJQ";
			} else {
				url = "https://www.google.com/search?q=twice+공항사진+%2B트와이스&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwib2dai__XaAhUIvLwKHdy-A9EQsAQIJQ";
			}
		}
		

		List<String> resultUrls = new ArrayList<String>();
		int num = 0;
		try {
			Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();

			Elements elements = doc.select("div.rg_meta");

			JSONObject jsonObject;
			JSONParser parser = new JSONParser();
			for (Element element : elements) {
				if (element.childNodeSize() > 0) {
					jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());
					
					if ((((String)jsonObject.get("ou")).indexOf("theqoo") > -1)) {
		            		System.out.println("제외된 url "+jsonObject.get("ou"));
		            		continue;
					}
					
					String[] genderString = faceApi.genderDetected((String) jsonObject.get("ou"));
					
					
					int fe_num = 0;
					int ma_num = 0;
					
					for (int i = 0; i < genderString.length; i++) {
						if (genderString[i].equals("female")) {
							fe_num++;
						}
						else {
							ma_num++;
						}
					}
					
					if (choice.equals("bts") || choice.equals("exo")) {
						if (fe_num == genderString.length) {
							continue;
						}
					}
					else if (choice.equals("redvelvet") || choice.equals("twice")) {
						if (ma_num == genderString.length) {
							continue;
						}
					}
					resultUrls.add((String) jsonObject.get("ou"));
					System.out.println("**** " + num);	
					num++;
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return resultUrls;
	}

	public List<String> ImageCrawling(String choice) throws IOException, JSONException {
		faceApi = new FaceApi();
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
		String url = "";

		if (choice.equals("redvelvet")) {
			url = "https://www.google.com/search?q=red+velvet&client=safari&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiJ39Oy2fPaAhVS6bwKHYn5Bx4QsAQIKA";
		} else if (choice.equals("exo")) {
			url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
		} else if (choice.equals("bts")) {
			url = "https://www.google.com/search?q=bts&client=safari&sa=X&rls=en&biw=718&bih=862&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjmkKfc1vPaAhVGUbwKHXEEA-4QsAQIJQ";
		} else {
			url = "https://www.google.com/search?q=twice+%2B트와이스&client=safari&sa=N&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiDmpjx__XaAhWGVrwKHWJbB-44ChCwBAgk";
		}

		List<String> resultUrls = new ArrayList<String>();
		int num = 0;
		
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
					
					String[] genderString = faceApi.genderDetected((String) jsonObject.get("ou"));
					int fe_num = 0;
					int ma_num = 0;
					
					for (int i = 0; i < genderString.length; i++) {
						if (genderString[i].equals("female")) {
							fe_num++;
						}
						else {
							ma_num++;
						}
					}
					
					if (choice.equals("bts") || choice.equals("exo")) {
						if (fe_num == genderString.length) {
							continue;
						}
					}
					else if (choice.equals("redvelvet") || choice.equals("twice")) {
						if (ma_num == genderString.length) {
							continue;
						}
					}
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
}
