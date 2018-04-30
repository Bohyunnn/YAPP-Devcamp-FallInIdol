package yapp.devcamp.fallInIdol.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GooglePhotoItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;
	
	@Column(name="url", nullable=true)
	private String url;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
