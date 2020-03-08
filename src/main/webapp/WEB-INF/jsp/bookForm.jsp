<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <jsp:useBean id="book" type="library.model.Book" scope="request"/>
    <h3><${book.isNew() ? 'add' : 'edit'}></h3>
    <hr>
    <form method="post" action="books">
        <input type="hidden" name="id" value="${book.id}">
        <dl>
            <dt>name</dt>
            <dd><input type="text" value="${book.name}"   name="name_book" required></dd>
        </dl>
        <dl>
            <dt>author</dt>
            <dd><input type="text" value="${book.author}"  name="author_book" required></dd>
        </dl>
        <dl>
            <dt>data</dt>
            <dd><input type="text" value="${book.date}" name="date_book" required></dd>
        </dl>
        <dl>
            <dt>price</dt>
            <dd><input type="number" value="${book.price}" name="price_book" required></dd>
        </dl>

        <button type="submit">save</button>
        <button onclick="window.history.back()" type="button">cancel</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
