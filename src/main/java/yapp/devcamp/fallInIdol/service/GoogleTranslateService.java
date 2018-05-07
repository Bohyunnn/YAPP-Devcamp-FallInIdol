package yapp.devcamp.fallInIdol.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@Service
public class GoogleTranslateService {
	
	public String trnaslate(String test) {
		 String API_KEY="AIzaSyD3L0ItWazw7vDZObIToogrjLEW36dOHs4";
		 Translate translate=TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
		 
		 
		 Translation translation=translate.translate(test,TranslateOption.sourceLanguage("ko"),TranslateOption.targetLanguage("en"));
		 
		 String translate_text=translation.getTranslatedText();
		 translate_text=translate_text.replaceAll("&#39;", "'");
		 translate_text=translate_text.replaceAll("&quot;", "\"");
		 translate_text=translate_text.replaceAll("amp;;", "\"");
		 return translate_text;

	        
	    }
	
	 public String trnaslate(String test,String language) {
		 String API_KEY="AIzaSyD3L0ItWazw7vDZObIToogrjLEW36dOHs4";
		 Translate translate=TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
		 
		 String target="";
		 
		 if (language.equals("english")) {
			 target = "en";
	   	} else if (language.equals("chinese")) {
				target = "zh";
		} else if (language.equals("japanese")) {
				target = "jw";
		} else {
				target = "";
		}
		 Translation translation=translate.translate(test,TranslateOption.sourceLanguage("ko"),TranslateOption.targetLanguage(target));
		 
		 String translate_text=translation.getTranslatedText();
		 translate_text=translate_text.replaceAll("&#39;", "'");
		 translate_text=translate_text.replaceAll("&quot;", "\"");
		 translate_text=translate_text.replaceAll("amp;;", "\"");
		 return translate_text;

	        
	    }


}
