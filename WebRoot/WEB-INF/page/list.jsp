<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="<%=path%>/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>

<script type="text/javascript">
	function doSearch() {
       var sform=document.getElementById("sform");
       sform.submit();
	}
	
	function next(num){
		var current=document.getElementById("cuurrPage").value;//读值一定要有id
		var next=parseInt(current)+parseInt(num);
		document.getElementById("cuurrPage").value=next;
		doSearch();
	}
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="<%=path%>/images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=commonpage.action>
  <input  type="hidden" id="cuurrPage" name="housePage.cuurrPage" value="${housePage.cuurrPage}"/>
  
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class=text type=text name=con.title> <LABEL class=ui-blue><INPUT onclick=doSearch() value=搜索房屋 type=button name=search></LABEL> 
    </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI><SELECT name=con.price>
    
    <!-- <OPTION selected value="">不限</OPTION> 
     <OPTION value=1>1000元以下</OPTION> 
     <OPTION value=2>1000元—3000元</OPTION> 
     <OPTION value=3>3000元以上</OPTION>  -->
      
    <OPTION <s:if test="con.price==''">selected</s:if> value="">不限</OPTION> 
    
    
    
   <OPTION value=1  <s:if test="con.price==1">selected</s:if> >1000元以下</OPTION> 
    <OPTION <s:if test="con.price==2">selected</s:if> value=2 >1000元—3000元</OPTION> 
    <OPTION <s:if test="con.price==3">selected</s:if> value=3 >3000元以上</OPTION>  
   
    </SELECT> </LI></UL></DD>
        
  <DD>
  <UL>
    <LI class=first>房屋位置</LI>
    <LI><SELECT id=street name=con.street.id> 
     <OPTION <s:if test="con.street.id==''">selected</s:if> value="">不限</OPTION> 
    
    <s:iterator value="streetlist" id="street">
    <OPTION value="<s:property value="#street.id"/>" <s:if test="con.street.id==#street.id">selected</s:if>  ><s:property value="#street.name"/></OPTION> 
    </s:iterator>
    
    <!-- 
      <OPTION <s:if test="con.street.id==1000">selected</s:if> value=1000 >知春路</OPTION> 
    <OPTION <s:if test="con.street.id==1001">selected</s:if> value=1001 >中关村大街</OPTION> 
    <OPTION <s:if test="con.street.id==1002">selected</s:if> value=1002  >学院路</OPTION>  
    <OPTION <s:if test="con.street.id==1003">selected</s:if> value=1003  >朝阳路</OPTION> -->
   <!--  selected 是被默认选中的-->
    </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI><SELECT name=con.type.id> 
    
   <!--  <OPTION selected value="">不限</OPTION> 
    <OPTION value=1000>一室一厅</OPTION> 
    <OPTION value=1001>一室两厅</OPTION> 
    <OPTION value=1002>两室一厅</OPTION> 
    <OPTION value=1003>两室两厅</OPTION>-->
    
     <OPTION <s:if test="con.type.id==''">selected</s:if> value="">不限</OPTION> 
   
   <s:iterator value="typelist" id="type">
    <OPTION <s:if test="con.type.id==#type.id">selected</s:if> value="<s:property value="#type.id"/>" ><s:property value="#type.name"/></OPTION> 
    </s:iterator>
    
    </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name=con.floorage> 
    
 
     <OPTION <s:if test="con.floorage==''">selected</s:if> value="">不限</OPTION> 
     <OPTION value=1  <s:if test="con.floorage==1">selected</s:if> >80以下</OPTION> 
    <OPTION <s:if test="con.floorage==2">selected</s:if> value=2 >80-500</OPTION> 
    <OPTION <s:if test="con.floorage==3">selected</s:if> value=3 >500以上</OPTION> 
    
    
    </SELECT> </LI></UL></DD></FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <%-- 
  <s:if test="houseslistcom.size!=0">
  
  <s:iterator value="#request.houseslistcom">
  <TR>
    <TD class=house-thumb><span><A href="details.action?house.id=<s:property value="id"/>" target="_blank"><img src="<%=path%>/images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.action?house.id=<s:property value="id"/>"  target="_blank"><s:property value="title"/>
        </A></DT>
        <DD><s:property value="description"/><BR>联系方式：<s:property value="contact"/> </DD></DL></TD>
    <TD class=house-type><s:property value="type.name"/></TD>
    <TD class=house-price><SPAN><s:property value="price"/></SPAN>元/月</TD></TR>
    
    </s:iterator>
    
    </s:if>
    <s:else>
  
  <TR>无租房信息</TR>
  
  </s:else> --%>
  
    <s:if test="housePage.houseList.size!=0">
  
  <s:iterator value="housePage.houseList" id="house">
  <TR>
    <TD class=house-thumb><span><A href="detailspage.action?house.id=<s:property value="#house.id"/>" target="_blank"><img src="<%=path%>/images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="detailspage.action?house.id=<s:property value="#house.id"/>"  target="_blank"><s:property value="#house.title"/>
        </A></DT>
        <DD><s:property value="description"/><BR>联系方式：<s:property value="#house.contact"/> </DD></DL></TD>
    <TD class=house-type><s:property value="#house.type.name"/></TD>
    <TD class=house-price><SPAN><s:property value="#house.price"/></SPAN>元/月</TD></TR>
    
    </s:iterator>
    
    </s:if>
    <s:else>
  
  <TR>无租房信息</TR>
  
  </s:else>
  
  
  </TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="#">首页</A></LI>
  <!-- 没有带上搜索信息，其搜索信息会被覆盖 -->
 <%--  <LI><A href="commonpage.action?housePage.cuurrPage=${housePage.cuurrPage-1}">上一页</A></LI>
  <LI><A href="commonpage.action?housePage.cuurrPage=${housePage.cuurrPage+1}">下一页</A></LI>
 --%>  
  <LI><A href="javascript:next(-1)">上一页</A></LI>
  <LI><A href="javascript:next(1)">下一页</A></LI>
  <LI><A href="#">末页</A></LI></UL><SPAN 
class=total>${housePage.cuurrPage }/${housePage.totalPageCount }页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
