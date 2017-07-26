package com.emon;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunnur implements CommandLineRunner {
	
	/*private static final Logger logger = LoggerFactory.getLogger(AppRunnur.class);
	@Autowired
	private GithubService githubService;*/

	@Override
	public void run(String... args) throws Exception {
		
		/*long start = System.currentTimeMillis();
		CompletableFuture<User> user1 = githubService.getGithubUser("PivotalSoftware"); 
		CompletableFuture<User> user2 = githubService.getGithubUser("EmonHossain"); 
		CompletableFuture<User> user3 = githubService.getGithubUser("Spring-Projects");
		
		logger.info("time taken : "+(System.currentTimeMillis()-start));
		logger.info("page 1 : "+user1.get());
		logger.info("page 2 : "+user2.get());
		logger.info("page 3 : "+user3.get());*/
		

	}

}
