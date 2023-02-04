package com.tloukit.springboottodoapplication.controllers;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tloukit.springboottodoapplication.models.TodoItem;
import com.tloukit.springboottodoapplication.repositories.TodoItemRepository;
import com.tloukit.springboottodoapplication.services.TodoItemService;

import jakarta.validation.Valid;

@Controller
public class TodoItemController {
	private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);
	
	@Autowired
	private TodoItemService todoItemService ;
	
	
	
	/*@PostMapping("/todo/{id}")
	public String modifierTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem,
										BindingResult result, Model model) {
		if(result.hasErrors()) {
			todoItem.setId(id);
			return "modifier-todo-item";
		}
		todoItem.setModifiedDate(Instant.now());
		todoItemRepository.save(todoItem);
		return "redirect:/";
		
		
	}*/
	
	

}
