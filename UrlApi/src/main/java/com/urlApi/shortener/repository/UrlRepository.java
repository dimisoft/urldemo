package com.urlApi.shortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlApi.shortener.entities.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

	Optional<Url> findByFullUrl(String fullurl);
     
	Optional<Url> findByShortUrl(String shortUrl);
}
