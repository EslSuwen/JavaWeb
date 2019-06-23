<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        .a{
            font-size:20px;
            margin-top:10px;
        }
    </style>
</head>
<body>
<div align="center">
    <div class="a">
        <a href="add.jsp" target="main_right">新增消费账单</a></div>
    <div class="a">
        <a href="AccountServlet?method=delete" target="main_right">删除消费账单</a></div>
    <div class="a">
        <a href="AccountServlet?method=list" target="main_right">修改消费账单</a></div>
    <div class="a">
        <a href="search.jsp" target="main_right">查询消费账单</a></div>
    <div class="a">
        <a href="AccountServlet?method=show" target="main_right">查看所有账单</a></div>
</div>
</body>
</html>