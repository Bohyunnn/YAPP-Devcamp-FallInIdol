package yapp.devcamp.fallInIdol.Twitter;

public class TwitterManager {
	public TwitterManager(){
		
	}
	public void startSearchThread(long millis,String[] keyWords) {
		new Thread(new Runnable() {
			public void run() {
				SearchManager mn=new SearchManager(keyWords);
				searchLoop(mn,millis);
			}
		}).start();
	}
	public void searchLoop(SearchManager mn,long millis) {
		mn.search();
		try {
			Thread.sleep(millis);			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		searchLoop(mn,millis);
	}
	
}
