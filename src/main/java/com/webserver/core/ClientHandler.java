package com.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.stream.IntStream;

import com.webserver.http.EmptyRuqestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.serverlet.HttpServlet;
import com.webserver.serverlet.LoginServlet;
import com.webserver.serverlet.RegServlet;

public class ClientHandler implements Runnable {
	private Socket socket;
	//构造方法
	public ClientHandler(Socket socket) {
		this. socket=socket;
	}
	//运行方法
	public void run() {
		try {
			
			//1准备工作
			//1解析请求//获得用户的请求，然后分解，并初始化
			System.out.println("Clienhandler:开始解析请求....");
			HttpRequest request = new HttpRequest(socket);
			System.out.println("Clienhandler:解析请求完毕");
			//HttpResponse response=new HttpResponse(socket);
			//2处理请求//根据路径获取资源，将资源导入响应
			System.out.println("Clienhandler:开始处理响应....");//处理请求，即响应
			HttpResponse response=new HttpResponse(socket);
			//获取资源路径
			String url=request.getRequestURI();
			System.out.println(url);
			//先判断是佛为请求业务
			String servletName=ServerContext.getServerlet(url);
			
			if(servletName!=null) {
				//利用反射加载并实列化对应得Sverlet
				Class cls=Class.forName(servletName);
				HttpServlet servlet =(HttpServlet)cls.newInstance();
				servlet.service(request, response);
				
			}
			//首先判断是否为请求注册业务
			/*if("/myweb/reg".equals(url)) {//客户管理者判断请求是注册请iu求还是登录请求，是前者就就交给
				RegServlet sevlet=new RegServlet();//注册业务专员
				sevlet.service(request, response);//注册业务专员从处理请求专员那得到注册信息，写入一个文档，存入当前目录下面
			}else if("/myweb/login".equals(url)) {//再通过响应负责人将注册成功得界面发送给客户
				LoginServlet sevlet=new LoginServlet();//登录业务专员从处理请求专员那得到登录信息，再通过读写工具读取注册文档
				sevlet.service(request, response);//里得注册信息，并与之比对，比对成功则通过响应者，将登录成功得页面发给登录客户
			}*/else {//如果客户是查找服务器所存之资料，则管理者自己根据客户发送得路径去找文件资料，存在，就通过响应者发出
			File file=new File("./webapps"+url);//不存在，就回复一个不存在页面
			if(file.exists()) {
				System.out.println("资源已找到");
				//将改资源设置到响应
				response.setEntity(file);
			}else {
			System.out.println("资源未找到");
			//响应404
			//设置response中的状态代码为404
			response.setStatuscode(404);
			//设置404页面
			File notFoundFile=new File("webapps/root/404.html");//是列化一个404页面
			//response.putHeader("Content-Type", "text/html");
			//response.putHeader("Content-length", /*String.valueOf(file.length())*/notFoundFile.length()+"");
			//将改资源设置到响应
			response.setEntity(notFoundFile);//导入响应发射文档
			}
			}
			response.flush();
			System.out.println("Clienhandler:处理响应完毕");
			
		}catch (EmptyRuqestException e) {
			System.out.println("空请求");
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();//挂电话
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
		
	

}
