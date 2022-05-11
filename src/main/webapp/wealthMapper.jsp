<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<div class="flex mt-8">
    <div class="w-2/4 relative ml-20 mr-2 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl">
        <h4 class="text-lg font-bold">Monthly Income/Debt</h4>
        <c:choose>
            <c:when test="${empty mIncome}">
                <a href="infoPage">Add your income here</a><span class="monthly hidden">0</span>
            </c:when>
            <c:otherwise>
                <p>Your total yearly income has been entered as $<span class="monthly">${mIncome}</span></p>
            </c:otherwise>
        </c:choose>
        <form class="formInput" action="wealthMapper" method="POST">
            <div>
                <label for="name">Name:</label>
                <input class="nameIncome mb-2 text-sm font-bold text-gray-700" type="text" name="name" id="name" />
            </div>
            <div>
                <label for="amount">Amount:</label>
                <input class="amount mb-2 text-sm font-bold text-gray-700" type="number" name="amount" id="amount" />
            </div>
            <div>
                <label for="type">Type:</label>
                <select name="type" id="type">
                    <option value="wealth">Wealth</option>
                    <option value="debt">Debt</option>
                </select>
            </div>

            <button class="rounded border border-gray-400 bg-white py-2 px-4 font-semibold text-gray-800 shadow hover:bg-gray-100 mt-2" type="button" onclick="addToArray()">Add</button>
        </form>
        <br>
        <button class="rounded border border-gray-400 bg-green-400 py-2 px-4 font-semibold text-gray-800 shadow hover:bg-green-500" type="button" onclick="submit()">Submit</button>
    </div>

    <div class="output relative w-2/4 mr-20 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl z-10">
        <h1 class="text-xl font-bold mb-1">Wealth & Debt</h1>
        <div>
            <ul class="list">
                <c:choose>
                    <c:when test="${empty mIncome}">
                    </c:when>
                    <c:otherwise>
                        <li id='mIncome'><button id="btnStatus" class="btn"
                                                 onclick="deleteItem('mIncome')"><i class="fa-solid fa-trash text-lg"></i></button><span> Monthly Income</span> - $<span class="monthly text-lime-500">${mIncome}</span></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="totals static inset-x-0 bottom-0">
            <h3 class="wealthT inline-block">Wealth: $${mIncome}</h3>
            <h3 class="debtT inline-block">Debt: $0</h3>
        </div>
        <div class="configBtn hidden static inset-x-0 bottom-0">
            <button class="rounded border border-gray-400 bg-white py-2 px-4 font-semibold text-gray-800 shadow hover:bg-gray-100 mt-2" type="button" onclick="save()">Save Config</button>
        </div>
    </div>

</div>

<div class="flex mt-8 mx-4 content-center">
    <div class="imgOutput invisible relative w-2/4 ml-10 rounded-xl bg-orange-50 py-2 text-center content-center drop-shadow-2xl z-10">
        <img class="invisible object-fill mx-auto" id="captchaImg"  alt="img" src="#"/>
    </div>

    <div class="tips invisible relative w-2/4 mr-10 rounded-xl bg-orange-50 py-2 text-center content-center drop-shadow-2xl z-10">
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
