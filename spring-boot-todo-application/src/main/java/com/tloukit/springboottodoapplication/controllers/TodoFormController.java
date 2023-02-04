package com.tloukit.springboottodoapplication.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tloukit.springboottodoapplication.models.TodoItem;
import com.tloukit.springboottodoapplication.services.TodoItemService;

import jakarta.validation.Valid;


@Controller
public class TodoFormController {
	private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);
	
	@Autowired
	private TodoItemService todoItemService;
	
	@GetMapping("create-todo")
	public String showCreateForm(TodoItem todoItem) {
		return "new-todo-item";
		
	}
	
	@PostMapping("/todo")
	public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
		TodoItem item = new TodoItem();
		item.setDescription(todoItem.getDescription());
		item.setIsComplete(Boolean.FALSE);
		
		todoItemService.save(item);
		return "redirect:/";
	}
	
	@GetMapping("modifier/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TodoItem todoItem = todoItemService.getById(id)
							.orElseThrow(() -> new IllegalArgumentException("l'identifiant de la tâche " + id + " n'a pas été trouvé"));
		model.addAttribute("todoItem", todoItem);
		return "modifier-todo-item";
	}
	
	@PostMapping("todo/{id}")
	public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
		TodoItem item = todoItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("l'identifiant de la tâche " + id + " n'a pas été trouvé"));
		
		item.setIsComplete(todoItem.getIsComplete());
		item.setDescription(todoItem.getDescription());
		
		todoItemService.save(item);
		return "redirect:/";
	}
	
	@GetMapping("supprimer/{id}")
	public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
		TodoItem item = todoItemService.getById(id)
						.orElseThrow(() -> new IllegalArgumentException("l'identifiant de la tâche " + id + " n'a pas été trouvé"));
		todoItemService.delete(item);
		return "redirect:/";
		
		/* Autre façon de faire : on wrappe item de type TodoItem dans un Optional
		  						  si optional "isPresent" alors on récupère l'objet qui est wrappé dans l'optional 
		Optional<TodoItem> itemOptional = todoItemService.getById(id);
		if(itemOptional.isPresent()) {
			item = itemOptional.get();
		}
		*/
		
		
	}
	

}
