<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>wDev - Homepage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <%@include file="includes/noAuthHeader.jsp"%>
        <%@include file="includes/logInButton.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="includes/header.jsp"%>

        <div class="m-auto w-2/5 rounded-xl bg-orange-50 py-40 text-center drop-shadow-2xl">
            <h3>Welcome ${userName}</h3>
            <h3>Email ${email}</h3>
            <p>Finish your sign up <a href="infoPage">here.</a></p>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>