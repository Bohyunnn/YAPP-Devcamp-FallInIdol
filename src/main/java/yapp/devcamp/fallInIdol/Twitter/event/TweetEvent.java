package yapp.devcamp.fallInIdol.Twitter.event;

import yapp.devcamp.fallInIdol.Twitter.Tweet;

public class TweetEvent implements Event {
	private Tweet t;
	public TweetEvent(Tweet t){
		this.t= t;
	}
	public Tweet getTweet(){
		return t;
	}
}
