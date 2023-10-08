package com.UrlWebApp.shortener.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;
import com.UrlWebApp.shortener.data.Url;


@Component
public class UrlApi {

	@Value("${microservice.shortener.apiUrl}")
	String baseApiUrl;
		
	public Url createUrl(Url url) {
		final String createUrlLink = baseApiUrl + "/urlshortener";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Url> request = new HttpEntity<Url>(url);
		ResponseEntity<Url> response = restTemplate.exchange(
				createUrlLink, 
				HttpMethod.POST, 
				request, 
				Url.class);
				
		return response.getBody();
	}
	



	public Url getUrl(Url  url) {
		final String getUrlLink = baseApiUrl + "/getUrl";

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Url> request = new HttpEntity<Url>(url);
		ResponseEntity<Url> response = restTemplate.exchange(
				getUrlLink, 
				HttpMethod.POST, 
				request, 
				Url.class);
				
		return response.getBody();
	
	}

	
	public Iterable<Url> getUrls() {
		final String getUrlLink = baseApiUrl + "/";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Url>> response = restTemplate.exchange(
				getUrlLink, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<Url>>() {});
				
		return response.getBody();
	
	}

}
