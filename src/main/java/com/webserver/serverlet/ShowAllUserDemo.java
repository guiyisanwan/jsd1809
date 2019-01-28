package com.webserver.serverlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class ShowAllUserDemo {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		RandomAccessFile raf
		= new RandomAccessFile("user.dat","r");//读写工具，并非文件本身，可以复制一份文件载到它上面
//		 public RandomAccessFile(String name, String mode)
//			        throws FileNotFoundException
//			    {
//			        this(name != null ? new File(name) : null, mode);
//	
	for(int i=0;i<raf.length()/100;i++) {
		//读用户名
		//1:读取32字节
		byte[] data = new byte[32];//读出来，放字符串因号内，输出
		raf.read(data);//public int read(byte b[]) throws IOException {//方法即出结果，又出效应
		//2:将字节数组还原为字符串
		String username = new String(data,"UTF-8").trim();//public String(byte bytes[], String charsetName)
																										//往引号里面放字节数组，且翻译成字符
		//读密码
		raf.read(data);
		String password = new String(data,"UTF-8").trim();
		
		//读昵称
		raf.read(data);
		String nickname = new String(data,"UTF-8").trim();
		
		//读年龄
		int age = raf.readInt();
		System.out.println(username+","+password+","+nickname+","+age);
	}
	
	raf.close();//关闭读写工具

	}

}
