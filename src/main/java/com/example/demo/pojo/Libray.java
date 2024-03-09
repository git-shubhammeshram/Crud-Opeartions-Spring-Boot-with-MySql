package com.example.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Libray {
	
	@Id
	private int id;
	private String name;
	private String author;

	
	public Libray() {
		
	}

	public Libray(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	@Override
	public String toString() {
		return "Libray [id=" + id + ", name=" + name + ", author=" + author +"]";
	}
	
	

}
