<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
<form action="ShangServlet?method=update" method="post" onsubmit="return check()">
    <div class="a">
        消费名称:<input type="text" id="name" name="name" value="${stu.name}"/>
    </div>
    <div class="a">
        消费金额:<input type="text" id="money" name="money" value="${stu.money}"/>
    </div>
    <div class="a">
        消费日期:<input type="text" id="date" name="date" value="${stu.date}"/>
    </div>
    <input type="hidden" id="id" name="id" value="${stu.id}"/>
    <div class="a">
        <button type="submit" class="b">修   改</button>
    </div>
</form>
<script type="text/javascript">
    function check() {
        var name=document.getElementById("name");
        var money=document.getElementById("money");
        var date=document.getElementById("date");
        if(name.value==''){
            alert('消费名称为空');
            name.focus();
            return false;
        }
        if(money.value==''){
            alert('消费金额为空');
            money.focus();
            return false;
        }
        if(date.value==''){
            alert('消费日期为空');
            date.focus();
            return false;
        }
    }
</script>
</body>
</html>