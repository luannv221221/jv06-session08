
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách danh mục</h1>
    <table border="1" cellspacing="0">
        <tr>
            <td>STT</td>
            <td>ID</td>
            <td>Name</td>
            <td>Status</td>

            <td colspan="2">Action</td>
        </tr>
        <c:forEach items='${list}' var="item" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${item.categoryId}</td>
                <td>${item.categoryName}</td>
                <td>${item.categoryStatus ? "Active" : "Nghĩ đã"}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="danh-muc?action=add">Them moi</a>
</body>
</html>
