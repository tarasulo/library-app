<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Book info</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<h1>Book info</h1>
<p>Book id: ${book.id}</p>
<p>Book title: ${book.title}</p>
<p>Book year: ${book.year}</p>
<p>Book price: ${book.price}</p>
<br>
<p>Book authors: </p>
<c:forEach var="author" items="${book.authors}">
    <p>${author.toString()}</p>
</c:forEach>
<a href="${pageContext.request.contextPath}/book/all">Return to the books page</a>
</body>
</html>
