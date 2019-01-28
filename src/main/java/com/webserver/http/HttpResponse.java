package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpResponse {
	//状态行相关信息定义
	//传态代码
	private int statusCode =200;
	
	//响应头相关信息定义
	//key：响应头名字  value：响应头的值
	private Map<String , String>headers =new HashMap<String ,String>();
	//响应正文相关信息定义
	//响应实体文件
	private File entity;
	//和客户端连接的相关内容
	private Socket socket;
	private OutputStream out;
	
	public HttpResponse (Socket socket) {
		try {
		this.socket=socket;
		this.out=socket.getOutputStream();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void flush() {
		
		System.out.println("HttpResponse:开始发送响应。。。");
		sendStatusLine();//1发送状态行
		sendHeaders();//2放送响应头
		sendContent();//2发送响应正文
		System.out.println("HttpResponse：发送响应完毕。。。");
	}
	//1发送状态行
private void sendStatusLine() {
	try {
		System.out.println("开始发送状态行.......");//
		String line = "HTTP/1.1"+" "+statusCode+" "+HttpContext.getStatusReason(statusCode);
	out.write(line.getBytes("ISO8859-1"));
	out.write(13);//回车
	out.write(10);//ASCII码 空格
	System.out.println("发送状态行完毕.......");
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	

//2放送响应头
private void sendHeaders() {
	try {
		System.out.println("开始发送响应头。。。");
		//发送响应头
		Set<Entry<String,String>> entrySet
		               =headers.entrySet();
		for(Entry<String,String> header:entrySet) {
			String line=header.getKey()+": "+header.getValue();
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);
			out.write(10);
		}
		
		out.write(13);
		out.write(10);
		System.out.println("发送响应头完毕。。。");
		System.out.println(entity);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
//2发送响应正文
private void sendContent() {
	try (FileInputStream fis=new 	FileInputStream(entity))//导入到响应
	{
		
		System.out.println("开始发送响应正文......");
		//FileInputStream fis=new 	FileInputStream(entity);
		int len=-1;
		byte[] data =new byte[1024*10];
		while((len=fis.read(data))!=-1) {
			out.write(data, 0, len);
		}
		System.out.println("发送响应正文完毕......");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public File getEntity() {
	return entity;
}
//设置正文实体文件，在设置的同时会自动添加对应正文的两个响应头
//content-Type与Content-Length
public void setEntity(File entity) {
	this.entity = entity;
	//根据实体文件设置响应头
	//根据实体文件的后缀获取对应的介质类型
		String fileName=entity.getName();
		int index=fileName.lastIndexOf(".");
		String ext=fileName.substring(index+1);
		String type=HttpContext.getMimeType(ext);
	this.headers.put("Content-Type", type);
	this.headers.put("Content-Lenth", String.valueOf(entity.length()));
}
public int getStatuscode() {
	return statusCode;
}
public void setStatuscode(int statuscode) {
	this.statusCode = statuscode;
}
//设置响应头 name 响应头名字 value 响应头对应的值
public void putHeader(String name,String value) {
	    headers.put(name, value);
}
public  String gerHeader (String name) {
	return headers.get(name);
}


}
