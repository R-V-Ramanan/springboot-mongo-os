package com.journaldev.bootifulmongodb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		repo.save(user);
		return "User added:"+user.getName();
	}
	
	@GetMapping("/findAll")
	public List<User> getUsers(){
		List<User> userList=repo.findAll(Sort.by("city").ascending().and(Sort.by("age").ascending()));
		return userList;
	}
	
	@GetMapping("/findAllPaging")
	public Page<User> getUsersPageable(){
		Pageable pageable=PageRequest.of(0	, 5, Sort.by("name"));
		Page<User> userList=repo.findAll(pageable);
		
		return userList;
	}
	
	@GetMapping("/findAllMT")
	public List<User> getUserTemp(){
		List<User> userList=mongoTemplate.findAll(User.class);
		return userList;
	}
	
	
	@GetMapping("/findOne")
	public User getUser(){
		Query query = new Query();
		query.addCriteria(Criteria.where("city").is("Kolkata"));
		return mongoTemplate.findOne(query, User.class);
		
	}
	
	@GetMapping("/findByCity/{city}")
	public List<User> findByCity(@PathVariable String city){
		System.out.println("findby city:"+city);
		return repo.findByCity(city);
	}
	
	
	
	
	
	
	/*
	 * @GetMapping("/filterByAge/{age}") public List<User> filterByAge(@PathVariable
	 * String age) { System.out.println("filter by age"); return
	 * repo.filterByAge(age); }
	 */
	
	
	
	@GetMapping("/test")
	public String testMessage() {
		System.out.println("testing");
		return "Welcome to mongodb-boot";
	}
}
