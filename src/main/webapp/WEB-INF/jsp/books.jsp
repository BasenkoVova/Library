<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>--%>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <hr>
    <a href="books/create">add</a>
    <hr>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>author</th>
                <th>date</th>
                <th>price</th>
                <th></th>
                <th></th>
<%--                <th></th>--%>
            </tr>
        </thead>
        <c:forEach items="${books}" var="book">
            <jsp:useBean id="book" scope="page" type="library.model.Book"/>
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.date}</td>
            <td>${book.price}</td>
            <td><a href="books/update?id=${book.id}">update</a></td>
            <td><a href="books/delete?id=${book.id}">delete</a></td>
<%--            <td><a href="books/subscribe?id=${book.id}">subscribe</a></td>--%>
        </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>