<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dto.billDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>水厂后台管理</title>
     <meta http-equiv="Cache-control" content="no-cache" />
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
     <script>
      function allcheck()
      {
    	  var checkObj = document.getElementsByName("check");
    	  for(var i=0;i<checkObj.length;i++)
    		  checkObj[i].checked = true;
      }
      
      function allnotcheck()
      {
    	  var checkObj = document.getElementsByName("check");
    	  for(var i=0;i<checkObj.length;i++)
    		  checkObj[i].checked = false;
      }
      
      function backcheck()
      {
    	  var checkObj = document.getElementsByName("check");
    	  for(var i=0;i<checkObj.length;i++)
    		  if(checkObj[i].checked == true)
    			  checkObj[i].checked = false;
    		  else
    		  checkObj[i].checked = true;
      }
    
    function deleteCheck()
    {
  	  var checkObj = document.getElementsByName("check");
  	  var arr = [];
  	  var flag = false;
  	  for(var i=0;i<checkObj.length;i++)
  		  {
		  if(checkObj[i].checked == true)
			  {
			     arr.push(checkObj[i].value);
			     flag = true;
			  }

  		  }
  	  
  	  alert(arr);
  	  
  	  if(flag = true)
  		  {
  		    if( confirm("您确定要删除这条记录吗？"))
  		    	location.href="deleteCheckbillServlet?arr="+arr;
  		  }
  	  else
  		  alert("您至少选择一条记录，再进行删除");
    }
    
    
    </script>
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
                <li><a href="insertBill.html">添加数据</a></li>
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
                <style>
				       table,table tr th, table tr td { border:1px solid #000; }
				       table { width: 800px; min-height: 25px; line-height: 40px; text-align: center; border-collapse: collapse;}   
				 </style>    
   <table border=1>
      <tr>
        <td></td>
        <td><b><span style="font-size:18px;">usersID</span></b></td>
        <td><b><span style="font-size:18px;">price</span></b></td>
        <td><b><span style="font-size:18px;">flag</span></b></td>
        <td><b><span style="font-size:18px;">waID</span></b></td><td></td>
        
      </tr>
       <%
		 Vector<billDTO> v = new Vector<billDTO>();
          v = (Vector<billDTO>)session.getAttribute("allbill");
          Iterator it = v.iterator();
          billDTO b = null;
          while(it.hasNext()){
        	  b = (billDTO)it.next();  
       %>
     <tr>
         <td><input type="checkbox" name="check" value=<%=b.getUsersID()%>,<%=b.getWaID()%>></td>
         <td><span style="font-size:16px;"><%=b.getUsersID()%></span></td>
         <td><span style="font-size:16px;"><%=b.getPrice()%></span></td>
         <td><span style="font-size:16px;"><%=b.getFlag()%></span></td>
         <td><span style="font-size:16px;"><%=b.getWaID()%></span></td>
         <td>
           <a href="updateBill.jsp?usersID=<%=b.getUsersID()%>"><span style="font-size:16px;">update</span></a>
           <a href="deleteBillServlet?usersID=<%=b.getUsersID()%>"><span style="font-size:16px;">delete</span></a>
        </td>
      </tr>
   
   <%
      }
   %>
   </table>
        <input type="button" id="btn1" value="全选" onClick="allcheck();"/>
        <input type="button" id="btn2" value="不选" onClick="allnotcheck();"/>
        <input type="button" id="btn3" value="反选" onClick="backcheck();"/>
        <input type="button" value="批量删除" onClick="deleteCheck();"/>
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