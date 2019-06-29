<%--
  Created by IntelliJ IDEA.
  User: Suwen
  Date: 2019/6/22
  Time: 10:04
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

    <title>记账小程序</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">

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
                    <div class="row">
                        <div class="col-md-12">
                            <div class="banner-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="banner-caption">
                                            <h4>你好, 欢迎使用<em>记账小程序。</em></h4>
                                            <span>AWESOME HTML5 &amp; CSS3 TEMPLATE</span>
                                            <p>是不是长期处于<strong>月光状态</strong>呢？
                                                是不是每个月到手的钱不少却总是感觉<strong>缺钱</strong>呢？
                                                是不是总不知钱花到哪里去了呢？尝试开始<strong>记账</strong>吧！</p>
                                            <div class="primary-button">
                                                <a href="add.jsp">尝试记账</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


            <!-- Right Image -->
            <section class="right-image">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="left-content">
                                <h4>为什么要记账？</h4>
                                <p>约束乱消费行为：如果你平时花钱大手大脚，有记账行为的时候，心理更容易产生负罪感，潜意识里会自觉适当约束自己大额的开支。
                                    <br><br>
                                    管理消费体系：记账三五个月后，就可以从数据中整理分析出自己的消费体系了，哪些方面开销巨大可以缩减也一目了然。
                                    <br><br>
                                    培养个人意志：记账本身是一个繁琐而枯燥的过程，如果能够坚持下来，本身也是一个磨炼意志，提高自身耐心和细致度的挑战。
                                </p>
                                <div class="primary-button">
                                    <a href="add.jsp">尝试记账</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <img src="assets/images/right-image.jpg" alt="">
                        </div>
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
                <form method="get" action="AccountServlet?method=search">
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
</body>


</body>

</html>
