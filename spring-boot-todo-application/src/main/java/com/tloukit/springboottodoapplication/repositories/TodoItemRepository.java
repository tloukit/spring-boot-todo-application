package com.tloukit.springboottodoapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tloukit.springboottodoapplication.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{

}
