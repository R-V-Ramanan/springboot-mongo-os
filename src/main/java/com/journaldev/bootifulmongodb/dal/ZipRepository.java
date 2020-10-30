package com.journaldev.bootifulmongodb.dal;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import com.journaldev.bootifulmongodb.model.Zip;

@Repository
public interface ZipRepository extends MongoRepository<Zip, String>{
	List<Zip> findByPop(long pop);
	
	List<Zip> findByZip(String zip);
	
	List<Zip> findByState(String state);
	
	//@Query(sort= "{pop:-1}")
	List<Zip> findByPopGreaterThan(long pop, Sort sort);
	
}
