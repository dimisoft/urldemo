package com.urlApi.shortener.service;


import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlApi.shortener.entities.Url;
import com.urlApi.shortener.repository.UrlRepository;

import lombok.Data;

@Data
@Service
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	public Url getUrl(String shortUrl) {
		Url existingUrl =   urlRepository.findByShortUrl(shortUrl)
				.orElseGet(() -> {
					Url url = new Url();
	                    url.setShortUrl(shortUrl);
	                    return url;
	                });

	        
	        return existingUrl;
	}
	
	
	public Iterable<Url> getAllUrls() {
		return urlRepository.findAll();
	}
	
	
	public Url createUrl(Url url) {
        Url existingUrl =  urlRepository.findByFullUrl(url.getFullUrl())
                .orElseGet(() -> {
                    String newShortUrl = shortenUrl();
                    url.setShortUrl(newShortUrl);
                    urlRepository.save(url);
                    return url;
                });

        
        return existingUrl;
        
	}
	
	
	 private String shortenUrl() {
        var uuid = UUID.randomUUID();
        Random rand = new Random();
        String shortUrl = "http://bit.ly/"+uuid.toString().replaceAll("-", "").substring(0, rand.nextInt(5, 10)); // 10 premiers caractères
        return shortUrl;
    }

}
