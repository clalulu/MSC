package it.msc.model;

public class Admin {
	 
private String username;
private String password;
private int id;
private String loginip;
private String logintime;
 
public String getLoginip() {
 
return loginip;
 
}
 
public void setLoginip(String loginip) {
 
this.loginip = loginip;
 
}
 
public String getLogintime() {
 
return logintime;
 
}
 
public void setLogintime(String logintime) {
 
this.logintime = logintime;
 
}
 
public String getUsername() {
 
return username;
 
}
 
public Admin(String username, String password, int id) {
 
this.username = username;
this.password = password;
this.id = id;
 
}
 
public Admin() {
 
 
 
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
 
public int getId() {
 
return id;
 
}
 
public void setId(int id) {
 
this.id = id;
 
}
 
}
