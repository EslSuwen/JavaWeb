<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        .a{margin-top:20px;}
        .b{font-size:20px;width:160px;color:white; background-color:greenyellow;}
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
<div align="center">
    <form action="ShangServlet?method=add" method="post" onsubmit="return check()">
        <div class="a">消费名称:<input type="text" name="name" id="name"></div>
        <div class="a">消费金额:<input type="text" name="money" id="money"></div>
        <div class="a">消费日期:<input type="text" name="date" id="date"></div>
        <div class="a"><button type="submit" class="b">保   存</button></div>
    </form>
</div>
<script type="text/javascript">
    function check(){
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