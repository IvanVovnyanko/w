<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>Create New User</h1>

<form action="/users" method="post">
    Name: <input type="text" name="name" required><br>
    Age: <input type="number" name="age" required><br>
    Email: <input type="email" name="email" required><br>
    <input type="submit" value="Create">
</form>
</body>
</html>