package com.urlApi.shortener.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "url")  
public class Url {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

