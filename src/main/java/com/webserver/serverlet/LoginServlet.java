 package com.webserver.serverlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpRequest request,HttpResponse response) {
		System.out.println("LoginServlet :开始处理登录业务");
		//1获取用户登录信息
				String username =request.getParameter("username");
				String password =request.getParameter("password");
				System.out.println("username:"+username);
			  System.out.println("password:"+password);
	/**
	* 然后通过RandomAccessFile读取user.dat文件，顺序读取每个
    用户的名字与该用户名比对，若找到则比对密码，若密码输入正确
    则跳转登录成功页面。
    若密码输入错误，或该用户在user.dat文件中不存在，则跳转
    登录失败页面
	*/
			  try {
					RandomAccessFile raf=new 	RandomAccessFile("user.dat","r");
					
			    	int a=0;
			    	for(int i=0;i<raf.length()/100;i++) {
			    		raf.seek(100*i);
			    		byte[] data = new byte[32];
			    		raf.read(data);
			    		String name = new String(data,"UTF-8").trim();
			    		System.out.println("username1:"+name);
			    		
			    		raf.read(data);
			    		String pwd = new String(data,"UTF-8").trim();
			    		System.out.println("password1:"+pwd);
			    		if(username.equals(name)&&password.equals(pwd)) {
			    				forward("/myweb/login_seccess.html",request,response);
			    				
			    				a=1;
			    				break;
			    		}
			    
			    	}
			    	if(a==0) {
			    		forward("/myweb/login_fain.html",request,response);
	    				
			    	}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			  System.out.println("处理登录业务完毕");

}
}