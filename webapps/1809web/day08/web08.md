###JavaScript
- 给页面添加动态效果或动态内容

####变量 声明和赋值
- 弱类型 
int x = 10;
String s = "abc";
var x = 10;
var s = "abc";
x="mm";
####数据类型
1. 数值类型number
var x =10;   typeof x;
2. 字符串类型string
var s = "abc";
3. 布尔值类型 boolean
var b = true/false;   typeof b;
4. 对象类型       null
Person p = new Person();
var p = new Person();
5. 未定义 undefined
var a;
#####数据类型的隐式转换
1. String类型的隐式转换
- String转布尔值：  空字符串"" 转成false 其它全部true 
- String转数值：   能转直接转，不能转转成NaN(Not a Number)   任何数和NaN进行任何运算结果都是NaN       var  x = "abc"-18;
2. 数值类型的隐式转换
- 数值转字符串： 直接转 18->  "18"     var  x = "abc"+18;
- 数值转布尔值： 0和NaN转成false 其它是true  
3. 布尔值类型的隐式转换
- 转字符串： 直接转 true-> "true"  
- 转数值:  true->1     false->0
4. undefined的隐式转换
- 转字符串： 直接转
- 转数值：  NaN       20+undefined=NaN
- 转布尔值: false
5. null的隐式转换
- 转字符串： 直接转
- 转数值： 0        20+null  
- 转布尔值： false  

####运算符  + - * / %  ==  
- 大体和Java相同 
1. ==和===，==会先统一类型，然后再比较值是否相等， ===先比较类型是否相等如果相等再比较值是否相等      "18"===18
2. java: 3/2=1     js:3/2=1.5   4/2=2;  js中除法运算会自动转换整数和小数
3. typeof      typeof 66 + 6 = "number6"

####语句：if else if  while for switch case
- 和java基本相同
1. if和while括号里面的内容 如果不是布尔值会自动转成布尔值
2. for里面int i 改成 var i   不支持增强for循环(foreach)

####方法声明
- java中声明有返回值有参数（字符串和整数） 
	public String run(String name,int age){
		return name+age;
	}
- JavaScript方法声明的格式一： function 方法名(参数列表){ 方法体 }
- 第二种：
var 方法名 = function（参数列表）{方法体}
- 第三种：
var 方法名 = new Function("参数1","参数2","方法体");

###字符串相关
1. 把字符串转成数值
	parseInt("3.1")   3     parseInt(3.1)  3
	parseFloat("3") 3
	Number("3") 3
2. 字符串创建方式
	var str = "abc";
	var str = new String("abc");
3. 转大小写
	str.toUpperCase();
	str.toLowerCase();
4. 获取字符串中某个字符串出现的位置
	- str.indexOf("a");  第一个出现的位置
	- str.lastIndexOf("a");  最后一个出现的位置
5. 替换字符串
	str.replace(old,new);   //只能替换第一个
6. 拆分字符串    a,b,c    a   b   c
	var arr = str.split(",");
###数值相关
1. 四舍五入  toFixed(num)
	3.1415926.toFixed(2);
###数组相关
1. 创建数组  数组内什么类型都可以保存
	var arr = ["张飞",18,false];
	var arr = new Array();
2. 往数组中添加内容
	arr.push("aaa");
3. 获取和修改长度  js数组长度可以修改
	var arr = ["张飞",18,false];
	arr.length=1;
4. 数组取值 和Java一样
5. 数组反转  a  b  c   
	arr.reverse();
6. 数组排序  默认排序规则是通过Unicode编码挨个字符进行排序
	arr.sort();
- 自定义排序

	var arr = [3,2,33,31,18,22];
	/*自定义排序方法 */
	function mysort(a,b){
		//return a-b;//升序
		return b-a;//降序
	}
	//排序 
	arr.sort(mysort);
	alert(arr);
###页面相关
 var div = document.getElementById("d1");
 var ipt = document.getElementById("i1");



	

