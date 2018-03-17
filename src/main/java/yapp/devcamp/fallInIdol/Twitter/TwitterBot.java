package yapp.devcamp.fallInIdol.Twitter;

import java.util.List;

import yapp.devcamp.fallInIdol.Twitter.event.EventManager;
import yapp.devcamp.fallInIdol.Twitter.event.ExampleEventListener;

public class TwitterBot {
	public static TwitterManager mg = new TwitterManager();
	public static EventManager emg = new EventManager();
	

	public static void twit() {
		getEventManager().registerEvents(new ExampleEventListener());
		mg.startSearchThread(10000, new String[]{"#bts"});
		
	}
	public static TwitterManager getManager(){	
		return mg;
	}
	public static EventManager getEventManager(){
		return emg;
	}
}
