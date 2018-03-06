package com.pikazza.micro.ws.web.users;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {

	long userId;
	String firstName;
	String lastName;
	String email;
	String mobileNo;
	
	public Users(long userId, String firstName, String lastName, String email, String mobileNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	public Users(){
		
	}
}
