package com.tloukit.springboottodoapplication.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todo_item")
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	private boolean complete;
	private Instant createdDate;
	private Instant modifiedDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public TodoItem() {
		
	}
	public TodoItem(String description) {
		this.description = description;
		this.complete = false;
		this.createdDate = Instant.now();
		this.modifiedDate = Instant.now();
	}
	
	@Override
	public String toString() {
		return String.format("TodoItem={id=%d, description='%s', complete='%s', createdDate='%s', "
				+ "modifiedDate='%s'}", id, description, complete, createdDate, modifiedDate);
	}
		
}
