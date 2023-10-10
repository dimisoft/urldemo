package com.urlApi.shortener.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "urls")  
public class Url {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="full_url")
    private String fullUrl;
	
	@Column(name="short_url")
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

