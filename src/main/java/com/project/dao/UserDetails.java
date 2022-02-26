package com.project.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserDetails {
String name;
String account;
String mob;
String address;
int aadhar;
@Id
String uname;
String password;
double balance;


public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}

public UserDetails(String name, String account, String mob, String address, int aadhar, String usernme,
		String password) {
	super();
	
	this.name = name;
	this.account = account;
	this.mob = mob;
	this.address = address;
	this.aadhar = aadhar;
	this.uname = usernme;
	this.password = password;
}
public String getUsernme() {
	return uname;
}
public void setUsernme(String usernme) {
	this.uname = usernme;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserDetails() {
	super();
}
public UserDetails(String name, String account, String mob, String address, int aadhar) {
	super();
	this.name = name;
	this.account = account;
	this.mob = mob;
	this.address = address;
	this.aadhar = aadhar;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getMob() {
	return mob;
}
public void setMob(String mob) {
	this.mob = mob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getAadhar() {
	return aadhar;
}
public void setAadhar(int aadhar) {
	this.aadhar = aadhar;
}
@Override
public String toString() {
	return "UserDetails [name=" + name + ", account=" + account + ", mob=" + mob + ", address=" + address + ", aadhar="
			+ aadhar + ", uname=" + uname + ", password=" + password + ", balance=" + balance + "]";
}

}
