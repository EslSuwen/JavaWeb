<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录</title>
</head>
<body>
<div class="login" style="text-align:center;">
    <fieldset>
        <legend>用户登录</legend>
        <br/>
        <form action="login" method="post" name="login">
            用户名：<input type="text" name="username"/> <br/> <br/> 密&nbsp;码：<input
                type="password" name="password"/> <br/> <br/> <input
                type="submit" value="登录"/>
        </form>
    </fieldset>
</div>

</body>
</html>