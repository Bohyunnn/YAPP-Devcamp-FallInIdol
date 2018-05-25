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
				url = "https://www.google.com/search?q=red+velvet+%2B레드벨벳+%2B공식&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwio3_npxqDbAhUBFZQKHSy8DFAQsAQIiQE";
			} else if (select.equals("uhd")) {
				url = "https://www.google.com/search?q=red+velvet+%2B레드벨벳+%2B고화질+-팬&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiQ7e-Ix6DbAhUEnpQKHfUBBcIQsAQIJQ";
			} else {
				url = "https://www.google.com/search?q=red+velvet+%2B레드벨벳+%2B공항사진+-팬+-평양&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiBw5eex6DbAhWDqJQKHVX5B04QsAQIJQ";
			}
		} else if (choice.equals("exo")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.co.kr/search?q=exo%EC%A7%81%EC%B0%8D&client=safari&rls=en&dcr=0&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwiuqoXapvPZAhULi7wKHQ10BsMQsAQIJQ";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=exo+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjZiqDAmdLZAhWKULwKHfenAugQsAQIJw";
			} else if (select.equals("official")) {
				url = "https://www.google.com/search?q=exo+%2B기사사진+%2B엑소&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjHjcf_w6DbAhUBkpQKHdt7AWsQsAQIJQ";
			} else if (select.equals("uhd")) {
				url = "https://www.google.com/search?q=exo+%2B고화질+%2B엑소&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwij2cauxKDbAhWGoZQKHc6zCG8QsAQIJQ";
			} else {
				url = "https://www.google.com/search?q=exo+%2B공항사진+%2B엑소&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwj0t4vBxKDbAhWCtpQKHR6xBnoQsAQIJQ";
			}
		} else if (choice.equals("bts")) {
			if (select.equals("paparazzi")) {
				url = "https://www.google.com/search?q=bts+%EC%A7%81%EC%B0%8D+%2B%EB%B0%A9%ED%83%84%EC%86%8C%EB%85%84%EB%8B%A8&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjCgae8_PXaAhWBXLwKHcXeB30QsAQIJQ";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.co.kr/search?q=bts+pictorial&client=safari&rls=en&dcr=0&biw=1264&bih=733&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwi7oJ3LmdLZAhVTObwKHc6sDnQQsAQIJA";
			} else if (select.equals("official")) {
				url = "https://www.google.com/search?q=bts+%2B기사사진+%2B공식+%2B방탄소년단+-twitter+-빌보드+-게임&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwit4pSOxqDbAhWEjZQKHZ3LCRoQsAQIJQ";
			} else if (select.equals("uhd")) {
				url = "https://www.google.com/search?q=bts+%2B고화질+%2B방탄소년단+-아미+-배경화면+-굿즈&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjgyZqfxaDbAhXFoJQKHXFICjAQsAQIJQ";
			} else {
				url = "https://www.google.com/search?q=bts+%2B공항사진+%2B방탄소년단+-마비+-아미&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjNrqv3xKDbAhXMm5QKHeF8BQoQsAQIJQ";
			}
		} else {
			if (select.equals("paparazzi")) {
				url = "https://www.google.com/search?q=twice+%EC%A7%81%EC%B0%8D+%2B%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4&client=safari&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwj449SY_vXaAhVCvLwKHUrsDA0QsAQIOw";
			} else if (select.equals("pictorial")) {
				url = "https://www.google.com/search?q=twice+%ED%99%94%EB%B3%B4+%2B%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjD4qW7_vXaAhUDvrwKHRFEBhsQsAQIJQ";
			} else if (select.equals("official")) {
				url = "https://www.google.com/search?q=twice+%2B트와이스+%2B기사사진+-vlive&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwif5puyyKDbAhXEn5QKHbJaCv8QsAQIJQ";
			} else if (select.equals("uhd")) {
				url = "https://www.google.com/search?q=twice+%2B트와이스+%2B고화질+-굿즈&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiBs-rPx6DbAhVMm5QKHca3BAUQsAQIJQ";
			} else {
				url = "https://www.google.com/search?q=twice+%2B트와이스+%2B공항사진+-패션&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiBl6a9x6DbAhUOC6YKHW8zCzMQsAQIJQ";
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
			url = "https://www.google.com/search?q=exo+%2B엑소+%2B단체+-방송+-instagram&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwiRzbL_wKDbAhUKyLwKHfePAEEQsAQIJQ";
		} else if (choice.equals("bts")) {
			url = "https://www.google.com/search?q=bts&client=safari&sa=X&rls=en&biw=718&bih=862&tbm=isch&tbo=u&source=univ&ved=0ahUKEwjmkKfc1vPaAhVGUbwKHXEEA-4QsAQIJQ";
		} else {
			url = "https://www.google.com/search?q=twice+%2B트와이스+-예능+-방송&client=safari&sa=X&rls=en&biw=1440&bih=839&tbm=isch&tbo=u&source=univ&ved=0ahUKEwj28ayevaDbAhUEk5QKHV9pAlIQsAQIQg";
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
