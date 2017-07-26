package com.emon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class AsyncController {

	private static final Logger logger = LoggerFactory.getLogger(AppRunnur.class);
	
	@Autowired
	private GithubService github;
	
	@RequestMapping("/user")
	public ResponseEntity<List<User>> getGithubUserinfo() throws InterruptedException, ExecutionException{
		long start = System.currentTimeMillis();
		CompletableFuture<User> user1 = github.getGithubUser("PivotalSoftware"); 
		CompletableFuture<User> user2 = github.getGithubUser("CloudFoundry"); 
		CompletableFuture<User> user3 = github.getGithubUser("Spring-Projects");
		
		//CompletableFuture.allOf(user1,user2,user3).join();
		long callEnd = System.currentTimeMillis()-start;
		logger.info("getGithubUser method call time taken : "+callEnd);
		logger.info("page 1 : "+user1.get());
		logger.info("page 2 : "+user2.get());
		logger.info("page 3 : "+user3.get());
		logger.info("process time now : "+(System.currentTimeMillis()));
		logger.info("process time taken : "+(System.currentTimeMillis()-callEnd));
		
		return new ResponseEntity<List<User>>(Arrays.asList(user1.get(),user2.get(),user3.get()), HttpStatus.OK);
		
	}
	
}
