package yapp.devcamp.fallInIdol.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;


import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@Service
public class GoogleTranslateService {
	
	
	 public String trnaslate(String text,String language) {
		 String API_KEY="AIzaSyD3L0ItWazw7vDZObIToogrjLEW36dOHs4";
		 Translate translate=TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
		 
		 String target="";
		 
		
		 
		 if (language.equals("한국어")) {
			 target = "ko";
	   	}
		 else if (language.equals("ENGLISH")) {
			 target = "en";
	   	} else if (language.equals("日本語")) {
				target = "ja";
		} else if (language.equals("简体中文")) {
				target = "zh";
		}else if (language.equals("繁體中文")) {
			target = "zh-TW";
		} else if (language.equals("ภาษาไทย")) {
			target = "th";
		}  		 
		else if(language.equals("русский")) {
				target = "ru";
		}
		 
		
		 
		 if(target.equals("ko")) {
			 return text;
		 }
		 
		 Translation translation=translate.translate(text,TranslateOption.sourceLanguage("ko"),TranslateOption.targetLanguage(target));
		 
		 String translate_text=translation.getTranslatedText();
		 translate_text=translate_text.replaceAll("&#39;", "'");
		 translate_text=translate_text.replaceAll("&quot;", "\"");
		 translate_text=translate_text.replaceAll("amp;;", "\"");
		 
		 return translate_text;

	        
	    }


}
