<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head><title>Participants</title></head>
<body>

<h2>Participants</h2>
<a href="${pageContext.request.contextPath}/index.html">Home</a>

<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Age</th><th>Phone</th>
        <th>Email</th><th>Batch ID</th><th>Actions</th>
    </tr>

    <c:forEach var="p" items="${participants}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.age}</td>
            <td>${p.phone}</td>
            <td>${p.email}</td>
            <td>${p.batchId}</td>
            <td>
                <a href="editParticipant?id=${p.id}">Edit</a> |
                <a href="deleteParticipant?id=${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
