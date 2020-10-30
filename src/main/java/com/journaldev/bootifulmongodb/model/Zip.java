package com.journaldev.bootifulmongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="zips")
public class Zip {
	
	private String city;
	private String state;
	private String pop;
	private String zip;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPop() {
		return pop;
	}
	public void setPop(String pop) {
		this.pop = pop;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Zip(String city, String state, String pop, String zip) {
		
		this.city = city;
		this.state = state;
		this.pop = pop;
		this.zip = zip;
	}
	public Zip() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
