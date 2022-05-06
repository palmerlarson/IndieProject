<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<form action="infoPage" method="POST">
    <input type="text" name="fName" />
    <input type="text" name="lName" />
    <input type="number" name="income" />
    <input type="submit" value="submit"/>
</form>


<h1>${userName}</h1>

<%@include file="includes/footer.jsp"%>
</body>
</html>
