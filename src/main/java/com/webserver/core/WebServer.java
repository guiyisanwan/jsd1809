 package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class WebServer {//主类
	private ServerSocket server;//服务器端含一个服务器套接字
	private ExecutorService threadPool;
	//构造方法
	public WebServer() {//
		try {
			server=new ServerSocket(8088);//服务器套接字申请端口，
			threadPool=Executors.newFixedThreadPool(30);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//启动方法
	public void start() {
		try {
			while(true) {
			System.out.println("等待客户端连接。。。");
			Socket socket = server.accept();//服务器套接字监听朱塞端口，有客户则返回一个套接字
			System.out.println("一个客户连接上了");//
			Runnable handler=new ClientHandler(socket);//传此套接字到服务器管理者那
			//传服务器管理者到线程池
			threadPool.execute(handler);
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//主方法
	public static void main(String[] args) {
		WebServer server=new WebServer();//创建并初始化服务器端
		server.start();//服务器启动方法
	}

}
