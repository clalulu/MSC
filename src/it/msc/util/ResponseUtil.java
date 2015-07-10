package it.msc.util;

import java.io.OutputStream;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
 
import com.opensymphony.xwork2.ActionContext;
 
public class ResponseUtil {
 
 
public static void write(HttpServletResponse response,Object o)throws Exception{
 
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	out.print(o.toString());
	out.flush();
	out.close();
 
}
 
public static void write1(Object o)throws Exception{
 
	HttpServletResponse response=(HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	out.println(o.toString());
	out.flush();
	out.close();
 
}

public static void export(HttpServletResponse response,Workbook wb,String fileName)throws Exception{
 
response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
response.setContentType("application/ynd.ms-excel;charset=UTF-8");
OutputStream out=response.getOutputStream();
wb.write(out);
out.flush();
out.close();
 
}
 
}