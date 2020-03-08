<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<br>
<section>
    <hr>
    <a href="users/">Users</a>
    <hr>
    <form method="post" action="users/login">
<%--        <spring:message code="app.login"/>: <select name="userId">--%>
    <select name="userId">
        <option value="1000" selected>User</option>
        <option value="1001">Admin</option>
    </select>
    <button type="submit">LogIn</button>
<%--        <button type="submit"><spring:message code="common.select"/></button>--%>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>