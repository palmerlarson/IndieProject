let incomeSourcesArr = [
];

//adds to json arr and
const addToArray = kind => {
    let nInput = document.querySelector(".nameIncome").value;
    let iInput = document.querySelector(".income").value;
    let displayDiv = document.querySelector(".output");
    let displayList = document.querySelector(".list");

    incomeSourcesArr.push({"name": nInput, "income": iInput});

    // displayDiv.innerHTML += `<h2>Name: ${nInput}, ${iInput}</h2>`;
    displayList.innerHTML += `<li id='${nInput}'><button id="btnStatus" class="btn" 
        onclick="deleteItem('${nInput}')"><i class="fa-solid fa-trash"></i></button><span> ${nInput}</span> - <span>${iInput}</span></li>`;

    console.log(incomeSourcesArr);
}
//deletes item from json arr
const deleteItem = item => {
    let listItem = document.getElementById(item);
    listItem.parentNode.removeChild(listItem);

    const indexOfObject = incomeSourcesArr.findIndex(object => {
        return object.name === `${item}`;
    });

    incomeSourcesArr.splice(indexOfObject, 1);

    console.log(incomeSourcesArr);
}

//sends the json arr to servlet
const submit = () => {
    let displayDiv = document.querySelector(".output");
}

console.log(incomeSourcesArr);