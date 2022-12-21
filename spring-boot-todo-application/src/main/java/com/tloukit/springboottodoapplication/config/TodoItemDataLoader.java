package com.tloukit.springboottodoapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tloukit.springboottodoapplication.models.TodoItem;
import com.tloukit.springboottodoapplication.repositories.TodoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner{
	
	private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);
	
	@Autowired
	private TodoItemRepository todoItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		loadSeedData();
		
	}
	
	private void loadSeedData() {
		if(todoItemRepository.count() == 0) {
			TodoItem todoItem1 = new TodoItem("corder ma raquette");
			TodoItem todoItem2 = new TodoItem("coder une todo List en java");
			
			todoItemRepository.save(todoItem1);
			todoItemRepository.save(todoItem2);
		}
		logger.info("number of Todo Items : {}", todoItemRepository.count());
	}

}
