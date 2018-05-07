package yapp.devcamp.fallInIdol.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yapp.devcamp.fallInIdol.model.GooglePhotoItem;

@Repository
public class TwicePhotoDao {
	@Autowired
	private JdbcTemplate template;
	
	public void insertPhoto(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(url) VALUES(?)",imageUrl);
			template.update("INSERT INTO twiPhoto(url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE url=(?))",imageUrl,imageUrl );
			
		}
		
	}
	
	public List<GooglePhotoItem> selectPhoto() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("url"));
				return item;
			}
		});
//		for (GooglePhotoItem imageUrl : result) {
//			System.out.println(imageUrl.getUrl());
//		}
		return result;
	}
	
	public void deletePhoto() {
		template.update("DELETE FROM twiPhoto");
		template.update("ALTER TABLE twiPhoto auto_increment=1");
	}
}
