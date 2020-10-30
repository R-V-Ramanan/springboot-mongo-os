package com.journaldev.bootifulmongodb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.ZipRepository;
import com.journaldev.bootifulmongodb.model.User;
import com.journaldev.bootifulmongodb.model.Zip;

@RestController
public class ZipController {
	
	@Autowired
	private ZipRepository repo;
	
	@GetMapping("/findByPop/{pop}")
	public List<Zip> findByPop(@PathVariable long pop)
	{
		System.out.println("find by Pop");
		return repo.findByPop(pop);
	}
	
	@GetMapping("/findByZip/{zip}")
	public List<Zip> findByZip(@PathVariable String zip)
	{
		System.out.println("find by zip");
		return repo.findByZip(zip);
	}
	
	@GetMapping("/findByState/{state}")
	public List<Zip> findByState(@PathVariable String state){
		System.out.println("findby state:"+state);
		return repo.findByState(state);
	}
	
	@GetMapping("/findByPopGT/{pop}")
	public List<Zip> filterByPop(@PathVariable long pop){
		System.out.println("filter by pop");
	
		return repo.findByPopGreaterThan(pop,Sort.by("pop").descending());
	}
	
	@GetMapping("/test1")
	public String testMessage() {
		System.out.println("testing1");
		return "Welcome to mongodb-boot zip";
	}
}
