<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 11:20
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
            margin-top: 20px;
        }
        .b{
            font-size: 20px;
            width: 160px;
            color: white;
            background-color: greenyellow;
        }
        .tb, td {
            border: 1px solid black;
            font-size: 22px;
        }
    </style>
</head>
<body>
<div align="center">
    <table class="tb">
        <tr>
            <td>id</td>
            <td>消费名称</td>
            <td>消费金额</td>
            <td>消费日期</td>
        </tr>
        <%int i=0;%>
        <!-- forEach遍历出adminBeans -->
        <c:forEach items="${courses}" var="item" varStatus="status">
            <tr <%if(i%2==0){ %>bgcolor="#F0F8FF"<%} %>>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.money}</td>
                <td>${item.date}</td>
            </tr>
            <%i++; %>
        </c:forEach>
    </table>
</div>
</body>
</html>