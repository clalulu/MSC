package it.msc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
 
import it.msc.model.User;
import it.msc.util.DbCon;
//import it.msc.util.PageBean;
 
public class UserDao {

public User findUserByname(String username) {
 
DbCon dbcon = new DbCon();
Connection con = null;
User user = null;
String sql = "SELECT * FROM user WHERE username=?";
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, username);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
 
user = new User();
user.setUsername(rs.getString("username"));
user.setPassword(rs.getString("password"));
user.setEmail(rs.getString("email"));
user.setcf(rs.getString("cf"));
user.setId(rs.getInt("id"));
 
}
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
	finally {
 
	try {
 
		dbcon.closeCon(con);
 
		} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return user;
 
}
 

public User findUserByemail(String email) {
 
DbCon dbcon = new DbCon();
Connection con = null;
User user = null;
String sql = "SELECT * FROM user WHERE email=?";
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, email);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
 
user = new User();
user.setUsername(rs.getString("username"));
user.setPassword(rs.getString("password"));
user.setEmail(rs.getString("email"));
user.setcf(rs.getString("cf"));
user.setId(rs.getInt("id"));
 
}
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
} finally {
 
try {
 
dbcon.closeCon(con);
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return user;
 
}

public int addUser(User  user) {
 
DbCon dbcon = new DbCon();
Connection con = null;
int a=0;
String sql = "INSERT into user values(t_user_seq.nextval,?,?,?,?,null,null)";     //VEDERE
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, user.getUsername());
pstmt.setString(2, user.getPassword());
pstmt.setString(3, user.getEmail());
pstmt.setString(4, user.getcf());
a= pstmt.executeUpdate();
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
} finally {
 
try {
 
dbcon.closeCon(con);
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return a;
 
}



 
public int updateUserLogin(User  user) {
 
DbCon dbcon = new DbCon();
Connection con = null;
int a=0;
String sql = "UPDATE user SET lastlogintime=?,ip=? where id=?";
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, user.getLastlogintime());
pstmt.setString(2, user.getIp());
pstmt.setInt(3, user.getId());
a= pstmt.executeUpdate();
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
} finally {
 
try {
 
dbcon.closeCon(con);
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return a;
 
}
 
 

public int updateUserPassWord(User  user) {
 
DbCon dbcon = new DbCon();
Connection con = null;
int a=0;
String sql = "UPDATE t_user SET password=? where id=?";
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, user.getPassword());
pstmt.setInt(2, user.getId());
a= pstmt.executeUpdate();
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
} finally {
 
try {
 
dbcon.closeCon(con);
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return a;
 
}
 

/*public  ResultSet showUser(PageBean page){
 
Connection con = null;
ResultSet rs=null;
String sql = "select * from ( select rownum rn ,a.* from t_user a ) where   rn >? and rn <=? order by id   ";
try {
 
con = DbCon.getCon();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, page.getStart());
pstmt.setInt(2, page.getRows());
rs = pstmt.executeQuery();
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
return rs;
 
}*/
 

public int userCount() {
 
DbCon dbcon = new DbCon();
Connection con = null;
ResultSet rs = null;
int count = 0;
String sql = "SELECT COUNT(*) AS total FROM  user   ";
try {
 
con = DbCon.getCon();
PreparedStatement tmt = con.prepareStatement(sql);
rs = tmt.executeQuery();
while (rs.next()) {
 
count = rs.getInt("total");
 
}
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
} finally {
 
try {
 
dbcon.closeCon(con);
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}
 
}
return count;
 
}
 

public int deleteUser(int id){
 
    DbCon dbcon=new DbCon();
    int result=0;
    Connection con=null;
    try {
 
con=DbCon.getCon();
String sql="DELETER  FROM user WHERE id=? ";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setInt(1, id);
result=pstmt.executeUpdate();
 
} catch (Exception e) {
 
// TODO Auto-generated catch block
e.printStackTrace();
 
}finally{
 
try{
 
dbcon.closeCon(con);
 
}
catch(Exception e){
 
e.printStackTrace();
 
}
 
}
    return result;
     
}
 
}