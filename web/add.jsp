<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>新增消费账单</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">

    <style type="text/css">
        .a {
            margin-top: 20px;
        }

        .b {
            font-size: 20px;
            width: 160px;
            color: white;
            background-color: rgba(83, 91, 160, 1);
        }
    </style>


</head>

<body class="is-preload">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->
            <header id="header">
                <div class="logo">
                    <a href="index.html">记账小程序</a>
                </div>
            </header>

            <!-- Banner -->
            <section class="main-banner">
                <div class="container-fluid">
                    <div align="center">
                        <form action="AccountServlet?method=add" method="post" onsubmit="return check()">
                            <div class="a">消费名称:<input type="text" name="name" id="name"></div>
                            <div class="a">消费金额:<input type="text" name="money" id="money"></div>
                            <div class="a">消费日期:<input type="text" name="date" id="date"></div>
                            <div class="a">
                                <button type="submit" class="b">保 存</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>

        </div>
    </div>

    <!-- Sidebar -->
    <div id="sidebar">

        <div class="inner">

            <!-- Search Box -->
            <section id="search" class="alt">
                <form method="get" action="#">
                    <input type="text" name="search" id="search" placeholder="Search..."/>
                </form>
            </section>

            <!-- Menu -->
            <nav id="menu">
                <ul>
                    <li><a href="main.jsp">Homepage</a></li>
                    <li><a href="add.jsp">新增消费账单</a></li>
                    <li><a href="AccountServlet?method=delete">删除消费账单</a></li>
                    <li><a href="AccountServlet?method=list">修改消费账单</a></li>
                    <li><a href="search.jsp">查询消费账单</a></li>
                    <li><a href="AccountServlet?method=show">查看所有账单</a></li>
                </ul>
            </nav>


            <!-- Footer -->
            <footer id="footer">
                <p class="copyright">Copyright &copy; 2019
            </footer>

        </div>
    </div>

</div>

<!-- Scripts -->
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/transition.js"></script>
<script src="assets/js/owl-carousel.js"></script>
<script src="assets/js/custom.js"></script>
<script type="text/javascript">
    function check() {
        var name = document.getElementById("name");
        var money = document.getElementById("money");
        var date = document.getElementById("date");
        if (name.value == '') {
            alert('消费名称为空');
            name.focus();
            return false;
        }
        if (money.value == '') {
            alert('消费金额为空');
            money.focus();
            return false;
        }
        if (date.value == '') {
            alert('消费日期为空');
            date.focus();
            return false;
        }
    }
</script>
</body>


</body>

</html>
