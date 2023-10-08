package com.UrlWebApp.shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.UrlWebApp.shortener.api.UrlApi;
import com.UrlWebApp.shortener.data.Url;


@Controller
public class UrlController {
		
		@Autowired
		private UrlApi urlApi;
		

		@GetMapping("/")
		public String home(Model model) {
			Iterable <Url> urls = urlApi.getUrls();
			model.addAttribute("urls", urls);
			return "home";
		}
		

		@GetMapping("/createUrl")
		public String createUrl(Model model) {
			Url newUrl = new Url();
			model.addAttribute("url", newUrl);
			return "formFullUrl";
		}
		
		@PostMapping("/createUrl")
		public String saveUrl(@ModelAttribute Url  url, Model model) {
			Url newUrl = urlApi.createUrl(url);
			model.addAttribute("url", newUrl);
			return "formFullUrl";
		}
		
		@GetMapping("/getUrl")
		public String getUrl(Model model) {
			Url url = new Url();
			model.addAttribute("url", url);
			return "formShortUrl";
		}
		

		@PostMapping("/getUrl")
		public String searchUrl(@ModelAttribute Url  url, Model model) {
			Url newUrl = urlApi.getUrl(url);
			model.addAttribute("url", newUrl );
			return "formShortUrl";
		}
	}
