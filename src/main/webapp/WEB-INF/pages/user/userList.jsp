<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <title><fmt:message key="menu.system.user"/></title>
</head>
<body>


<display:table name="users" class="table table-striped table-bordered" requestURI="" id="user" export="false">
    <display:column property="username" paramId="id" titleKey="user.username" escapeXml="true"/>
    <display:column property="fullName" paramId="id" titleKey="user.fullName" escapeXml="true"/>
    <display:column titleKey="td.operation" style="width:30%">
        <a href="${ctx}/system/user/show?id=${user.id}" class="btn btn-primary btn-sm"><fmt:message
                key="button.edit"/> </a>
    </display:column>
</display:table>
</body>
</html>
