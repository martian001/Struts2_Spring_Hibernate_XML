<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 >班级管理</h2>
 <s:a action="classAction_addUI">添加</s:a>
 <table border="1" cellspacing="0" cellpadding="0">
  <tr>
   <th width="85" scope="col">id</th>
   <th width="94" scope="col">name</th>
   <th width="97" scope="col">teacher</th>
   <th width="118" scope="col">&nbsp;</th>
  </tr>
  <s:iterator value="#request.classeList">
   <tr>
    <td>${id }</td>
    <td>${name }</td>
    <td>${teacher.name }</td>
    <td><s:a action="classAction_delete?id=%{id}" onclick="return confirm('确定要删除该班级和该班的所有学生？')">
     delete</s:a>&nbsp;&nbsp; <s:a action="classAction_editUI?id=%{id}">edit</s:a></td>
   </tr>
  </s:iterator>
 </table>
  <br/>
   导航功能： <s:a action="studentAction_list">学生</s:a>&nbsp;&nbsp;
 <s:a action="teacherAction_list">老师</s:a>
</body>
</html>