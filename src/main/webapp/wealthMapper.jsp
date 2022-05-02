<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/head.jsp"%>
<body>
<%@include file="includes/header.jsp"%>

<div class="flex">
    <div class="w-2/4 ml-20 mr-2 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl">
        <h4 class="text-lg font-bold">Assets</h4>
        <form class="formInput" action="wealthMapper" method="POST">
            <div>
                <label for="name">Name:</label>
                <input class="nameIncome mb-2 text-sm font-bold text-gray-700" type="text" name="name" id="name" />
            </div>
            <div>
                <label for="amount">Amount:</label>
                <input class="income mb-2 text-sm font-bold text-gray-700" type="number" name="amount" id="amount" />
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

    <div class="output w-2/4 mr-20 ml-2 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl">
        <h1 class="text-xl font-bold mb-1">Wealth & Debt</h1>
        <ul class="list"></ul>
    </div>
</div>


<div class="output">
    <ul class="list"></ul>
</div>

<%@include file="includes/footer.jsp"%>
</body>
</html>
