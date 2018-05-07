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
public class RevelPhotoDao {
	@Autowired
	private JdbcTemplate template;
	
	public void insertPhoto(List<String> list) {
		for (String imageUrl : list) {
//			System.out.println(imageUrl);
//			template.update("INSERT INTO revelPhoto(url) VALUES(?)",imageUrl);
			template.update("INSERT INTO revelPhoto(url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM revelPhoto WHERE url=(?))",imageUrl,imageUrl );
			
		}
		
	}
	
	public void insert_select1_Photo(List<String> list) {
		for (String imageUrl : list) {
			template.update("INSERT INTO revelPhoto(select1_url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM revelPhoto WHERE select1_url=(?)) ",imageUrl, imageUrl);
		}
		
	}
	
	public List<GooglePhotoItem> selectPhoto() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select url from revelPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("url"));
				return item;
			}
		});
		List<GooglePhotoItem> select_url = select1_url_Photo();
		
		result.addAll(select_url);
		
		return result;
	}
	
	public List<GooglePhotoItem> select1_url_Photo() {
		List<GooglePhotoItem> result = new ArrayList<GooglePhotoItem> ();
		result = this.template.query("select select1_url from revelPhoto", new RowMapper<GooglePhotoItem>() {
			public GooglePhotoItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				GooglePhotoItem item = new GooglePhotoItem();
				item.setUrl(rs.getString("select1_url"));
				return item;
			}
		});
		return result;
	}
	public void deletePhoto() {
		template.update("DELETE FROM revelPhoto");
		template.update("ALTER TABLE revelPhoto auto_increment=1");
	}
}
