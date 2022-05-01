<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>wDev - WealthMapper</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <link rel="stylesheet" href="styles/index.css">
    <script src="https://kit.fontawesome.com/ae280f9e8b.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="scripts/mapper.js" async></script>
</head>
<body>
<%@include file="includes/header.jsp"%>

<div class="flex">
    <div class="w-2/5 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl">
        <h4 class="text-lg font-bold">Assets</h4>
        <form action="wealthMapper" method="POST">
            <div>
                <label for="iName">Name:</label>
                <input class="nameIncome mb-2 text-sm font-bold text-gray-700" type="text" name="iName" id="iName" />
            </div>
            <div>
                <label for="iAmount">Amount:</label>
                <input class="income mb-2 text-sm font-bold text-gray-700" type="number" name="iAmount" id="iAmount" />
            </div>
            <button class="rounded border border-gray-400 bg-white py-2 px-4 font-semibold text-gray-800 shadow hover:bg-gray-100" type="button" onclick="addToArray(w)">Add</button>
        </form>
        <br />
        <h4 class="text-lg font-bold">Debt</h4>
        <form action="wealthMapper" method="POST">
            <div>
                <label for="iName">Name:</label>
                <input class="nameIncome mb-2 text-sm font-bold text-gray-700" type="text" name="iName" id="iName" />
            </div>
            <div>
                <label for="iAmount">Amount:</label>
                <input class="income mb-2 text-sm font-bold text-gray-700" type="number" name="iAmount" id="iAmount" />
            </div>
            <button class="rounded border border-gray-400 bg-white py-2 px-4 font-semibold text-gray-800 shadow hover:bg-gray-100" type="button" onclick="addToArray(d)">Add</button>
        </form>
        <br />
        <button class="rounded border border-gray-400 bg-green-400 py-2 px-4 font-semibold text-gray-800 shadow hover:bg-green-500" type="button" onclick="submit()">Submit</button>
    </div>

    <div class="output w-3/5 rounded-xl bg-orange-50 py-2 text-center drop-shadow-2xl ml-4">
        <h1 class="text-xl font-bold">Wealth & Debt</h1>
        <ul class="list"></ul>
    </div>
</div>


<div class="output">
    <ul class="list"></ul>
</div>
</body>
</html>
