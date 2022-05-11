<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<div class="m-auto w-3/5 mt-4 rounded-xl bg-orange-50 py-10 text-center drop-shadow-2xl">
    <h1 class="text-2xl font-bold my-2">Your Saved Graphs</h1>
    <ul>
        <c:forEach var="liItem" items="${liArr}">
            ${liItem}
        </c:forEach>
    </ul>
</div>
<div class="flex mt-8 mx-4">
    <div class="imageOutput invisible relative w-2/4 ml-10 rounded-xl bg-orange-50 py-2 text-center content-center drop-shadow-2xl z-10">
        <img class="invisible mx-auto" id="captchaImg2"  alt="img" src="#"/>
    </div>

    <div class="tips relative invisible w-2/4 mr-10 rounded-xl bg-orange-50 py-2 text-center content-center drop-shadow-2xl z-10">
        <h1>Tips:</h1>
        <ol>
            <li>List out your debt</li>
            <li>Pay more than the minimum on your credit card</li>
            <li>Calculate your daily interest</li>
            <li>Automate your savings</li>
            <li>Do an annual review of your finances</li>
            <li>Write down your goals</li>
            <li>Have a no-spend day</li>
        </ol>
    </div>

</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>