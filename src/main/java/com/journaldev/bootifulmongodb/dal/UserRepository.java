package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, PagingAndSortingRepository<User, String> {

	List<User> findByCity(String city);
	
	Page<User> findAll(Pageable pageable);
	
	//List<User> filterByAgeGreaterThan(String age);
	

	
}
