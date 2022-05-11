<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<div>
    <ul>
        <c:forEach var="liItem" items="${liArr}">
            ${liItem}
        </c:forEach>
    </ul>
</div>

<div class="imgOutput">
    <img class="invisible" id="captchaImg2"  alt="img" src="#"/>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>