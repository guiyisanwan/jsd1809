package com.webserver.serverlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class RegServlet extends HttpServlet {
	public void service(HttpRequest request,HttpResponse response) {
		System.out.println("Regserverlet:开始处理注册业务");
		//1获取用户注册信息
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String nickname =request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
				System.out.println("username:"+username);
		    System.out.println("password:"+password);
		    System.out.println("nickname:"+nickname);
		    System.out.println("age"+age);
		    /**
		     * 2,将用户注册信息写入文件use.rdat
		     * 每个用户占用100个字节，其中用户名，密码，昵称为字符串
		     * 格占32个字节，年龄为int值占固定的4字节
		     */
		    try {
		    
		    	RandomAccessFile raf=new 	RandomAccessFile("user.dat","w");
		    	raf.seek(raf.length());//将指针设置到末尾的原因，是为了不覆盖上次运行写入的注册名
		    	byte[]data=username.getBytes("utf-8");//指针随眼随笔运动
		    	data=Arrays.copyOf(data, 32);//将字符串转化为字节
		    	raf.write(data);
		    
		    	
		    	data=password.getBytes("utf-8");
		    	data=Arrays.copyOf(data, 32);
		    	raf.write(data);
		    	
		    	
		    	data=nickname.getBytes("utf-8");
		    	data=Arrays.copyOf(data, 32);
		    	raf.write(data);
		   
		    	raf.writeInt(age);
		    forward("webapps/myweb/reg_success.html",request,response);
		   
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				System.out.println("Regserverlet:处理注册业务完毕");
				
		
		
	}

}
