package yapp.devcamp.fallInIdol.Twitter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//DTO
public class Tweet {
	private String content;
	private long date;
	private String user;
	private String image;
	
	public Tweet(String content,long date,String user,String image) {
		this.content=content;
		this.date=date;
		this.user=user;
		this.image=image;
	}
	public String getContent() {
		return content;
	}
	public long getDate() {
		return date;
	}
	public String getPoster() {
		return user;
	}
	public String getImage() {
		return image;
	}
	public String getFormatedDate() {
		DateFormat f=new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		Calendar c=Calendar.getInstance();
		c.setTimeInMillis(date);
		return(f.format(c.getTime()));
	}
	
	
}
