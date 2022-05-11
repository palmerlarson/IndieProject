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

        <div class="m-auto w-2/5 mt-8 rounded-xl bg-orange-50 py-4 text-center drop-shadow-2xl">
            <img class="mx-auto object-contain h-48 w-96" id="captchaImg2"  alt="img" src="images/Wdev-logos.jpeg"/>
            <h1 class="text-2xl font-bold my-2">Welcome ${userName}</h1>
            <h1>Finish your sign up <a class="cursor-pointer text-blue-600 hover:underline-offset-4" href="infoPage">here.</a></h1>
        </div>
    </c:otherwise>
</c:choose>

<%@include file="includes/footer.jsp"%>
</body>
</html>