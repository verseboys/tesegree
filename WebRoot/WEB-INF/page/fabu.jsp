<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="<%=path%>/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="scripts/calendar.js" type="text/javascript" language="javascript"></script> 
<script type="text/javascript">
	function doadd() {
       var addform=document.getElementById("add_action");
       
       addform.submit();
	}
	function domodify() {
		var modifyform=document.getElementById("modify_action");
	       modifyform.submit(); 
		}
</script>

<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="<%=path%>/images/logo.gif"></DIV></DIV>

<a href="">管理员：<s:property value="#session.users.username"/></a>

<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<%-- <s:set name="house" value="house" /> 都不需要--%>
<%-- <s:property  value="house" /> 不同于el条件if标签上要有 value属性 --%>
<s:if test="house==null">
<FORM id=add_action method="post" name=addhouse.action action=releahouse.action>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR><TD>
   <INPUT id=user_id class=text type="hidden"  name="users.id" value=<s:property value="#session.users.id"/>>
   </TD></TR>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name="house.title"> </TD></TR>
 <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=type.id>
    <s:iterator value="typelist" id="type">
    <OPTION selected value="<s:property value="#type.id"/>"><s:property value="#type.name"/></OPTION>
    </s:iterator>
    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text name=house.floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=house.price> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    
    
  <!--   时间控件的应用 -->
  <TD><input name="house.pubdate" type="text" style="padding-left:5px;" id="txtDate" 
  onclick="SetDate(this,'yyyy-MM-dd hh:mm')" readonly="readonly" /></TD></TR>  
   <!--  <TD><INPUT class=text type=text name=house.pubdate></TD></TR> -->
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district.id>
    <s:iterator value="districtlist" id="district">
    <OPTION selected value="<s:property value="#district.id"/>"><s:property value="#district.name"/></OPTION>
    </s:iterator>
    
    </SELECT> 街：<SELECT class=text name=street.id>
    <s:iterator value="streetlist" id="street">
    <OPTION selected value="<s:property value="#street.id"/>"><s:property value="#street.name"/></OPTION>
    </s:iterator>
    </SELECT> </TD></TR><!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=house.contact> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=house.description></TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT onclick='doadd()' value=立即发布 type=button> 
</DIV></DIV></FORM>

</s:if>

<s:else>
<FORM id=modify_action method=post name=modify.action 
action="modifyhouse.action">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
   <TR><TD>
   <INPUT id=user_id class=text type="hidden"  name="users.id" value=<s:property value="#session.users.id"/>>
   </TD></TR>
   <TR><TD>
   <INPUT id=house_id class=text type="hidden"  name="house.id" value=<s:property value="house.id"/>>
   </TD></TR>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=house.title  value="<s:property value="house.title"/>"/> </TD></TR>
 <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=type.id>
    <s:iterator value="typelist" id="type">
    <OPTION <s:if test="house.type.id==#type.id">selected</s:if> value="<s:property value="#type.id"/>"><s:property value="#type.name"/></OPTION>
    </s:iterator>
    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text value="<s:property value="house.floorage"/>" name=house.floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=house.price value="<s:property value="house.price"/>"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=text name=house.pubdate value="<s:property value="house.pubdate"/>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district.id>
    <s:iterator value="districtlist" id="district">
    <OPTION selected value="<s:property value="#district.id"/>"><s:property value="#district.name"/></OPTION>
    </s:iterator>
    
    </SELECT> 街：<SELECT class=text name=street.id>
    <s:iterator value="streetlist" id="street">
    <OPTION <s:if test="house.street.id==#street.id">selected</s:if> value="<s:property value="#street.id"/>"><s:property value="#street.name"/></OPTION>
    </s:iterator>
    </SELECT> </TD></TR><!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=house.contact value="<s:property value="house.contact"/>"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=house.description  ><s:property value="house.description"/></TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT onclick="domodify()" value=立即发布 type=button> 
</DIV></DIV></FORM>
</s:else>
</DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
