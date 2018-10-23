package com.qouteapp.main.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="quote")
public class Quote {
	
	@Id
	public ObjectId _id;
	
   @Indexed(unique=true)
   public String qtitle;
   
   public String qdescription;
   
   public String qtprice;
   
   public ArrayList<Item> items;
   

	public ObjectId get_id() {
		return _id;
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getQtitle() {
		return qtitle;
	}
	
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	
	public String getQdescription() {
		return qdescription;
	}
	
	public void setQdescription(String qdescription) {
		this.qdescription = qdescription;
	}
	
	public String getQtprice() {
		return qtprice;
	}
	
	public void setQtprice(String qtprice) {
		this.qtprice = qtprice;
	}
	   	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	public String toString() {
		return "Quote{" +
                "_id='" + _id + '\'' +
                ", qtitle='" + qtitle + '\'' +
                ", qdescription='" + qdescription + '\'' +
                ", qtprice='" + qtprice + '\'' +   
                ", items='" + items + '\'' +  
                '}';
	 }	
	 
	 
	
	
  
}
