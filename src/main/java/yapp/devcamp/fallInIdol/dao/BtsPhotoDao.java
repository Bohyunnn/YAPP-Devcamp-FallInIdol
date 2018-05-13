package yapp.devcamp.fallInIdol.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import yapp.devcamp.fallInIdol.model.GooglePhotoItem;

@Repository
public class BtsPhotoDao {
	
	@Autowired
	private JdbcTemplate template;
	int last_num;
	
	public void insertPhoto(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
			template.update("INSERT INTO btsPhoto(url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE url=(?))",imageUrl,imageUrl );
		}
		
	}
	
	public void insert_paparazzi_Photo(List<String> list) {
		for (String imageUrl : list) {
			template.update("INSERT INTO btsPhoto(paparazzi_url) SELECT (?) FROM btsPhoto WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE paparazzi_url=(?)) ",imageUrl, imageUrl);
			
		}
		
	}
	public void insert_official_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO btsPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO btsPhoto(official_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE official_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_pictorial_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO btsPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO btsPhoto(pictorial_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE pictorial_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_uhd_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO btsPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO btsPhoto(uhd_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE uhd_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	public void insert_airport_Photo(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO btsPhoto(select1_url) value (?)",imageUrl );
			template.update("INSERT INTO btsPhoto(airport_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE airport_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
		
	public List<GooglePhotoItem> selectPhoto() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select * from btsPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setNum(rs.getInt("photoNum"));
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
		result = this.template.query("select paparazzi_url from btsPhoto", new RowMapper<GooglePhotoItem>() {
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
		result = this.template.query("select official_url from btsPhoto", new RowMapper<GooglePhotoItem>() {
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
		result = this.template.query("select pictorial_url from btsPhoto", new RowMapper<GooglePhotoItem>() {
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
		result = this.template.query("select uhd_url from btsPhoto", new RowMapper<GooglePhotoItem>() {
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
		result = this.template.query("select airport_url from btsPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("airport_url"));
				return item;
			}
		});
		return result;
	}
	public void deletePhoto() {
		template.update("DELETE FROM btsPhoto");
		template.update("ALTER TABLE btsPhoto auto_increment=1");
	}
	
//	public void countPhoto() {
//		int num = 0;
//		num = template.queryForObject(
//			    "SELECT COUNT(url) FROM btsPhoto", Integer.class);
//		
//	}

}
