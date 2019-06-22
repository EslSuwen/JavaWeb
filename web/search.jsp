<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 11:19
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
<div align="center">
    <form action="ShangServlet?method=search" method="post" onsubmit="return check()">
        <div class="a">
            消费名称<input type="text" id="name" name="name" />
        </div>
        <div class="a">
            消费日期<input type="text" id="date" name="date"/>
        </div>
        <div class="a">
            <button type="submit" class="b">查   询</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    function check() {
        var name=document.getElementById("name");
        var date=document.getElementById("date");

        //非空
        if(name.value == '' && date.value == '' ) {
            alert('请填写一个条件');
            return false;
        }
    }
</script>
</body>
</html>