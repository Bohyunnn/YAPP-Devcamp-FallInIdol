package yapp.devcamp.fallInIdol.model;


public class CalendarItem {
	private String content;
	private String date;
	
	public CalendarItem(String content,String date) {
		this.content=content;
		this.date=date;
	}
	public String getContent() {
		return content;
	}
	public String getDate() {
		return date;
	}	
	
	public void setContent(String content) {
	      this.content = content;
	}
	public void setDate(String date) {
	      this.date = date;
	}
		
	
	
}
