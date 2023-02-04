package com.tloukit.springboottodoapplication.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tloukit.springboottodoapplication.models.TodoItem;
import com.tloukit.springboottodoapplication.repositories.TodoItemRepository;

@Service
public class TodoItemService {
	
	@Autowired
	TodoItemRepository todoItemRepository;
	
	public Iterable<TodoItem> getAll(){
		return todoItemRepository.findAll();
	}

	public Optional<TodoItem>getById(Long id){
		return todoItemRepository.findById(id);
	}
	
	public TodoItem save(TodoItem todoItem) {
		if(todoItem.getId() == null) {
			todoItem.setCreatedDate(Instant.now());
		}
		todoItem.setModifiedDate(Instant.now());
		return todoItemRepository.save(todoItem);
	}
	
	public void delete(TodoItem todoItem) {
		todoItemRepository.delete(todoItem);
	}
}
