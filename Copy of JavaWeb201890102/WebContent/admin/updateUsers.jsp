<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dto.usersDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>水厂后台管理</title>
   <link rel="stylesheet" type="text/css" href="css/common.css"/>
   <link rel="stylesheet" type="text/css" href="css/main.css"/>
   <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin.html">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <li><a href="findAllUser">修改密码</a></li>
                <li><a href="http://localhost:8080/Copy%20of%20JavaWeb201890102/index.html">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>用户管理</a>
                    <ul class="sub-menu">
                        <li><a href="findAllUser"><i class="icon-font">&#xe005;</i>用户信息</a></li>
                        <li><a href="findAllBill"><i class="icon-font">&#xe006;</i>查看记录</a></li>
                        
                    </ul>
                </li>
                <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>库存管理</a>
                    <ul class="sub-menu">
                        <li><a href="findAllWaterticket"><i class="icon-font">&#xe008;</i>水票查询</a></li>
                        <li><a href="findAllWarehouse"><i class="icon-font">&#xe004;</i>查看仓库</a></li>
                      
                    </ul>
                </li>
                 <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>记录管理</a>
                    <ul class="sub-menu">
                        <li><a href="findAllBill"><i class="icon-font">&#xe006;</i>查看记录</a></li>
                       
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用是真的水厂管理系统!</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                   <a href="insert.html"><i class="icon-font">&#xe001;</i>添加水票信息</a>
                    <a href="insertWarehouse.html"><i class="icon-font">&#xe048;</i>添加库存信息</a>
                    <a href="insertBill.html"><i class="icon-font">&#xe048;</i>添加用户记录</a>   
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>销售记录</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                
   <form action="updateUsersServlet">
   <table border=1>
      <tr>
        <td>usersID</td>
        <td>usersName</td>
        <td>superUsers</td>
        <td>password</td>
        <td>flag</td>
        <td></td>
      </tr>
       <%
         String usersID = request.getParameter("usersID");
		 Vector<usersDTO> v = new Vector<usersDTO>();
          v = (Vector<usersDTO>)session.getAttribute("alluser");
          Iterator it = v.iterator();
          usersDTO u = null;
          while(it.hasNext()){
        	  u = (usersDTO)it.next();  
        	  if((u.getUsersID().equals(usersID))){
       %>
     <tr>
        <td><input type="text" readOnly="ture" name="usersID" value=<%=u.getUsersID()%>></td>
        <td><input type="text" name="usersName" value=<%=u.getUsersName()%>></td>
        <td><input type="text" name="superUsers" value=<%=u.getSuperUsers()%>></td>
        <td><input type="text" name="password" value=<%=u.getPassword()%>></td>
        <td><input type="text" name="flag" value=<%=u.getFlag()%>></td>
        <td><input type="submit" value="make sure"></td>
      </tr>
   
   <%
      }}
   %>
   </table>
   </form>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">官方交流网站：</label><span class="res-info"><a href="https://www.baidu.com/" target="_blank">百度一下，你就知道</a></span>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>


</body>
</html>