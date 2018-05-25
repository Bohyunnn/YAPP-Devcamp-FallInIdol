package yapp.devcamp.fallInIdol.service;

 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.Events;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;

import yapp.devcamp.fallInIdol.model.CalendarItem;
import yapp.devcamp.fallInIdol.model.TwitterItem;


@Service
public class GoogleCalendarService {
 
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
 
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"),
            ".credentials/calendar-java-quickstart");
 
    private static FileDataStoreFactory DATA_STORE_FACTORY;
 
    private static final JsonFactory JSON_FACTORY = JacksonFactory
            .getDefaultInstance();
 
    private static HttpTransport HTTP_TRANSPORT;
 
    private static final List<String> SCOPES = Arrays
            .asList(CalendarScopes.CALENDAR);
 
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
 
    public static Credential authorize() throws IOException {
        InputStream in = GoogleCalendarService.class
                .getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JSON_FACTORY, new InputStreamReader(in));
 
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow,
                new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to "
                + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }
 
    public List<CalendarItem> CalendarCrawling(String choice) throws IOException {
    	String CALENDAR_ID="";
    	
    	
    	if (choice.equals("redvelvet")) {
    		CALENDAR_ID = "7qvt7fmogdho2n4b5lpnkqkhgc@group.calendar.google.com";
		} else if (choice.equals("exo")) {
			CALENDAR_ID = "o5s68n83gf1lr4v6oaeuv4i2tk@group.calendar.google.com";
		} else if (choice.equals("bts")) {
			CALENDAR_ID = "jomtm0vr9iskj55159ufvkk734@group.calendar.google.com";
		} else {
			CALENDAR_ID = "ocpn0qu7fhjhno71lbmbe333m8@group.calendar.google.com";
		}
    	
    	
    	com.google.api.services.calendar.Calendar service =getCalendarService();
    	List<CalendarItem> CalendarList = new ArrayList<CalendarItem>();
    	CalendarItem item;
            // List the next 10 events from the primary calendar.
            DateTime now = new DateTime(System.currentTimeMillis());
            com.google.api.services.calendar.model.Events events = service.events().list(CALENDAR_ID)
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
            List<Event> items = events.getItems();
            if (items.size() == 0) {
                System.out.println("No upcoming events found.");
            } else {
                System.out.println("Upcoming events");
                for (Event event : items) {
                    DateTime start = event.getStart().getDateTime();
                    if (start == null) {
                        start = event.getStart().getDate();
                    }
                    //System.out.printf("%s (%s)\n", event.getSummary(), start);
                    item=new CalendarItem(event.getSummary(),start.toString());
                    CalendarList.add(item);
                }
            }
            return CalendarList;
		
    }
    
    public static Calendar getCalendarService() throws IOException {
        Credential credential = authorize();
        return new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME).build();
    }
 

}


