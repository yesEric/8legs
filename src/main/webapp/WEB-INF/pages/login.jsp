<%@ include file="/common/taglibs.jsp"%>

<html lang="en">
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>


    <link rel="icon" href="<c:url value="/statics/images/favicon.ico"/>"/>


    <!-- Bootstrap Core CSS -->
    <link href="${ctx}/statics/css/bootstrap.min.css" rel="stylesheet">

    <link href="${ctx}/statics/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${ctx}/statics/css/styles.css" rel="stylesheet">


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="index.html"><fmt:message key="webapp.name"/> </a></h1>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-wrapper">
                <div class="box">
                    <div class="content-wrap">
                        <h6><fmt:message key="login.title"/></h6>

                        <%@ include file="/common/message.jsp" %>

                        <form:form commandName="user" method="post" action="/login" autocomplete="off">
                            <fieldset>
                                <div class="form-group">

                                    <form:input cssClass="form-control" path="username" id="username"
                                                placeholder="User Name"/>
                                </div>
                                <div class="form-group">

                                    <form:password cssClass="form-control" path="password" id="password"
                                                   placeholder="Password"/>
                                </div>

                                <div class="checkbox">
                                    <label>
                                        <input name="rememberMe" id="rememberMe" type="checkbox"><fmt:message
                                            key="login.rememberMe"/>
                                    </label>
                                </div>
                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>


<!-- jQuery -->
<script src="${ctx}/statics/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${ctx}/statics/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${ctx}/statics/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${ctx}/statics/js/sb-admin-2.js"></script>
</body>
</html>
