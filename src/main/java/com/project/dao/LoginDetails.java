package com.project.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {
	@Id
String uname;
String pass;
public LoginDetails() {
	super();
}
public LoginDetails(String uname, String pass) {
	super();
	this.uname = uname;
	this.pass = pass;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "LoginDetails [uname=" + uname + ", pass=" + pass + "]";
}
	
	
}
