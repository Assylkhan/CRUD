<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href='<c:url value="/webjars/bootstrap/3.3.1/css/bootstrap.css"/>'>
    <script src='<c:url value="/webjars/jquery/2.1.3/jquery.js"/>'></script>
    <script src='<c:url value="/webjars/bootstrap/3.3.1/js/bootstrap.js"/>'></script>

    <link rel="stylesheet" href="<c:url value='/static/css/main.css'/>">
    <title>Items</title>
</head>
<body>
<table class="table table-striped">
    <th>#</th>
    <th>name</th>
    <th>description</th>
    <th>cost</th>
    <th></th>
    <th></th>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td><a href="<c:url value='/item'>
                            <c:param name="id" value="${item.id}"/>
                        </c:url>">
                    ${item.name}
                </a>
            </td>
            <td>${item.description}</td>
            <td>${item.cost} $</td>
            <td>
                <a href="
                    <c:url value='/edit'>
                        <c:param name='id' value='${item.id}'/>
                    </c:url>">
                    <strong>edit</strong>
                </a>
            </td>
            <td>
                <form onsubmit="return confirm('Do you really want to submit the form?');" action="
                    <c:url value='/delete'>
                        <c:param name='id' value='${item.id}'/>
                    </c:url>" method="post">
                    <button type="submit" class="btn btn-primary">
                        <strong>delete</strong>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/new'/>"><strong>new</strong></a>
</body>
</html>
