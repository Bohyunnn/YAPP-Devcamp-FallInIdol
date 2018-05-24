package yapp.devcamp.fallInIdol.model;



public class TwitterItem {
	private String content;
	private String date;
	private String image;
	
	public TwitterItem(String content,String date,String image) {
		this.content=content;
		this.date=date;
		this.image=image;
	}
	public String getContent() {
		return content;
	}
	public String getDate() {
		return date;
	}	
	public String getImage() {
		return image;
	}
	public void setContent(String content) {
	      this.content = content;
	}
	public void setDate(String date) {
	      this.date = date;
	}
	public void setImage(String image) {
	      this.image = image;
	}
		
	
	
	
}
