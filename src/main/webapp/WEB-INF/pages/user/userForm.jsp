<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<form:form commandName="user" method="post" action="/user/save" autocomplete="off">
    <form:hidden path="id"/>
    <spring:bind path="user.username"/>
    name:
    <form:input cssClass="form-control" path="username" id="username"/>
    <form:errors path="username" cssClass="help-block"/>
    <p/>
    password<form:password path="password" id="password"/>
    <button type="submit">OK</button>
</form:form>
</body>
</html>
