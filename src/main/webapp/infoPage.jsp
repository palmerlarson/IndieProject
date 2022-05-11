<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>
<div class="flex mt-4 mx-20">
    <div class="infoDiv m-auto w-2/5 rounded-xl mr-4 bg-orange-50 py-4 text-center drop-shadow-2xl">
        <h1 class="text-2xl font-bold my-2">Enter or Update your info</h1>
        <form action="infoPage" method="POST">
            <c:choose>
                <c:when test="${fName == null || lName == null || income == 0}">
                    <div class="my-2">
                        <label for="firstName">First Name</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="text" name="fName" id="firstName"/>
                    </div>
                    <div class="my-2">
                        <label for="lastName">Last Name</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="text" name="lName" id="lastName"/>
                    </div>
                    <div class="my-2">
                        <label for="gross_income">Gross Yearly Income</label>
                        <input class="mb-2 text-sm font-bold text-gray-700" type="number" name="income" id="gross_income"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="my-2">
                        <label for="pulledFname">First Name:</label>
                        <input type="text" name="fName" id="pulledFname" value="${fName}"/>
                    </div>
                    <div class="my-2">
                        <label for="pulledLname">Last Name:</label>
                        <input type="text" name="lName" id="pulledLname" value="${lName}"/>
                    </div>
                    <div class="my-2">
                        <label for="pulledGincome">Yearly Income:</label>
                        <input type="number" name="income" id="pulledGincome" value="${income}"/>
                    </div>
                </c:otherwise>
            </c:choose>
            <input class="infoBtn rounded border border-gray-400 bg-green-400 py-2 px-4 font-semibold text-gray-800 shadow hover:bg-green-500 mt-4" type="submit" value="Submit"/>
        </form>
    </div>

    <div class="m-auto w-3/5 rounded-xl bg-orange-50 ml-4 py-4 text-center drop-shadow-2xl">
        <c:choose>
            <c:when test="${fName == null || lName == null || income == 0}">
                <h1 class="text-2xl font-bold my-2">Enter your information</h1>
                <h1 class="text-2xl font-bold my-2">Username: ${userName}</h1>
            </c:when>
            <c:otherwise>
                <h1 class="text-2xl font-bold my-2">Username: ${userName}</h1>
                <h1 class="text-2xl font-bold my-2">First Name: ${fName}</h1>
                <h1 class="text-2xl font-bold my-2">Last Name: ${lName}</h1>
                <h1 class="text-2xl font-bold my-2">Income: $${income}</h1>
            </c:otherwise>
        </c:choose>
    </div>
</div>



<%@include file="includes/footer.jsp"%>
</body>
</html>
