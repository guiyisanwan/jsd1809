package com.webserver.serverlet;

import java.io.File;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

//Servlet得超类，定义所有Servlet都具有得共性
public abstract class HttpServlet {
	public abstract void service(HttpRequest request,HttpResponse response) ;
	/**
	 * 跳转到指定得页面
	 * 该
	 * @param url
	 * @param request
	 * @param response
	 */
	public void forward (String url,HttpRequest request,HttpResponse response ) {
		File file=new File("webapps/"+url);
		response.setEntity(file);
		
	};
		
	

}
