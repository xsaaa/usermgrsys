<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dto.usersDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ˮ����̨����</title>
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
                <li><a class="on" href="admin.html">��ҳ</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">����Ա</a></li>
                <li><a href="findAllUser">�޸�����</a></li>
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
                    <ul class="sub-menu">
                        <li><a href="findAllUser"><i class="icon-font">&#xe005;</i>�û���Ϣ</a></li>
                        <li><a href="findAllBill"><i class="icon-font">&#xe006;</i>�鿴��¼</a></li>
                        
                    </ul>
                </li>
                <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>������</a>
                    <ul class="sub-menu">
                        <li><a href="findAllWaterticket"><i class="icon-font">&#xe008;</i>ˮƱ��ѯ</a></li>
                        <li><a href="findAllWarehouse"><i class="icon-font">&#xe004;</i>�鿴�ֿ�</a></li>
                      
                    </ul>
                </li>
                 <li> 
                    <a href="#"><i class="icon-font">&#xe018;</i>��¼����</a>
                    <ul class="sub-menu">
                        <li><a href="findAllBill"><i class="icon-font">&#xe006;</i>�鿴��¼</a></li>
                       
                    </ul>
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
                <div class="short-wrap">
                   <a href="insert.html"><i class="icon-font">&#xe001;</i>���ˮƱ��Ϣ</a>
                    <a href="insertWarehouse.html"><i class="icon-font">&#xe048;</i>��ӿ����Ϣ</a>
                    <a href="insertBill.html"><i class="icon-font">&#xe048;</i>����û���¼</a>   
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>���ۼ�¼</h1>
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