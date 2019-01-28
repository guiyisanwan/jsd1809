###课程回顾：
1. CSS：层叠样式表 用于 美化页面
2. 三种引入方式：
- 内联： 在标签内部的style属性中写样式代码，不能复用
- 内部： 在head标签内部添加style标签在标签体内写样式代码，页面内复用，不能多页面复用
- 外部： 在单独的css文件中写样式代码，通过link标签引入，可以多页面复用
3. 优先级： 内联最高， 内部和外部一样，后执行的覆盖前面执行的
4. 选择器：
- 标签名选择器  标签名{}
- id选择器   #id{}
- 类选择器  .class{}
- 分组选择器    #id,.class{}
- 属性选择器  标签名[属性名='值']{}
- 子孙后代选择器  div p{}
- 子元素选择器  div>p{}
- 伪类选择器  a:link未访问  a:visited访问过  a:hover悬停  a:active点击 
- 任意元素选择器 *{}
5. 颜色赋值
- 颜色单词赋值 red
- 6位16进制赋值 #ff0000
- 3位16进制赋值 #f00
- 3位10进制赋值  rgb(255,0,0)
- 4位10进制赋值 rgba(255,0,0,0-1)
6. 背景图片
- background-image：url(路径)  设置背景图片
- background-size：100px 200px  修改图片尺寸
- background-repeat:no-repeat   禁止重复
- background-position:横向 纵向  1.通过单词（left right top bottom center） 2.通过百分比
7. 盒子模型
- 宽高+外边距+边框+内边距
- 宽高：width、height ，块级元素可以修改宽高，行内元素宽高由内容决定
- 外边距：元素距上级元素边框或相邻兄弟元素边框的距离， margin-left/right/bottom/top ,  margin:10px;  margin:10px 20px; margin:0 auto;
margin:10px 20px 30px 40px;
块级元素外边距全部生效，行内元素左右生效上下不生效
粘连问题：当元素上边缘和上级元素上边缘重叠时，给元素添加上外边距会出现粘连问题，通过给上级元素添加 overflow：hidden解决
左右相邻两值相加   上下相邻取最大值
- 边框： border-left/right/top/bottom   border:粗细 样式 颜色;
块级元素全部生效 会影响元素的所占宽高，
行内元素全部生效，会影响宽度但不影响高度

####内边距
- 元素边框距内容的距离
- 如果移动元素的文本内容，只能通过修改内边距的方式，记住修改内边距会影响元素的宽高
- 如果移动元素的子元素，可以有两种方式：1. 给大的添加内边距（会影响元素的宽高） 2.给小的添加外边距（推荐）
- 块级元素内边距全部生效，会影响元素的宽高
- 行内元素内边距全部生效，会影响元素所占宽度但不影响高度

###文本相关样式
- 设置对齐方式  text-align:left/right/center
- 文本修饰 text-decoration:overline/underline/line-through/none
- 文本颜色 color:red
- 文本阴影 text-shadow:颜色 x偏移值 y偏移值 模糊度值越小越清晰

- 设置圆角 border-radius: 10px  值越大越圆

###字体相关样式
- 字体大小 font-size:10px;
- 字体加粗 font-weight:bold/normal;
- 斜体  font-style:italic 
- 字体名称 font-family:字体名 可以写多个，能用哪个用哪个

###溢出设置 overflow
- visible 显示(默认)   
- hidden 隐藏  可以解决粘连问题
- scroll 滚动显示 

###元素的显示方式 display
- 块级元素默认值为 block, 独占一行 可以修改宽高
- 行内元素默认值为 inline, 共占一行 不能修改宽高
- 行内块  inline-block, 共占一行 可以修改宽高





###盒子模型
- 宽高+外边距+边框+内边距
- 计算元素所占宽度公式：左外边距+左边框+左内边距+宽度+右内边距+右边框+右外边距
- 宽高：width、height  块级元素可以修改宽高，行内元素不能修改宽高，由内容决定
- 外边距：元素距上级元素边框或相邻兄弟元素边框的距离 
margin-left/right/top/bottom
margin:10px;
margin:10px 20px;
margin:10px 20px 30px 40px; 上右下左
块级元素外边距全部生效，行内元素左右生效上下不生效
粘连问题：元素的上边缘和上级元素的上边缘重叠时 给元素添加上外边距会出现粘连问题 通过给上级元素添加 overflow：hidden 解决
上下相邻取最大  左右相邻相加

- 边框： border-left/right/top/bottom    border:粗细 样式 颜色
块级元素全部生效，影响所占宽高
行内元素全部生效，影响宽不影响高
- 内边距： 边框距内容的距离  ，padding 赋值方式和margin一样
块级元素全部生效，影响所占宽高
行内元素全部生效，影响宽不影响高
###文本相关
1. 文本对齐： text-align:left/right/center
2. 文本修饰：text-decoration:overline/underline/line-through/none
3. 文本颜色： color:red
4. 文本阴影：text-shadow：颜色 x偏移值 y偏移值 模糊度值越小越清晰
5. 行高： line-height:20px  用于垂直居中

6. border-radius:10px  值越大越圆
###字体相关
1. 字体大小 font-size:20px
2. 字体加粗 font-weight:bold/normal;
3. 斜体： font-style:italic;
4. 字体名称： font-family：xxx,xxx,xxx;
###溢出设置 overflow
1. visible(默认)显示
2. hidden 隐藏
3. scroll 滚动显示
###显示方式 display
1. 块级元素：block  独占一行 可以修改宽高
2. 行内元素： inline 共占一行 不能修改宽高
3. 行内块元素： inline-block 共占一行并且可以修改宽高














	






