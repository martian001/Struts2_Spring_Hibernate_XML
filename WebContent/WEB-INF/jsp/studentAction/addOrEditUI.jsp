<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(":input[name=name]").change(function() {
			var $this = $(this);
			var nameVal = $this.val();
			if (nameVal != "") {
				$this.nextAll("font").remove();
				var url = "studentAction_nameIsExist";
				var agrs = {
					"name" : nameVal,
					"date" : new Date()
				};
				$.post(url, agrs, function(date) {
					if (date == "1") {
						$this.after("<font color='red'>已存在</font>");
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
<title>Insert title here</title>
</head>
<body>
 <s:form action="studentAction_%{id==null?'add':'update'}">
 
  <s:textfield label="名字" name="name" />
  <s:password label="密码" name="password" />
  <s:hidden name="id" />
  
  <s:select list="#request.classeList" listKey="id" listValue="name" name="classeId" label="所在班级" />
  <s:submit value="保存" />
 </s:form>
</body>
</html>