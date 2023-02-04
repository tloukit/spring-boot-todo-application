package com.tloukit.springboottodoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tloukit.springboottodoapplication.services.TodoItemService;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TodoItemService todoItemService;
	
	@GetMapping("/")
	public ModelAndView index() {
		logger.debug("request to get the index page");
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("todoItems", todoItemService.getAll());
		return modelAndView;
	}

}
