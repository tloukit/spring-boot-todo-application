package com.tloukit.springboottodoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tloukit.springboottodoapplication.repositories.TodoItemRepository;

@Controller
public class TodoItemController {
	private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);
	
	@Autowired
	private TodoItemRepository todoItemRepository;
	
	@GetMapping("/")
	public ModelAndView index() {
		logger.debug("request to get the index page");
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("todoItems", todoItemRepository.findAll());
		return modelAndView;
	}
	
	

}
