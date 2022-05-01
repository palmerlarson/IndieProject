let worth = [
];

//adds to json arr and
const addToArray = () => {
    let name = document.querySelector("#name").value;
    let amount = document.querySelector("#amount").value;
    let type = document.querySelector("#type").value;
    let displayList = document.querySelector(".list");

    //error checking
    if (name == null || amount == null) {
        alert("You must enter values for both fields");
    } else {
        worth.push({"name": name, "income": amount, "type": type});
    }

    //display
    if (type === "wealth") {
        displayList.innerHTML += `<li id='${name}'><button id="btnStatus" class="btn" 
        onclick="deleteItem('${name}')"><i class="fa-solid fa-trash text-lg"></i></button><span> ${name}</span> - <span class="text-lime-500">$ ${amount}</span></li>`;
    } else {
        displayList.innerHTML += `<li id='${name}'><button id="btnStatus" class="btn" 
        onclick="deleteItem('${name}')"><i class="fa-solid fa-trash text-lg"></i></button><span> ${name}</span> - <span class="text-rose-600">$ ${amount}</span></li>`;
    }


    console.log(worth);
}
//deletes item from json arr
const deleteItem = item => {
    let listItem = document.getElementById(item);
    listItem.parentNode.removeChild(listItem);

    const indexOfObject = worth.findIndex(object => {
        return object.name === `${item}`;
    });

    worth.splice(indexOfObject, 1);

    console.log(worth);
}

//sends the json arr to servlet
const submit = () => {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "wealthMapper", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            alert(xhr.response)
        }
    }
    xhr.send(JSON.stringify(worth));
}

console.log(worth);