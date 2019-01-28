package com.webserver.core;

import java.util.HashMap;
import java.util.Map;

public class ServerContext {//服务器上下文里存了一个路径与类的映射表.和一个通过路径找类的方法
	
	private static Map <String,String> serletMapping=new HashMap<String,String>();
	static {
		initServletMapping();//静态块内只能调用静态方法
	}
private static void initServletMapping() {
	serletMapping.put("/myweb/reg","com.webserver.serverlet.RegServlet");
	serletMapping.put("/myweb/login","com.webserver.serverlet.LoginServlet");
}
public static String getServerlet(String url) {
	return serletMapping.get(url);
}

}
