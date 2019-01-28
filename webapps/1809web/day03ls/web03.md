###课程回顾
1. 内容标题  h1-h6  独占一行 
2. 段落标签  p  独占一行
3. hr 和 br
4. 列表
- 无序列表  ul:type   li
- 有序列表  ol:type start reversed       li
- 定义列表  dl  dt  dd
- 列表嵌套
5. 分区元素   div和span    h5：header article footer
6. 元素分类
- 块级元素：独占一行  h1-h6 p  hr  div
- 行内元素：共占一行  span   strong b , u, em i, del s
7. 特殊字符   空格 &nbsp;   小于 &lt;  大于 &gt;
8. 图片标签  img：alt   src    title     width/height    
9. 图像地图  map：name     area： shape（rect、circle） coords（3，4）  href
###day02
1. 超链接 a：href   target="_blank"     锚点  
2. 表格标签 table:border cellspacing cellpadding  tr td:rowspan colspan  th  caption  thead  tbody tfoot
3. form表单  form:action  method:get/post   文本框 input type:text name placeholder maxlength readonly value,密码框 type:password  ,单选 radio  checked ，多选 checkbox checked ，日期选择器 date ，文件选择器 file，隐藏域 hidden ，提交按钮 submit，重置按钮 reset，自定义按钮 button， 文本域 textarea：cols rows  下拉选 select：name  option：value   
4. css：层叠样式表 ，美化页面 


###CSS引入方式

- 内联样式：在标签内部的style属性里面写样式代码，弊端：不能复用
- 内部样式：在head标签里面添加style标签在标签体内写样式代码，好处是能在当前页面内复用样式，弊端：不能多页面复用
- 外部样式：在单独的css文件中写样式代码，在页面的head标签里面通过link标签引入css文件，好处：可以多页面复用

###CSS引入方式的优先级
- 内联优先级最高
- 内部和外部优先级相同，后执行的会覆盖前面执行的。

###CSS的选择器
1. 标签名选择器    标签名{}  需要选择页面中所有某种标签时使用
2. id选择器      #id{}   需要选择页面中某一个元素时使用
3. 类选择器      .class{}  需要选择页面中某一类元素时使用
4. 分组选择器    #abc,.xyz,h1{}  页面中多个选择器对应的元素需要统一设置样式时
5. 属性选择器   标签名[属性名='属性值']{}
6. 子孙后代选择器    举例： div p{} 获取div里面出现的所有的p标签
7. 子元素选择器   举例:div>p{}  获取div里面的下一级(子元素)p标签



###练习：
1. 让div2的字体颜色为黄色
2. 让刘备的背景颜色为绿色
3. 让刘备关羽张飞字体颜色为红色
4. 让唐僧、悟空、八戒背景色为粉色
5. 让悟空、八戒字体为蓝色
6. 让蜘蛛精、白骨精、span1和span2背景色为绿，字体为紫色

1. 修改s1的字体颜色为红色
2. 修改s3的字体颜色为绿色
3. 修改s1和s4的背景颜色为蓝色
4. 修改s5的字体颜色为粉色
5. 修改s2的字体颜色为紫色



##课程回顾：
1. css的三种引入方式
- 内联：style属性中写样式  不能复用
- 内部：在head里面添加style标签 标签体内写样式   不能多页面复用
- 外部：在单独的css文件中写样式代码 通过link引入  
- 优先级： 内联最高 ， 内部和外部一样 后执行覆盖前面执行
2. 选择器
- 标签名选择器  标签名{}
- id选择器     #id{}
- 类选择器     .class{}
- 分组选择器     #id,.class{}
- 属性选择器    标签名[属性名='属性值']{}
- 子孙后代选择器   div span{}  
- 子元素选择器   div>span{}

###选择器（续）
8. 伪类选择器
	用于选择元素的状态
- 未访问状态： a:link
- 访问过状态: a:visited
- 鼠标悬停状态: a:hover
- 点击状态:  a:active
9. 任意元素选择器     *{}

###颜色赋值方式
	三原色rgb（红 绿 蓝）  每个颜色取值范围0-255   
1. 通过颜色单词的方式赋值
2. 通过6位16进制方式赋值   #ff0000红 #00ff00绿 #0000ff蓝 #000000黑 #ffffff白   #ffff00黄  #ff00ff紫
3. 通过3位16进制赋值  #f00红   #0f0绿   
4. 通过3位10进制赋值  rgb(255,0,0)红
5. 通过4位10进制赋值  rgba(255,0,0,0-1)    a=alpha(透明度)

###背景图片
1. background-image：设置背景图片
2. background-size:设置背景图片的尺寸
3. background-repeat:no-repeat  禁止重复
4. background-position: 控制位置 1.通过top、bottom、left、right、center控制位置  2. 通过百分比控制

###布局相关样式（盒子模型）
- 控制元素在页面显示的位置和大小
- 盒子模型包括： 宽高、外边距、内边距、边框
1. 宽高： width、height
- 块级元素可以修改宽高、行内元素不可以直接修改宽高只能有内容决定宽高
2. 外边距：指元素距上级元素边框的距离或相邻兄弟元素边框的距离
- 块级元素外边距全部生效，行内元素上下不生效

- 当元素的上边缘和上级元素的上边缘重叠时，给元素添加上外边距会出现粘连问题，在上级元素中添加 overflow:hidden
- 块级元素上下相邻，同时添加上外边距和下外边距，取最大值 
- 行内元素左右相邻，同时添加左外边距和右外边距，两者相加
3. 边框： border，可以给元素的任意方向添加边框
- 块级元素边框全部生效，会影响元素所占宽高
- 行内元素边框全部生效，会影响元素的宽但不影响元素的高


###代码介绍：
demo01: css的三种引入方式, 标签名选择器、id选择器
demo02: 类选择器、分组选择器、属性选择器
demo03: 上面内容的练习
demo04: 子孙后代选择器和子元素选择器
demo05： 子孙后代选择器和子元素选择器 练习
demo06: 伪类选择器 任意元素选择器
demo07: 颜色的赋值方式
demo08: 设置背景图片相关
demo09: 盒子模型之宽高+外边距
demo10: 外边距粘连问题，和相邻元素外边距相加还是取最大值的问题
demo11: 盒子模型之边框

###内容回顾：
1. 引入方式： 内联（在标签内部通过style属性添加样式代码，不能复用）  内部（在head标签内部添加style标签，页面内元素复用，不能多页面复用）  外部（在单独css文件中写样式代码通过link标签引入，可以多页面复用）
2. 优先级： 内联优先级最高，内部和外部一样 后执行覆盖先执行的内容
3. 选择器：
- 标签名选择器：  标签名{}
- id选择器: #id{}
- 类选择器： .class{}
- 分组选择器：  #id,.class{}
- 属性选择器:  标签名[属性名='属性值']{}
- 子孙后代选择器：   div p{}
- 子元素选择器:   div>p{}
- 伪类选择器： a:link未访问    a:visited已访问  a:hover悬停 a:active点击状态
- 任意元素选择器:   *{}
4. 颜色赋值方式： 
- 颜色单词   blue
- 6位16进制  #0000ff
- 3位16进制  #00f
- 3位10进制  rgb(0,0,255)
- 4位10进制  rgba(0,0,255,0-1) 值越小越透明
5. 背景图片
- background-image：url(路径) 设置背景图片
- background-size: 100px 200px 设置宽100px 高200px
- background-repeat： no-repeat  禁止重复
- background-position: 横向 纵向 (1.通过单词left/right/top/bottom/center  2.通过百分比)
6. 盒子模型 （外边距、边框、内边距、宽高）
- 宽高： 块级元素可以修改元素宽高，行内元素宽高由内容决定不能修改
- 外边距：元素距上级元素边框或距相邻兄弟元素边框的距离
margin-left/right/top/bottom: 10px;
margin:10px; 四个方向全部10px
margin：10px 20px; 上下10 左右20px
margin:0 auto; 上下0 左右居中
margin:10px 20px 30px 40px;上右下左 顺时针
粘连问题：当元素的上边缘和上级元素的上边缘重叠时，给元素添加上外边距时会出现粘连问题，通过 overflow：hidden解决
相邻元素上下外边距取最大值  左右外边距相加
块级元素全部生效，行内元素上下外边距没有效果，左右有效果
- 边框：可以给元素任意某个方向设置边框 
border-left/right/top/bottom：  一个方向赋值
border: 10px solid red; 四个方向赋值
块级元素全部生效，并且会影响元素的宽高
行内元素全部生效，影响宽度不影响高度





























