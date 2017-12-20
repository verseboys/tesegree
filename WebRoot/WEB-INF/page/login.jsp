<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//dtD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK 
rel=stylesheet type=text/css href="<%=path %>/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="javascript">
	function check(){
		var login_username = document.getElementById("user_name");
		var login_password = document.getElementById("user_password");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();	
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}
	
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
	
	//Ajax
	function validte(){
		
		var name=$("name").val();
		if(name==null||name==""){
			$("#nameDiv").html("用户名不能为空");
		}else{
			//ajax实现
			//1、获取XMLHttpRequest对象
			var req=createXmlHttpRequest();
		  //2.准备调用 url数据回调函数
		  var url="urlde值？？对应的java类或action?name"+name;
		  req.open("GET",url);
		 // 3.设置回调函数
		  req.onreadystatechange=callback;
		  
		  //4.发送请求(已完成)
		  req.send(null);
		  
		  //回调函数
		  function callback(){
			  if(req.readyState=4&&req.status==200){
				  var data=req.responseText;
				  if(data=="true"){
					  $("#nameDiv").html("用户名已结存在！");
				  }else{
					  $("#nameDiv").html("用户名可以使用！");
					  
				  }
				  
			  }
		  }
		}		
	}
	function createXmlHttpRequest(){
		//1.如果当前浏览器为ie6以上或其他浏览器
		if(window.XmlHttpRequest){
			return new XmlHttpRequest();
			
		}else{
			
			//2.如果当前浏览器是ie6以下浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
		
	}
	
	
	
</script>


<body>
<div id="header" class="wrap">
<div id="logo"><IMG src="<%=path %>/images/logo.gif"></div></div>
<div id="regLogin" class="wrap">
<div class="dialog">
<div class="box">
<H4>用户登录</H4>
<form id="users" method="post" name="users" action="userlogin.action" onSubmit="return check()">
<div class="infos">
<TABLE class="field">
  <Tbody>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class="field">用 户 名：</TD>
    <TD><!-- <input type="text" class="text" name="name" /> -->
    <input  class="text" type="text" name="users.name" > </TD></TR><!-- id="users.name" -->
  <TR>
    <TD class="field">密　　码：</TD>
    <TD><!-- <input type="password" class="text" name="password" /> -->
    <input id="users.password" class="text" type="password" name="users.password" id="password"> </TD></TR>
  
	  <!--	<tr>
			<td class="field">验 证 码：</td>
			<td><input type="text" class="text verycode" name="veryCode" /></td>
		</tr>-->
		</Tbody>
		</TABLE>
<DIV class=buttons> 
<input type="submit" name="buttons" value="提交">

<!-- <INPUT onclick='document.location="guanli.htm"' value=登陆 type=button>  --><INPUT onclick='document.location="regsteredpage.action"' value=注册 type=button> 
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id="footer" class="wrap">
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

