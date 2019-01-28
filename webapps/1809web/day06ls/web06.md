###课程回顾
####day01
1. html 超文本标记语言， 搭建页面结构和内容
2. 内容标题：h1-h6 
3. 段落标签 p
4. 水平分割线hr  换行br
5. 列表：  
- 无序列表   ul li   
- 有序列表   ol li
- 定义列表   dl  dt  dd
- 列表嵌套 可以有序无序无限嵌套
6. 分区元素  div 独占一行  span    h5： header article footer
7. 元素分类： 块级元素：div h1-h6 p hr  和行内元素 span  strong和b em和i  u   del和s  
8. 图片 img：  alt（图片不能正常显示的时候显示此文本） src（图片的路径，相对路径 同级直接写名字 上级../图片名 下级文件夹名/图片名  绝对路径：指向站外资源（盗链） ） title（当鼠标悬停时显示的文本） width、height 
9. 图像地图：map   name（唯一标识）  area：shape（circle和rect） coords（圆形三个值圆心坐标和半径，rect四个值 对角线两个点的坐标）  href（路径 指向页面或文件（能浏览则浏览不能浏览则下载））   <img usemap="");
####day02
1. 超链接 a   <a href  target="_blank">xxx</a>   锚点使用  
2. 表格 table：border cellspacing   cellpadding    tr  td：rowspan colspan  th   caption   thead  tbody  tfoot 
3. 表单 form： action 提交地址  method：get/post  
- input type="text/password/radio/checkbox/date/file/hidden/submit/button/reset" placeholder readonly name value checked
- select: name    <option value="a">aaaa</option>
- textarea: cols rows  name 
####day03
1. css 层叠样式表  ，用于美化html搭建的页面
2. 三种引入方式：
- 内联：在标签的style属性里面写样式代码，不能复用 
- 内部样式： 在head标签里面添加style标签，可以页面内复用，不能多页面复用
- 外部样式： 在单独的css文件中写样式代码，通过link标签引入 ，可以多页面复用
3. 内联优先级最高，内部外部一样，后执行的覆盖先执行的
4. 选择器：
- 标签名选择器：   div{}
- id选择器：    #id{}
- 类选择器：    .class{}
- 分组选择器：   div,#id,.class{}
- 属性选择器 ：   div[属性名='属性值']{}
- 子孙后代选择器：  div span{}
- 子元素选择器：   div>span{}
- 伪类选择器：   未访问link  访问过visited  悬停hover  点击时 active
- 任意选择器：  *{}
5. 颜色赋值：
- 颜色单词 red
- 6位16进制 #ff0000
- 3位16进制 #f00
- 3位10进制 rgb(255,0,0)
- 4位10进制 rgba(255,0,0,0-1) 值越小越透明
6. 背景图片
- background-image:url(图片路径)  设置背景图片
- background-size:100px 200px; 设置背景图片大小
- background-repeat:no-repeat; 禁止重复
- background-position:left top; 0% 0%;
7. 盒子模型
- 外边距,边框，内边距，宽高 
- 外边距：元素与上级元素边框或相邻兄弟元素边框的距离
margin:10px; 上下左右全部是10px
margin:10px 20px  上下10  作用20
margin:0 auto  居中
margin:10px 20px 30px 40px  上右下左 顺时针
粘连问题：元素的上边缘和上级元素的上边缘重叠，给元素添加上外边距时出现粘连，通过给上级元素overflow:hidden解决
左右相邻求和
上下相邻取最大值
块级元素全部生效 行内元素左右生效上下不生效
- 边框： 
border-left/right/top/bottom:
border: 粗细 样式 颜色
块级元素全部生效，影响元素的宽高 
行内元素全部生效， 影响宽度不影响高度
- 内边距：元素边框距内容的距离
padding:10px;
padding:10px 20px;
padding:10px 20px 30px 40px;
块级元素全部生效，影响所占宽高
行内元素全部生效，影响宽度不影响高度
- 宽高： width height
块级元素可以修改
行内元素不可以修改 ，由内容决定
####day04
1. 文本相关
- text-align: 水平对齐方式 left/right/center
- text-decoration: overline/underline/line-through/none 
- color:red;
- text-shadow:颜色 x偏移值 y偏移值 模糊度 值越小越清晰
- line-height:10px  一般用于控制文本垂直居中 
2. 字体相关
- font-size: 控制字体大小
- font-weight:bold 加粗  normal去掉加粗效果
- font-style:italic  斜体
- font-family: xxxx,xxx,xxx

3. 圆角  border-radius: 值越大越圆
4. 溢出设置 overflow
- hidden 超出隐藏
- visible 超出显示（默认）
- scroll 超出滚动显示
5. 显示方式 display
- 块级元素  block    可以修改宽高 不能显示到一行
- 行内元素  inline   可以显示到一行 不能修改宽高
- 行内块   inline-block  可以修改宽高 也可以显示到一行  

####day05
1. 定位方式 
- 文档流定位（静态定位） position：static  ，块级从上到下，行内从左向右
- 相对定位position:relative, 不脱离文档流，元素从当前位置通过left、right、top、bottom进行偏移 
- 绝对定位position：absolute， 脱离文档流，元素位置相对于窗口或做了非static定位的祖先元素，如果多个祖先元素都做非static定位则就近原则
- 固定定位position:fixed,脱离文档流，元素位置相对于窗口 
- 浮动定位float:left、right, 脱离文档流，元素从当前所在行向左或向右浮动，当撞到上级元素边框 或其它浮动元素时停止，一行显示不下会自动折行，折行时有可能被卡住， 如果元素前有浮动元素不想顶上去的话需要添加clear属性值为left/right/both, 当元素所有的子元素全部浮动的话，则元素自动识别的高度为0， 通过给元素添加overflow：hidden解决 
2. 行内元素的垂直对齐方式vertical-align
- top 上对齐 
- bottom 下对齐
- middle 中间对齐
- baseline(默认) 基线对齐
3. CSS的三大特性
- 继承性：元素可以继承祖先元素的部分样式属性，只能继承文本和字体相关的样式    a  h1-h6
- 层叠性: 多个选择器指向同一个元素时 添加不同的样式会层叠到一起显示，如果相同的样式只响应一个响应谁由优先级决定 
- 优先级： 作用范围越小优先级越高  id>class>标签名>继承  


 






