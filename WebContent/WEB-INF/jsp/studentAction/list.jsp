<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 >学生管理</h2>
 <s:a action="studentAction_addUI">添加</s:a><br/>
 <table border="1" cellspacing="0" cellpadding="0">
  <tr>
   <th width="85" scope="col">id</th>
   <th width="94" scope="col">name</th>
   <th width="97" scope="col">class</th>
   <th width="103" scope="col">teacher</th>
   <th width="118" scope="col">&nbsp;</th>
  </tr>
  <s:iterator value="#request.studentList" var="student">
   <tr>
    <td>${id }</td>
    <td>${name }</td>
    <td>${classe.name }</td>
    <td>${classe.teacher.name }</td>
    <td><s:a action="studentAction_delete?id=%{id}">
     delete</s:a>&nbsp;&nbsp; <s:a action="studentAction_editUI?id=%{id}">edit</s:a></td>
   </tr>
  </s:iterator>
 </table>
  <br/>
   导航功能： <s:a action="classAction_list">班级</s:a>&nbsp;&nbsp;
 <s:a action="teacherAction_list">老师</s:a>
</body>
</html>