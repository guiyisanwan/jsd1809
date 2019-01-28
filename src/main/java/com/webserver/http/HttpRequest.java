package com.webserver.http;

import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.webserver.serverlet.HttpServlet;

/*
 * 每个请求为一个实列
 * 每个请求有三步分：行，头，正文
 */
public class HttpRequest {
	/*
	 * 请求行消息定义
	 */
	//请求的方式
	private String method;
	//请求资源的抽象路径
	private String url;
	//协议版本
	private String protocol;
	//url中的请求部分
	private String requestURI;
	//url中的参数部分
	private String queryString;
	//
	private Map<String,String> parameters=new HashMap();
	private Map<String,String > headers = new HashMap();//对象身上的物件
	
	 // 消息头关系定义
	// 消息正文相关信息定义
	private Socket socket;
	private InputStream in;
	//构造方法
	 // 要获取客户端请求信息，以初始化请求对象，就必须先传入socket,以此获得数入流
	public  HttpRequest(Socket socket)throws  EmptyRuqestException{
		 
		try {
			this.socket=socket;
			this.in=socket.getInputStream();
			
		//	通过socket获取输入流，
			//解析以个信息分为三步
			 //1：解析请求行
			parseRequestline ();
			 //2：解析消息头
			   parseHeaders();
			 //3：解析消息正文
			  parsecontents();
		}catch(EmptyRuqestException e) {
			//空请求不出里，直接抛给clienhandler
		throw e;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("HpptRequest:初始化请求完毕");
	}
	//解析请求行
	private void parseRequestline ()throws EmptyRuqestException{
		System.out.println("开始解析请求行");
		//读取一行字符串
		String line =readLine();
		System.out.println("请求行内容："+line);
		if("".equals(line)) {
			//空请求，抛出空请求异常
			throw new EmptyRuqestException();
		}
		/*
		 * 将请求行的三个信息分别解析出来，并设置到对应的三个属性上
		 * method,ur1,protocol
		 */
		/**
		 * 这里后面的测试可能会出现数组下标越界，这是由于客户发送空请求‘这种情况为HTTP协议允许
		 */
		String[]data=line.split("\\s");
		this.method=data[0];
		this.url=data[1];
		this.protocol=data[2];
		System.out.println("method:\t"+method);
		System.out.println("ur1:\t"+url);
		System.out.println("protocol:\t"+protocol);
		//进一步解析url部分
		parseUrl();
		System.out.println("解析请求行完毕");
	}
	private void parseUrl() {
		System.out.println("进一步解析url...");
		if(!url.contains("?")/*url.indexOf("?")!=-1*/) {
			requestURI=url;
		}else if(url.indexOf("?")!=-1) {
			String[]data2=url.split("\\?");
			requestURI=data2[0];
			System.out.println(requestURI);
			if(data2.length>1) {
			queryString=data2[1];
			String[]data3=queryString.split("\\&");
			for(String str:data3) {
				String[]data4=str.split("\\=");
				if(data4.length>1) {
				parameters.put(data4[0], data4[1]);
				}else {
					parameters.put(data4[0], null);
					
					
				}
			}
				
			}
			
		}
			
		
		System.out.println("requestURI:"+requestURI);
		System.out.println("queryString:"+queryString);
		System.out.println(parameters);
		System.out.println("url解析完毕");
		
	}
	//解析消息头
private void parseHeaders() {
	System.out.println("开始解析消息头");
	/*
	 * 循环调用readline方法，读取若干消息头，当返回值为空字符串时，那应当时单独读到了CRLF
	 * 这时就可以停止读取了。当读取到消息头后，我们可以按“：”进行拆分，这样就可以拆分出两项
	 * 第一项就是消息头的名字，第二项就是消息头的值，我们将名字作为key，将值作为value保存到
	 * 属性headers这个map中，最终完成解析消息头的工作。
	 */
	//String line=null;//null不等于“ ”空白，因为null表示引用装的地址为空，而“”表示引用指向的
	//while(!((line=	readLine( )).equals(""))) {//的内容为空，而此处空白的地址是存在的
	for(String line=null;!((line=	readLine( )).equals(""));) {
   //line=	readLine( );
   String[]data=line.split(":");
   headers.put(data[0], data[1]);
	}
	System.out.println(headers);
	System.out.println("解析消息头完毕");
		System.out.println(getUr1());
		//System.out.println(getHeaders(String Cache-Control));
	}
//解析消息正文
private void parsecontents() {
	System.out.println("开始解析消息正文");
	System.out.println("解析消息正文完毕");
	
}
/**
 * 通过客户端对应的输出流中读取客户端发送过来的以行字符Cache-Control串，以CRLF作为以行结束的标志。返回的
 * 这行字符串中不含有后面的CRLF
 * @param in
 * @return
 */
//行读取方法
private String readLine() {//不把in这个输入流传入，也可以在方法体里直接使用
	StringBuilder builder=new StringBuilder();//因为in全局变量
	try {
		//StringBuilder builder=new StringBuilder()Cache-Control;
		int d=-1;
		char c1='a', c2='a';
		while((d=in.read())!=-1) {
			c2=(char)d;
		if(c1==13&&c2==10) {
			break;
		}
		builder.append(c2);
		//System.out.println(builder);
		c1=c2;
		}
		//return builder.toString().trim();
	}catch(Exception e) {
		//return builder.toString().trim();
	}
	return builder.toString().trim();
}

public String getMethod() {
	return method;
}
public String getUr1() {
	return url;
}
public String getProtocol() {
	return protocol;
}
public String getHeaders(String name) {//此方法何意
	
	return headers.get(name);
}
public String getRequestURI() {
	return requestURI;
}
public String getQueryString() {
	return queryString;
}	
public String getParameter(String name) {
	return this.parameters.get(name);//key
}
	

}