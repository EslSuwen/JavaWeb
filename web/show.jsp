<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .a{
            font-size: 20px;
        }
    </style>
</head>
<body>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>
<table class="a">
    <tr>
        <td>id</td>
        <td>消费名称</td>
        <td>消费金额</td>
        <td>消费日期</td>
    </tr>
    <%int i=0;%>
    <c:forEach items="${courses}" var="item">
        <tr <%if(i%2==0){ %>bgcolor="#F0F8FF"<%} %>>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
            <td>${item.date}</td>
        </tr>
        <%i++; %>
    </c:forEach>
</table>
</body>
</html>