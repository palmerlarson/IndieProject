<%--
  Created by IntelliJ IDEA.
  User: palmerlarson
  Date: 4/1/22
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InfoPage</title>
</head>
<body>
<p>Importing user info here</p>
<form action="/IndieProject_war/infoPage" method="POST">
    <input type="text" name="fName" />
    <input type="text" name="lName" />
    <input type="number" name="income" />
    <input type="submit" value="submit"/>
</form>
</body>
</html>