####课程回顾
1. JavaScript 给页面添加动态效果
2. 引入方式：三种
- 内联： 在标签的事件中添加js代码
- 内部： 在head标签里面添加script标签 
- 外部： 在单独的js文件中写js代码 通过script标签的src属性引入
3. 数据类型：
- 字符串string
- 数值number
- 布尔值boolean
- 对象类型object     特殊值null
- 未定义类型undefined
4. 变量声明和赋值
- js属于弱类型的语言 ，声明变量时不需要指定类型都使用var 
5. 数据类型间的隐式转换 
- 字符串： 转数值（能转直接转，转不了转成NaN），转布尔值（""转false其它转true）
- 数值： 转字符串（直接转） 转布尔值（0和NaN转false 其它true）
- 布尔值：转字符串（直接转） 转数值（true转1  false转0）
- null：转字符串（直接转）转布尔值false 转数值0
- undefined：转字符串（直接转） 转布尔值 false  转数值NaN
6. 运算符 + - * /  == ===
	1. ==先统一类型再比较值   ===先比较类型再比较值
	2. 除法会自动转换整数和小数
	3. typeof    typeof 66+6 ="number6"
7. 语句 if else if  while   do while  for  switch  case
	1. if和while括号里面的内容如果不是布尔值会自动隐式转换成布尔值
	2. for循环中int i改成var i 不支持foreach
8. 方法声明
	1. function 方法名（参数列表）{方法体}
	2. var 方法名 = function(参数列表){方法体}
	3. var 方法名 = new Function（"参数1","参数2","方法体");
9. 字符串相关
	1. 转数值  parseInt   parseFloat   Number
	2. 创建字符串 var str = "abc";  var str = new String("abc");
	3. str.indexOf("a")  str.lastIndexOf("a")
	4. str.toUpperCase()   str.toLowerCase();
	5. str.replace(old,new);
	6. var arr = str.split(","); 
10. 数组相关
	1.  var arr = [1,2,3];  var arr = new Array();
	2. arr.push();	
	3. arr.length=3;
	4. 取值和java一样
	5. 反转 arr.reverse();
	6. 排序 arr.sort(mysort)  
		function mysort(a,b){ return a-b/b-a;}
11. 日期相关
	1. 创建客户端日期对象
		var d = new Date();
	2. 把字符串时间转成日期对象
		var d  = new Date("2018/12/6 09:17:33");
	3. 获取和设置时间戳
		d.getTime()   d.setTime(1000);
	4. 获取时间分量 
		d.getFullYear();
		d.getMonth();
		d.getDate();
		d.getHours();
		d.getMinutes();
		d.getSeconds();
		d.getDay();
	5. 获取年月日    获取时分秒
		d.toLocaledDateString();
		d.toLocaledTimeString();
12. 正则表达式
. 任意字符除了换行
\w 任意数字字母下划线
\d 任意数字
\s 任意空白
^ 开头
$ 结尾
- var reg = /规则/模式;
- var reg = new RegExp(规则,?模式);
- 查找  reg.exec(str);
- 校验  reg.test(str);
- 字符串查找 var arr = str.match(reg);
- 字符串的查找替换  str.replace(reg,new);

13. 和页面相关的内容
	1. 通过id查找元素对象
		var div = document.getElementById("d1");
	2. 获取和设置文本框的文本内容
		input.value="abc";
	3. 修改或添加元素的html内容
		div.innerHTML+="<h1>abc</h1>";
	4. 修改元素的class值
		div.className="abc";


####事件取消
- 在事件中执行return false; 则可以把当前事件取消掉

- 表单提交事件： onsubmit

- 元素隐藏显示
	visibility=hidden/visible

###JavaScript中的自定义对象

- 自定义对象两种方式：
1. 通过声明方法的方式创建对象
	function Person(name,age){
		//声明属性并赋值
		this.name=name;
		this.age=age;
		//声明方法
		this.run=function(){
			alert("name:"+name+"age:"+age);
		}
	}
	//创建person对象
	var p = new Person("关羽",20);
	p.run();
2. 通过声明变量的形式创建对象

	/* 第二种创建对象的方式 */
	var p2 = {
			"name":"曹操",
			"age":18,
			"run":function(){
				alert("name"+this.name
						+" age:"+this.age);
			}
	}
	//调用方法
	p2.run();


###DHTML
- Dynamic（动态）HTML， 并不是新的技术，是把html+css+JavaScript 一起实现出来的页面称为DHTML页面 
- DHTML内容包括 BOM和DOM 
- BOM Browser（浏览器）Object（对象）Model（模型） 浏览器对象模型，包括和浏览器相关的内容
- DOM Document（文档）Object（对象） Model（模型）文档对象模型，包括和页面相关的内容
####BOM相关
- window对象是内置对象，window对象内部的属性和方法称为全局属性和全局方法，调用时可以省略window.
	举例：     window.alert("xxx");
			isNaN()    parseInt  parseFloat   Number()
- window里面常用的属性：
1. history（历史）    
	history.length  历史页面数量
	history.back()  返回上一页面
	history.forward() 前往下一页面
	history.go(num) 1前往下一页面 0代表刷新 -1返回上一页面 -2返回上两个页面
2. location（位置）
	location.href   获取和修改浏览器访问的地址
	location.reload()  重新加载
3. screen （屏幕）
	screen.width/height 获得屏幕的分辨率
	screen.availWidth/availHeight 获得屏幕可用宽高
4. navigator （导航、帮助）
	navigator.userAgent(得到浏览器的版本信息)
- window中的一些常用方法
1. isNaN() 判断变量是否是NaN
2. parseInt() parseFloat() 把字符串转成数值
3. 弹出框： alert();
4. 确认框： confirm();
5. 弹出文本框： prompt();
- window相关的事件
1. 点击事件  onclick
2. 页面加载完成事件 onload
3. 获取焦点事件 onfocus
4. 失去焦点事件 onblur

####eval()
- 可以将字符串以js代码的形式执行  
eval("alert('xxx')");
alert("xxx");

####代码介绍
demo01 9宫格作业
demo02 登录校验 高级版
demo03 自定义对象 第一种方式
demo04 自定对象 第二种方式
demo05 通过location.href 实现页面跳转练习
demo06 window的四个事件
demo07 相对高级版计算器














