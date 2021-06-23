/*@author Chindhu Babu*/
package com.combinations.framework.FindAllEnglishWords.util;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Dictionary {
	private static boolean wordexists;

	/*----Calling local online dictionary-----*/
	public static boolean isEnglishword(String aword) {
		
		WireMockServer wm = new WireMockServer(options().port(2345).usingFilesUnderDirectory("C:/Users/Cibin/Desktop/BusyQA/Eclipse/FindAllEnglishWords/src/test/resources"));


		//Start the server and do something
		wm.start();

		    RequestSpecification httpRequest = RestAssured.given();
		    Response response = httpRequest.get("http://localhost:2345/online/EnglishDictJson");
		//stop the service
		wm.stop();
		
		wordexists=false;
		if(response.getBody().jsonPath().getList("words").indexOf(aword.toLowerCase())!=-1) {
			wordexists=true;
		}else if(response.getBody().jsonPath().getList("words").indexOf(aword.toUpperCase())!=-1) {
			wordexists=true;
		}else if(response.getBody().jsonPath().getList("words").indexOf(aword.replace(aword.charAt(0),aword.toUpperCase().charAt(0)))!=-1) {
			
			wordexists=true;
		}else{
			wordexists=false;
		};
	
		return wordexists;

	}

}
