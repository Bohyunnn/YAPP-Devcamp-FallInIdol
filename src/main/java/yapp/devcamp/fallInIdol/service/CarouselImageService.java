package yapp.devcamp.fallInIdol.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarouselImageService {

	public List<String> getCarouselImage(String choice) {

		List<String> mainPhoto = new ArrayList<String>();
		
		if (choice.equals("redvelvet")) {
			mainPhoto.add("../../img/banner/red-blue-photo.png");
		} else if (choice.equals("bts")) {
			mainPhoto.add("../../img/banner/bts-banner.jpg");
		} else if (choice.equals("exo")) {
			mainPhoto.add("../../img/banner/exo-main.png");
		} else if (choice.equals("twice")) {
			mainPhoto.add(
					"../../img/banner/twice-blue-photo.png");
		}
		return mainPhoto;
	}
}