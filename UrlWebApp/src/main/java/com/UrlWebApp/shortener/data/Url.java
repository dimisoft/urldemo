package com.UrlWebApp.shortener.data;

import lombok.Data;

@Data 
public class Url {

    private Long id;
    private String fullUrl;
    private String shortUrl;
    
    
    public Long getId() { 
    	return id; 
    }
    
    
    public String getFullUrl() {
    	return fullUrl;
    }
    

    public String getShortUrl() {
    	return shortUrl;
    }
    

    
    public void setId(long id) { 
    	this.id = id; 
    }
    
    
    public void setFullUrl(String fullUrl) {
    	this.fullUrl= fullUrl;
    }
    

    public void setShortUrl(String shortUrl) {
    	this.shortUrl= shortUrl;
    }
    
}

