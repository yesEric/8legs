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
                    <form:input cssClass="form-control" path="username" id="username"/>

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
                    <button type="submit" class="btn btn-primary"><fmt:message key="button.save"/></button>
                </div>
            </div>
        </form:form>
    </div>


</body>
</html>
