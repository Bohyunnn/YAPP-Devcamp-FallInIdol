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
		 //String text="Good Morning. Now let's Start with the google translate api";
		 Translation translation=translate.translate(test,TranslateOption.sourceLanguage("ko"),TranslateOption.targetLanguage("en"));
		 //System.out.printf("Text : %s%n",test);
		 //System.out.printf("Translation : %s%n",translation.getTranslatedText());
		 String translate_text=translation.getTranslatedText();
		 translate_text=translate_text.replaceAll("&#39;", "'");
		 translate_text=translate_text.replaceAll("&quot;", "\"");
		 translate_text=translate_text.replaceAll("amp;;", "\"");
		 return translate_text;

	        
	    }
}
