<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome to our Library
<a href="${pageContext.request.contextPath}/injectdata">Inject Data</a>
<a href="${pageContext.request.contextPath}/book/create">Add new Book</a>
<a href="${pageContext.request.contextPath}/book/all">Add Books</a>
<a href="${pageContext.request.contextPath}/book/find?title=${book.title}">Find book by Title</a>
</body>
</html>
