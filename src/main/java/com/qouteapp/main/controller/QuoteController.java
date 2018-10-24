package com.qouteapp.main.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qouteapp.main.model.Project;
import com.qouteapp.main.model.Quote;
import com.qouteapp.main.service.QuoteService;

@RestController
public class QuoteController {	
	
	@Autowired
	public QuoteService Qservice;	
	
	//
	 @RequestMapping(value= {"/homew","/test"})
	 public String get() {
	      //mapped to hostname:port/home/
	        return "Hells23132so sdsdfrssom ssghhet";
	    }
	 
	 
	 @RequestMapping(value = "/id")
	    String getIdByValue(@RequestParam("id") String personId) {
	        System.out.println("ID is " + personId);
	        return "ID is " +personId+" Get ID from query string of URL with value element";
	    }
	 
	
	 @RequestMapping(value = "/getString", method = RequestMethod.GET)
	        public String[] createProj() {		       
		         String[] firstNames = { "Dennis", "Grace", "Bjarne", "James" };
	        	System.out.println("sdsdddd");
	           // String s = "Success...";
	            return firstNames;
	        }
	 
	 @RequestMapping(value = "/createProject", 
             produces = { "application/json" },          
             method = RequestMethod.GET)
     public ResponseEntity<Project> createProj1() {      
         return new ResponseEntity<Project>( new Project("success..."), HttpStatus.OK);
      }
	  
	 //Saving New Quote
	 @RequestMapping(value="/addquote",method = RequestMethod.POST)
	 public ResponseEntity<String> addquote(@RequestBody Quote newquote ) {
		 if( Qservice.createQoute(newquote)=="success") {
			 return new ResponseEntity<String>( "SuccessFully Created",HttpStatus.OK);	
		 } else {
			 return new ResponseEntity<String>( "Not Created",HttpStatus.BAD_REQUEST);	
		 }			 
	 }
	  	 
	 
	//Reading Single Quote
	 @RequestMapping(value="/readquote",method=RequestMethod.GET)
	 public ResponseEntity<Quote> readquote(@RequestParam("id") ObjectId 	id){					 
		
		   System.out.println("Request Param id="+id);
		     Quote qt=Qservice.readQuotebyID(id);
		     
		     ObjectId id1=qt.get_id();
		     System.out.println(id1);
		     String desc=qt.getQdescription();		    
		    
		     System.out.print("output desc=  😊😂"+desc);
		     
			 //System.out.println(qt);
			 return new ResponseEntity<Quote>(qt ,HttpStatus.OK) ;
			 
	 }
	 
     //Updating Single Quote
	 @RequestMapping(value="/updateQuote",method=RequestMethod.PUT,consumes= {MediaType.APPLICATION_JSON_VALUE})
	 public ResponseEntity<Quote> updateQuote(@RequestParam("id") ObjectId 	id,@RequestBody Quote updquote){				 
		
		    System.out.println("Request Param id="+id);		    		   
			    
		     Quote qt=Qservice.UpdateQuotebyID(id,updquote);	        
			 
			 return new ResponseEntity<Quote>(qt ,HttpStatus.OK) ;			 
	 } 
	 
	 
	 
	//Deleting Single Quote By ID
	 @RequestMapping(value="/deleteQuote",method=RequestMethod.GET)
	 public ResponseEntity<String> deleteQuote(@RequestParam("id") ObjectId id){	
		
		  System.out.println("hello");
		 
		 String st=Qservice.DeleteByID(id);
		 
		 return new ResponseEntity<String>( st,HttpStatus.OK) ;
		 
	 }
	 
	 
	
	 
	 
	 
	 
	 
	 
}
