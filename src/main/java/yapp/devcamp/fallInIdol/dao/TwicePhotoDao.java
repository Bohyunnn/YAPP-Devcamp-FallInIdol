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
	
	public void insert_paparazzi_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO twiPhoto(paparazzi_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE paparazzi_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_official_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO twiPhoto(official_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE official_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_pictorial_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO twiPhoto(pictorial_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE pictorial_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_uhd_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO twiPhoto(uhd_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE uhd_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_airport_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO twiPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO twiPhoto(airport_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM twiPhoto WHERE airport_url=(?)) ",imageUrl, imageUrl);
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
//		List<GooglePhotoItem> select_url = select1_url_Photo();
//		
//		result.addAll(select_url);
		
		return result;
	}
	
	public List<GooglePhotoItem> paparazzi_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select paparazzi_url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("paparazzi_url"));
				return item;
			}
		});
		return result;
	}
	
	public List<GooglePhotoItem> official_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select official_url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("official_url"));
				return item;
			}
		});
		return result;
	}
	public List<GooglePhotoItem> pictorial_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select pictorial_url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("pictorial_url"));
				return item;
			}
		});
		return result;
	}
	public List<GooglePhotoItem> uhd_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select uhd_url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("uhd_url"));
				return item;
			}
		});
		return result;
	}
	public List<GooglePhotoItem> airport_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select airport_url from twiPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("airport_url"));
				return item;
			}
		});
		return result;
	}
	public void deletePhoto() {
		template.update("DELETE FROM twiPhoto");
		template.update("ALTER TABLE twiPhoto auto_increment=1");
	}
}
