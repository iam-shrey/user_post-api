package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class Name {
	private String firstName;
	private String lasttName;
	
	public Name(String firstName, String lasttName) {
		super();
		this.firstName = firstName;
		this.lasttName = lasttName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLasttName() {
		return lasttName;
	}
	
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lasttName=" + lasttName + "]";
	}
}
