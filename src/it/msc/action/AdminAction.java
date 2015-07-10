package it.msc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import net.sf.json.JSONObject;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
 
import it.msc.dao.AdminDao;
import it.msc.model.Admin;
//import it.msc.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
 
public class AdminAction extends ActionSupport implements ServletRequestAware{
 
private static final long serialVersionUID = 1L;
AdminDao admindao=new AdminDao();
private Admin admin;
private String oldpassword; 
private String newpassword;
private String repassword;
private HttpServletRequest request;
 
public Admin getAdmin() {
 
return admin;
 
}
public void setAdmin(Admin admin) {
 
this.admin = admin;
 
}

public String getOldpassword() {
 
return oldpassword;
 
}
public void setOldpassword(String oldpassword) {
 
this.oldpassword = oldpassword;
 
}
public String getNewpassword() {
 
return newpassword;
 
}
public void setNewpassword(String newpassword) {
 
this.newpassword = newpassword;
 
}
public String getRepassword() {
 
return repassword;
 
}
public void setRepassword(String repassword) {
 
this.repassword = repassword;
 
}

public String execute() throws Exception {
 
HttpSession session=request.getSession();
Admin Curentadmin=admindao.getAdmin(admin);
String ip=request.getRemoteAddr();

if(Curentadmin==null){
 
request.setAttribute("error", "用户名或密码错误！！");
return "failed";
 
}else{
 
session.setAttribute("Curentadmin", Curentadmin);
Curentadmin.setLoginip(ip);
admindao.UpdateAdmin(Curentadmin);
return "success";
 
}
 
}

/*public String updatePassword()throws Exception{
 
HttpSession session=request.getSession();
JSONObject result=new JSONObject();
Admin admin=(Admin)session.getAttribute("Curentadmin");
if(!repassword.equals(newpassword)){
 
result.put("errorMsg", "两次输入密码不一致！");
    ResponseUtil.write(ServletActionContext.getResponse(), result);
    return null;
 
}else if(!admin.getPassword().equals(oldpassword)){
 
result.put("errorMsg", "原密码不正确！");
    ResponseUtil.write(ServletActionContext.getResponse(), result);//返回信息
    return null;
 
}else {
 
admin.setPassword(newpassword);
int a=admindao.updateAdminPassWord(admin);
if(a!=0){
 
    ResponseUtil.write(ServletActionContext.getResponse(), result);//返回信息
 
}
 
}
return null;
 
}*/

public String logout()throws Exception{
 
HttpSession session=request.getSession();
session.removeAttribute("Curentadmin");
return "logout";
 
}
public void setServletRequest(HttpServletRequest request) {
 
// TODO Auto-generated method stub
this.request=request;
 
}
 
}
