
package yapp.devcamp.fallInIdol.model;


public class AlbumItem {
	private String content;
	private String image;
	private String date;
	
	public AlbumItem(String content,String image,String date) {
		this.content=content;
		this.image=image;
		this.date=date;
	}
	public String getContent() {
		return content;
	}
	public String getImage() {
		return image;
	}	
	public String getDate() {
		return date;
	}	
	
	public void setContent(String content) {
	      this.content = content;
	}
	public void setImage(String image) {
	      this.image = image;
	}
	public void setDate(String date) {
	      this.date = date;
	}
	
}

