<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<div>
<%@include file="includes/header.jsp"%>
<body>
<div class="flex mt-8">
    <div class="m-auto w-2/5 rounded-xl bg-orange-50 py-40 text-center drop-shadow-2xl">
        <form action="infoPage" method="POST">
            <c:choose>
                <c:when test="${fName == null || lName == null || income == 0}">
                    <div>
                        <label for="firstName">First Name</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="text" name="fName" id="firstName"/>
                    </div>
                    <div>
                        <label for="lastName">Last Name</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="text" name="lName" id="lastName"/>
                    </div>
                    <div>
                        <label for="gross_income">Gross Yearly Income</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="number" name="income" id="gross_income"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <label for="pulledFname">First Name</label>
                        <input type="text" name="fName" id="pulledFname" value="${fName}"/>
                    </div>
                    <div>
                        <label for="pulledLname">Last Name</label>
                        <input type="text" name="lName" id="pulledLname" value="${lName}"/>
                    </div>
                    <div>
                        <label for="pulledGincome">Gross Yearly Income</label>
                        <input type="number" name="income" id="pulledGincome" value="${income}"/>
                    </div>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="submit"/>
        </form>
    </div>
</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>
