<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/3.3.1/css/bootstrap.css"/>'>
<script src='<c:url value="/webjars/jquery/2.1.3/jquery.js"/>'></script>
<script src='<c:url value="/webjars/bootstrap/3.3.1/js/bootstrap.js"/>'></script>

<link rel="stylesheet" href="<c:url value='/static/css/main.css'/>">
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="<c:url value='/edit'>
                <c:param name="id" value="${item.id}"/>
              </c:url>" method="post">
    <p>
        <label>name</label><br/>
        <input type="text" name="name" value="${item.name}">
    </p>
    <p>
        <label>description</label><br/>
        <input type="text" name="description" value="${item.description}">
    </p>
    <p>
        <label>cost</label><br/>
        <input type="text" name="cost" value="${item.cost}">
    </p>
    <button type="submit">submit</button>
    <br/>
    <a href="<c:url value='/items'/>">back</a>
</form>
</body>
</html>
