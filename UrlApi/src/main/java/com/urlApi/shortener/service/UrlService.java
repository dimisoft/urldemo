package com.urlApi.shortener.service;

import org.springframework.stereotype.Service;
import com.urlApi.shortener.entities.Url;

import lombok.Data;

@Service
public interface UrlService {
	
	
	
	public Url getUrl(String shortUrl) ;
	
	
	public Iterable<Url> getAllUrls() ;
	
	
	public Url createUrl(Url url);
	
	 
}
