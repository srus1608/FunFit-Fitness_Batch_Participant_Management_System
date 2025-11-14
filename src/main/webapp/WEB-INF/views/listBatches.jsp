<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head><title>Batches</title></head>
<body>

<h2>Batches</h2>
<a href="${pageContext.request.contextPath}/index.html">Home</a>

<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Timing</th><th>Capacity</th><th>Actions</th>
    </tr>

    <c:forEach var="b" items="${batches}">
        <tr>
            <td>${b.id}</td>
            <td>${b.name}</td>
            <td>${b.timing}</td>
            <td>${b.capacity}</td>
            <td>
                <a href="editBatch?id=${b.id}">Edit</a> |
                <a href="deleteBatch?id=${b.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
