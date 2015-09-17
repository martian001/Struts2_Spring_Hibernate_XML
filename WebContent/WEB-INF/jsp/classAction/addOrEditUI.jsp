<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
 $(function() {
  $("#teacherList").change(function() {
   var $this = $(this);
   var teacherId = $this.val();
   if (teacherId != "") {
    $this.nextAll("font").remove();
    var url = "classAction_teacherIsUsable";
    var agrs = {
     "teacherId" : teacherId,
     "date" : new Date()
    };
    $.post(url, agrs, function(date) {
     if (date == "1") {
      $this.after("<font color='red'>不可用</font>");
     } else if (date == "0") {
      $this.after("<font color='greed'>可用</font>");
     } else {
      alert("系统错误");
     }

    })
   } else {
    alert("名字不能为空");
    $nameInput.focus();
   }
  })
 })
</script>
</head>
<body>
 <s:form action="classAction_%{id==null?'add':'update'}">
  <s:textfield label="名字" name="name" />
  <s:hidden name="id" />
  <s:select list="#request.teacherList" id="teacherList" listKey="id" listValue="name" name="teacherId" headerKey="" headerValue="===请选择班级==="  label="班主任" />
  <s:submit value="保存" />
 </s:form>
</body>
</html>