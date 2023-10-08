package com.urlApi.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlApi.shortener.entities.Url;
import com.urlApi.shortener.service.UrlService;

 
@RestController
public class UrlController {
		
		@Autowired
		private UrlService urlService;

		 
		@PostMapping("/urlshortener")
		public Url createUrl(@RequestBody Url url) {
				return urlService.createUrl(url);
			 
		}
		

		 
		@PostMapping("/getUrl")
		public Url getUrl(@RequestBody Url url) {
				return urlService.getUrl(url.getShortUrl());
			 
		}
		

		 
		@GetMapping("/")
		public Iterable<Url> getUrls() {
				return urlService.getAllUrls();
			 
		}
		
		
		
	
	}
