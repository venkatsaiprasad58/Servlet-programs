package com.ojas;

import java.io.Serializable;

public class Person implements Serializable {
	
	private int pid;
	private String ename;
	private String contactno;
	private String email;
	private String gender;
	private String address;
	
	
	
	
	public int getPid() {
		return pid;
	}


	public String getEname() {
		return ename;
	}


	public String getContactno() {
		return contactno;
	}


	public String getEmail() {
		return email;
	}


	public String getGender() {
		return gender;
	}


	public String getAddress() {
		return address;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Person() {
		super();
	}


	public Person(int pid, String ename, String contactno, String email, String gender, String address) {
		super();
		this.pid = pid;
		this.ename = ename;
		this.contactno = contactno;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}
	
	
	
	
	
}
