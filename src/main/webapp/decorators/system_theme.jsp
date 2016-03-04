<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp" %>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="theme" content="system_theme"/>
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
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class"
                                                                                                  writeEntireProperty="true"/>>
<%@ include file="/common/menu.jsp" %>


<div class="page-content">
    <div class="row">
        <div class="col-md-2">
            <div class="sidebar content-box" style="display: block;">
                <ul class="nav">

                    <li class="current submenu">
                        <a href="#"><i class="glyphicon glyphicon-user"></i> <fmt:message key="menu.system.user"/> </a>
                        <!-- Sub menu -->
                        <ul style="display: block">
                            <li><a href="${ctx}/system/user/list"><fmt:message key="menu.system.user"/></a></li>
                            <li><a href="#"><fmt:message key="menu.system.role"/></a></li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-md-10">


            <div class="content-box-large">
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