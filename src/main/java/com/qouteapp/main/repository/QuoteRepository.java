package com.qouteapp.main.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qouteapp.main.model.Quote;

@Repository
public interface QuoteRepository extends MongoRepository<Quote,String> {
	
	public Quote findBy_id(ObjectId id);
	
	public Quote findByqtitle(String qtitle);
	
	public boolean deleteBy_id(ObjectId id);

}
