<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Thêm mới nguowif dung </h1>
            <form action="<%=request.getContextPath()%>/user" method="POST">
                <div class="form-group">
                    <label >Ten </label>
                    <input type="text" class="form-control"  name="name">
                </div>
                <div class="form-group">
                    <label >Email </label>
                    <input type="text" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label>Country </label>
                    <input type="text" class="form-control"  name="country">
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
