package yapp.devcamp.fallInIdol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarouselImageService {

	public List<String> getCarouselImage(String choice) {

		List<String> mainPhoto = new ArrayList<String>();
		if (choice.equals("redvelvet")) {
			mainPhoto.add("http://cfile6.uf.tistory.com/image/2470AF455962EDC3148836");
			mainPhoto.add("http://korepo.com/wp-content/uploads/2016/10/450_red.jpg");
			mainPhoto.add("http://media.infospesial.net/image/p/2015/12/a5d9a-red-velvet.jpg");
		} else if (choice.equals("bts")) {
			mainPhoto.add("https://www.allkpop.com/upload/2018/02/af_org/05224856/bts.jpg");
			mainPhoto.add("https://www.allkpop.com/upload/2017/09/af_org/03114342/bts.jpg");
			mainPhoto.add("https://www.allkpop.com/upload/2018/01/af_org/13143944/bts.jpg");
		} else if (choice.equals("exo")) {
			mainPhoto.add("https://i.scdn.co/image/9af8e7904dc0ffd511a4136eb11c4235dce8f79f");
			mainPhoto.add("https://www.dramafever.com/st/news/images/exo_cover.png");
			mainPhoto.add("https://www.allkpop.com/upload/2017/08/af_org/21024700/EXO.jpg");
		} else if (choice.equals("twice")) {
			mainPhoto.add(
					"http://d2natlk8qx07mk.cloudfront.net/resource/2016/11/03/base_022bed27db67790d3cd6ec9cbaafbd07.jpg");
			mainPhoto.add("http://officiallykmusic.com/wp-content/uploads/2017/06/twice-signal-1.jpg");
			mainPhoto.add("https://i.pinimg.com/originals/ca/cc/b0/caccb0490aa43bb4f8e6bf997fcf0ca1.jpg");
		}
		return mainPhoto;
	}
}
