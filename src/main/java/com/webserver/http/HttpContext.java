package com.webserver.http;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
                                                      //
public class HttpContext {//http上下文，里存了一个状态码和状态描叙的映射表,和通过状态代码找状态描叙的静态方法
//状态码与状态描叙的对应
	//key：状态代码
	//value:状态描叙
	private static Map<Integer,String> statusReasonMapping//状态理由地图表
	                                  =new HashMap<Integer,String>();
	//初始化介质类型映射  
	/**
	 * 资源文件后缀与对应的介质类型定义的对应关系
	 * key：资源文件的后缀名
	 * value：Content-Type,对应的值
	 */
	private static Map<String,String>mimeMapping
	      															= new HashMap<String,String>();
	static {//初始化
	 	initStatusMapping();
	 	initmimeMapping();
		
	}
	private static void initStatusMapping(){//初始化情况映射
		statusReasonMapping.put(		200 ,   "OK");
		statusReasonMapping.put(201 ,   "Created");
		statusReasonMapping.put(202 ,   "Accepted");
		statusReasonMapping.put(204  ,  "No Content");
		statusReasonMapping.put(301 ,   "Moved Permanently");
		statusReasonMapping.put(302 ,   "Moved Temporarily");
		statusReasonMapping.put(304 ,   "Not Modified");
		statusReasonMapping.put(400 ,   "Bad Request");
		statusReasonMapping.put(401  ,  "Unauthorized");
		statusReasonMapping.put(403  ,  "Forbidden");
		statusReasonMapping.put(404 ,   "Not Found");
		statusReasonMapping.put(500  ,  "Internal Server Error");
		statusReasonMapping.put(501  ,  "Not Implemented");
		statusReasonMapping.put(502   , "Bad Gateway");
		statusReasonMapping.put(503   , "Service Unavailable");
	}//通过后缀找类型
	public static void initmimeMapping(){//初始化媒体类型映射//媒体类型扩展,扩展即后缀与格式的意思
		//解析项目目录中的conf目录里的web.xml文件
		//将根元素中的所有字元素《mime-mapping>解析出来，并将其中的子元素《extenstion>中
		//的文本作为key，<mime-type>中的文本作为value存入到mimeMapping这个Map中，完成初始化操作
		try {
		SAXReader reader =new SAXReader();
		Document doc = reader.read(new File("./conf/web.xml"));//java默认./存在，这个.就代表当前目录
		
		Element root =doc.getRootElement();//即项目目录
		List<Element>List= root.elements("mime-mapping");
		System.out.println("mime-mapping"+"有"+List.size()+"个");
		for(Element mimeEle:List) {
			String key =mimeEle.elementText("extenstion");
			String value =mimeEle.elementText("mime-type");
			mimeMapping.put(key,value );
		}
		//System.out.println(mimeMapping);
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		/*
		//mimeMapping.put("", value)
//		mimeMapping.put("html",  "text/html");
//		mimeMapping.put("png",    "image/png");
//		mimeMapping.put("gif" ,  "image/gif");
//		mimeMapping.put("jpg",    "image/jpeg");
//		mimeMapping.put("css ",   "text/css");
//		mimeMapping.put("js",     "application/javascript");*/

		
	}
	
		public static String getStatusReason/*获得状态描述*/(int code) {
			return statusReasonMapping.get(code);
	}
		public static String getMimeType(String ext) {
			return mimeMapping.get(ext);
		}
		public static void main(String[] args) {
			String type =getMimeType("png");
			System.out.println(type );
			String str="logo.png";
//			String[]data=str.split("\\.");
//			type =getMimeType(data[data.length-1]);
			int index=str.lastIndexOf(".");
			type=getMimeType(str.substring(index+1));
			System.out.println(type );
			
			
		}
}
