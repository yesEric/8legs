<div class="header fixed-top">
    <div class="container">
        <div>
            <div class="col-md-2">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="${ctx}/index.jsp"><fmt:message key="webapp.name"/> </a></h1>
                </div>
            </div>
            <div class="col-md-7">
                <div class="navbar " role="banner">
                    <nav class="collapse navbar-collapse bs-navbar-collapse navbar-left" role="navigation">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="#"> <fmt:message key="menu.site"/></a>

                            </li>
                            <li class="current">
                                <a href="${ctx}/order/list"><fmt:message key="menu.order"/></a>

                            </li>
                            <li>
                                <a href="#"><fmt:message key="menu.product"/></a>

                            </li>

                            <li>
                                <a href="#"><fmt:message key="menu.service"/></a>

                            </li>
                            <li>
                                <a href="#"><fmt:message key="menu.store"/></a>

                            </li>
                            <li>
                                <a href="#"><fmt:message key="menu.member"/></a>

                            </li>
                            <li>
                                <a href="#"><fmt:message key="menu.marketing"/></a>

                            </li>
                            <li>
                                <a href="#"><fmt:message key="menu.report"/></a>

                            </li>
                            <li>
                                <a href="${ctx}/system/user/list"><fmt:message key="menu.system"/></a>

                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-md-3">
                <div class="navbar navbar-inverse" role="banner">
                    <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message
                                        key="menu.account"/> <b class="caret"></b></a>
                                <ul class="dropdown-menu animated fadeInUp">
                                    <li><a href="profile.html"><fmt:message key="menu.account.profile"/></a></li>
                                    <li><a href="${ctx}/logout"><fmt:message key="menu.account.logout"/></a></li>
                                </ul>


                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>