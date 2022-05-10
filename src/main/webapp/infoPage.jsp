<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<form action="infoPage" method="POST">
    <label for="firstName">First Name</label>
    <input type="text" name="fName" id="firstName"/>
    <label for="lastName">Last Name</label>
    <input type="text" name="lName" id="lastName"/>
    <label for="gross_income">Gross Yearly Income</label>
    <input type="number" name="income" id="gross_income"/>
    <input type="submit" value="submit"/>
</form>


<h1>${userName}</h1>

<%@include file="includes/footer.jsp"%>
</body>
</html>
