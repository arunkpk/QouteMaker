package com.qouteapp.main.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qouteapp.main.model.Quote;
import com.qouteapp.main.repository.QuoteRepository;

//Service that has CRUD methods for Quote Class
@Service
public class QuoteService {
	
	@Autowired
	public QuoteRepository Qrepo;
	
	//Create
	public String createQoute(Quote newquote) {	
		
		try {			
			Qrepo.save(newquote).get_id();			
			System.out.println("test");
			return "success";
		} catch (Exception  e) {
			System.out.println(e.getMessage());
		     return e.toString();
		}		
	}
	
    //Read By Qtitle	
	public Quote readQuote(String qtitle) {			
		return Qrepo.findByqtitle( qtitle);		
	}
	
	//Read By ID	
	public Quote readQuotebyID(ObjectId id) {
		System.out.println("Input Id ="+id);
			Quote qt=Qrepo.findBy_id(id);			
			System.out.println("output id ="+qt.get_id());
			System.out.println(id.getClass());
			return Qrepo.findBy_id(id)	;
	}
	
	
	//ModifyQuote By ID	
	public Quote UpdateQuotebyID(ObjectId id,Quote updQuote) {
		
		    Quote qt=Qrepo.findBy_id(id);
		    
		    qt.setQtitle(updQuote.getQtitle());
		    qt.setQdescription(updQuote.getQdescription());
		    qt.setQtprice(updQuote.getQtprice());
		    qt.setItems(updQuote.getItems());
		    
		    Quote updatedQuote= Qrepo.save(qt);
		    
		    System.out.println(updatedQuote);
			return updatedQuote;
	}	
	
	//ModifyQuote By ID	
		public String DeleteByID(ObjectId id) {
			
			    System.out.println("id=="+id);
			    
			    Quote qt=Qrepo.findBy_id(id);
			    System.out.println(qt);	
			     Qrepo.delete(qt);  
			     System.out.println("deleted");	    
			  
				return "hello";
		}	
	
	/*
	//DeleteQuote By ID
	
	public String DeletebyId(ObjectId id) {
		System.out.println("3e4r");
		Quote qt=Qrepo.findBy_id(id);
		System.out.println(qt);
		System.out.println("asdasd");
		if(qt.get_id()!=null) {
			Qrepo.deleteBy_id(id);
			return "Quotation Deleted";
		}else {
			return "Qoutation doesnt exist";
		}
		
		
	}
	
	*/
	
	

}
