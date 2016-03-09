<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="theme" content="basic_theme" />
    <link rel="icon" href="<c:url value="/statics/images/favicon.ico"/>"/>


    <!-- Bootstrap Core CSS -->
    <link href="${ctx}/statics/css/bootstrap.min.css" rel="stylesheet">

    <link href="${ctx}/statics/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${ctx}/statics/css/styles.css" rel="stylesheet">




    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>
    <t:assets type="css"/>
    <decorator:head/>
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

<%@ include file="/common/menu.jsp" %>

<div class="page-content">
    <div class="row">
        <div class="col-md-2">
            <div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <!-- Main menu -->
                    <li class="current"><a href="index.html"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
                    <li><a href="calendar.html"><i class="glyphicon glyphicon-calendar"></i> Calendar</a></li>
                    <li><a href="stats.html"><i class="glyphicon glyphicon-stats"></i> Statistics (Charts)</a></li>
                    <li><a href="tables.html"><i class="glyphicon glyphicon-list"></i> Tables</a></li>
                    <li><a href="buttons.html"><i class="glyphicon glyphicon-record"></i> Buttons</a></li>
                    <li><a href="editors.html"><i class="glyphicon glyphicon-pencil"></i> Editors</a></li>
                    <li><a href="forms.html"><i class="glyphicon glyphicon-tasks"></i> Forms</a></li>
                    <li class="submenu">
                        <a href="#">
                            <i class="glyphicon glyphicon-list"></i> Pages
                            <span class="caret pull-right"></span>
                        </a>
                        <!-- Sub menu -->
                        <ul>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="signup.html">Signup</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-10">




            <div class="content-box-large">
                <legend><decorator:title/></legend>
                <decorator:body/>

            </div>
        </div>
    </div>
</div>

<footer class="footer navbar-fixed-bottom ">
    <div class="container ">

        <div class="copy text-center">
            Copyright 2014 <a href='#'>Website</a>
        </div>

    </div>
</footer>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- jQuery -->
<script src="${ctx}/statics/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${ctx}/statics/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${ctx}/statics/js/custom.js"></script>




</body>
</html>