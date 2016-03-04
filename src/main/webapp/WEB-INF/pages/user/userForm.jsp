<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title><fmt:message key="user.info.title"/></title>
</head>
<body>


<div class="panel-heading">


    <div class="panel-body">
        <form:form commandName="user" method="post" action="${ctx}/system/user/save" autocomplete="off"
                   cssClass="form-horizontal">
    <form:hidden path="id"/>
    <spring:bind path="user.username"/>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label"><fmt:message key="user.username"/> </label>
                <div class="col-sm-4">

                    <form:input cssClass="form-control" path="username" id="username"
                                disabled="${user.id!=null? 'true':'false'}"/>

                </div>
            </div>
            <div class="form-group">
                <label for="fullName" class="col-sm-2 control-label"><fmt:message key="user.fullName"/> </label>
                <div class="col-sm-4">

                    <form:input cssClass="form-control" path="fullName" id="fullName"/>

                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label"><fmt:message key="user.password"/> </label>
                <div class="col-sm-4">

                    <form:password path="password" id="password" cssClass="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:forEach items="${roles}" var="role">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" value="${role.id}"
                                       name="roleId" ${user.roleDTOs.contains(role) ? "checked":""}> ${role.name}
                            </label>
                        </div>
                    </c:forEach>


                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary"><fmt:message key="button.save"/></button>
                </div>
            </div>
        </form:form>
    </div>


</body>
</html>
