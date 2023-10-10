package com.urlApi.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		public ResponseEntity<Url> createUrl(@RequestBody Url url) {
				
			Url shorturl = urlService.createUrl(url);;
				return ResponseEntity.ok(shorturl);
			 
		}
		

		 
		@PostMapping("/getUrl")
		public ResponseEntity<Url>  getUrl(@RequestBody Url url) {
			Url fullurl = urlService.getUrl(url.getShortUrl());
				return ResponseEntity.ok(fullurl);
			 
		}
		

		 
		@GetMapping("/")
		public ResponseEntity<Iterable<Url>> getUrls() {
			Iterable<Url> liste= urlService.getAllUrls();
			   return ResponseEntity.status(200).body(liste);
		}
		

	
	}
