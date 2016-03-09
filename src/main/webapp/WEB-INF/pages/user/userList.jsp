<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title><fmt:message key="menu.system.user"/></title>
</head>
<body>

<form:form commandName="user" method="post" action="${ctx}/system/user/search" autocomplete="off"
           cssClass="form-horizontal">

    <div class="form-group">
        <label class="col-md-1 control-label" for="username"><fmt:message key="user.username"/> </label>
        <div class="col-md-2">
            <input name="username" id="username" class="form-control" placeholder="" type="text">
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary btn-sm" type="submit">
                <i class="glyphicon glyphicon-search"></i><fmt:message key="button.search"/>
            </button>
        </div>
    </div>

</form:form>

<p>


    <a href="${ctx}/system/user/add" class="btn btn-primary btn-sm">
        <i class="glyphicon glyphicon-plus"></i>
        <fmt:message
                key="button.add"/> </a>
</p>
<display:table name="users" class="table table-striped table-bordered" requestURI="" id="user" export="false">
    <display:column property="username" paramId="id" titleKey="user.username" escapeXml="true"/>
    <display:column property="fullName" paramId="id" titleKey="user.fullName" escapeXml="true"/>

    <display:column titleKey="td.operation" style="width:30%">
        <a href="${ctx}/system/user/show?id=${user.id}" class="btn btn-primary btn-sm"><fmt:message
                key="button.edit"/> </a>

        <a href="${ctx}/system/user/remove?id=${user.id}" class="btn btn-danger btn-sm"><fmt:message
                key="button.delete"/> </a>
    </display:column>

</display:table>
</body>
</html>
