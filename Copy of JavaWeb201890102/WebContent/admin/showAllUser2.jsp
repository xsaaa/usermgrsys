<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dto.usersDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <title>ˮ����̨����</title>
    <meta http-equiv="Cache-control" content="no-cache" />
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
   
</head>
<body>

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">��̨����</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin2.html">��ҳ</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
           
                <li><a href="admin2.html">������һҳ</a></li>
                <li><a href="http://localhost:8080/Copy%20of%20JavaWeb201890102/index.html">�˳�</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>�˵�</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                  <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>�û�����</a>
                    
                </li>
                <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>������</a>
                    
                </li>
                 <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>��¼����</a>
                  
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>��ӭʹ�������ˮ������ϵͳ!</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>��ݲ���</h1>
            </div>
            <div class="result-content">
                
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>�û�������Ϣ</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                 <style>
				       table,table tr th, table tr td { border:1px solid #000; }
				       table { width: 800px; min-height: 25px; line-height: 40px; text-align: center; border-collapse: collapse;}   
				 </style>   
   <table border=1>
      <tr>
        <td><b><span style="font-size:18px;">usersID</span></b></td>
        <td><b><span style="font-size:18px;">usersName</span></b></td>
        <td><b><span style="font-size:18px;">superUsers</span></b></td>
        <td><b><span style="font-size:18px;">password</span></b></td>
        <td><b><span style="font-size:18px;">flag</span></b></td>
      </tr>
       <%
		 Vector<usersDTO> v = new Vector<usersDTO>();
          v = (Vector<usersDTO>)session.getAttribute("alluser");
          Iterator it = v.iterator();
          usersDTO u = null;
          while(it.hasNext()){
        	  u = (usersDTO)it.next();  
       %>
     <tr>
         <td><span style="font-size:16px;"><%=u.getUsersID()%></span></td>
         <td><span style="font-size:16px;"><%=u.getUsersName()%></span></td>
         <td><span style="font-size:16px;"><%=u.getSuperUsers()%></span></td>
         <td><span style="font-size:16px;"><%=u.getPassword()%></span></td>
         <td><span style="font-size:16px;"><%=u.getFlag()%></span></td>
        
     </tr>
   
   <%
      }
   %>
   </table>
        
                </ul>
            </div>
        </div>
        
        
        <div class="result-wrap">
            <div class="result-title">
                <h1>ʹ�ð���</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">�ٷ�������վ��</label><span class="res-info"><a href="https://www.baidu.com/" target="_blank">�ٶ�һ�£����֪��</a></span>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>

   


</body>
</html>