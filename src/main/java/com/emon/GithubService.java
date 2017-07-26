package com.emon;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
	private static final Logger logger=LoggerFactory.getLogger(GithubService.class);
	private final RestTemplate restTemplate;
	
	public GithubService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public CompletableFuture<User> getGithubUser(String user) throws InterruptedException{
		logger.info("looking for user " +user);
		String url = String.format("https://api.github.com/users/%s", user);
		User result = restTemplate.getForObject(url, User.class);
		//Thread.sleep(1000L);
		return CompletableFuture.completedFuture(result);
	}
}
