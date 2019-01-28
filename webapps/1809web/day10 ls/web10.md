###给元素对象添加样式
	div.style.样式名称="样式的值";

###元素隐藏的两种方式
1. visibility="hidden" //不脱离文档流 元素隐藏后仍然占位置
2. display="none"   //脱离文档流 不占位置



###Low轮播图实现步骤：
1. 在页面中添加一个div 在div里面添加三个img
2. 通过内部样式让img和div设置相同宽200高150
3. 在script标签中添加定时器 每隔1秒执行代码
4. 声明一个全局的count，在定时器中自增并且对3取余数 
5. 在定时器中获取所有图片并且遍历
6. 遍历时判断i的值是否等于第4步得到的余数，如果相等让当前遍历的图片元素显示，如果不等则让图片隐藏

####定时器
1. var timer = setInterval(方法,时间间隔)  每隔一段时间调用一次方法
	停止：clearInterval(timer)
2. setTimeout(方法,时间间隔)  隔一段时间调用一次方法（只执行一次）

###DOM 文档对象模型(包含和页面相关的内容)
- 学习DOM主要学习的就是如何对页面中的元素进行增删改查操作
####查找页面中的元素
1. 通过id查找元素
	var div = document.getElementById("id");
2. 通过标签名查找元素
	var arr = document.getElementsByTagName("标签名");
3. 通过class查找元素
	var arr = document.getElementsByClassName("class");
4. 通过name属性值查找元素
	var arr = document.getElementsByName("name");
5. 获取页面中body元素
	document.body
6. 获取元素的上级元素
	div.parentElement
###创建元素对象
	var h3 = document.createElement("h3");
	h3.innerHTML="我是h3";
###添加元素
	document.body.appendChild(h3);
###插入元素
	父元素.insertBefore(新元素,弟弟元素);
###删除元素
	父元素.removeChild(删除的元素); 
	删除的元素.parentElement.removeChild(删除的元素);

###事件的动态绑定
- 通过js代码给元素添加事件称为 事件的动态绑定，动态绑定的事件方法中的this代表事件源（添加事件的标签）





