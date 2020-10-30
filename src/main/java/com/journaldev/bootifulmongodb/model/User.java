package com.journaldev.bootifulmongodb.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {

	
	private String name;
	private String age;
	private String city;
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(String name, String age, String city) {
		
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
