package it.msc.model;

public class User {
	 
	 private int id;
	 private String username;
	 private String password;
	 private String repassword;
	 private String email;
	 private String cf;
	 private String ip;
	 private String lastlogintime;
	  
	public User(String username, String password, String repassword, String email,
	String cf) {
	 
	this.username = username;
	this.password = password;
	this.repassword = repassword;
	this.email = email;
	this.cf = cf;
		 
	}
	 
	public User(String username, String password, String email, String cf) {
	 
	this.username = username;
	this.password = password;
	this.email = email;
	this.cf = cf;
	 
	}
	 
	public User() {
	 
	 
	 
	}
	public int getId() {
	 
	return id;
	 
	}
	public void setId(int id) {
	 
	this.id = id;
	 
	}
	public String getUsername() {
	 
	return username;
	 
	}
	public void setUsername(String username) {
	 
	this.username = username;
	 
	}
	public String getPassword() {
	 
	return password;
	 
	}
	public void setPassword(String password) {
	 
	this.password = password;
	 
	}
	public String getRepassword() {
	 
	return repassword;
	 
	}
	public void setRepassword(String repassword) {
	 
	this.repassword = repassword;
	 
	}
	public String getEmail() {
	 
	return email;
	 
	}
	public void setEmail(String email) {
	 
	this.email = email;
	 
	}
	public String getcf() {
	 
	return cf;
	 
	}
	
	public void setcf(String cf) {
	 
	this.cf = cf;
	 
	}
	

	public String getIp() {
	 
	return ip;
	 
	}
	public void setIp(String ip) {
	 
	this.ip = ip;
	 
	}
	public String getLastlogintime() {
	 
	return lastlogintime;
	 
	}
	public void setLastlogintime(String lastlogintime) {
	 
	this.lastlogintime = lastlogintime;
	 
	}
	 
	 
	}