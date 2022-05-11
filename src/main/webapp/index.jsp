<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body class="dark:bg-gray-900 w-full">
<c:choose>
    <c:when test="${empty userName}">
        <%@include file="includes/noAuthHeader.jsp"%>
        <%@include file="includes/logInButton.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="includes/header.jsp"%>

        <div class="m-auto w-2/5 rounded-xl bg-orange-50 py-40 text-center drop-shadow-2xl">
            <h3>Welcome ${userName}</h3>
            <p>Finish your sign up <a href="infoPage">here.</a></p>
            <p>Go to your dashboard <a href="infoPage">here.</a></p>
        </div>
    </c:otherwise>
</c:choose>

<%@include file="includes/footer.jsp"%>
</body>
</html>