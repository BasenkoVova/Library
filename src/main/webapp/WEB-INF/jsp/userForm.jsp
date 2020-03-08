<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="user" type="library.model.User" scope="request"/>
    <h3><${user.isNew() ? 'add' : 'edit'}></h3>
    <hr>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">

        <dl>
            <dt>name</dt>
            <dd><input type="text" value="${user.name}"   name="name_user" required></dd>
        </dl>

        <dl>
            <dt>email</dt>
            <dd><input type="text" value="${user.email}"   name="email_user" required></dd>
        </dl>

        <button type="submit">save</button>
        <button onclick="window.history.back()" type="button">cancel</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
