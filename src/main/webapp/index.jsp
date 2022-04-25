<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
        <a href = "error">Error</a>
        <a href = "infoPage">Information Page</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
        <h3>Email ${email}</h3>
        <p>Finish your sign up <a href="infoPage">here.</a></p>
    </c:otherwise>
</c:choose>
</body>
</html>