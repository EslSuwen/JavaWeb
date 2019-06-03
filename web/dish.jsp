<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="package1.Dish" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<ul>
    <%
        HttpSession session1 = request.getSession();
        List<Dish> dishList = (List<Dish>) session1.getAttribute("dishList");
        for (Dish d : dishList) {
    %>
    <li><%=d.getName() %>  <%=d.getIsMeat() %>   <%=d.getPrice() %>
    </li>
    <%} %>
</ul>
</body>
</html>