<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
<p>${item.name}</p>

<p>${item.description}</p>

<p>${item.cost}</p>

<p>
    <a href="<c:url value='/items'/>">
        back
    </a>
</p>
</body>
</html>
